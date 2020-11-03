package Servlet;

import BeanFactory.BeanFactory;
import Entity.Dinnertable;
import Entity.Food;
import Entity.Foodtype;
import Service.DinnertableService;
import Service.FoodService;
import Service.FoodtypeService;
import Service.Impl.DinnertableServiceImpl;
import Utils.Condition;
import Utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FoodServlet")
public class FoodServlet extends HttpServlet {

    private FoodService foodService = BeanFactory.getInstance("FoodService", FoodService.class);
    private DinnertableService DinnerService = BeanFactory.getInstance("DinnertableService", DinnertableService.class);
    private FoodtypeService typeService = BeanFactory.getInstance("typeService", FoodtypeService.class);
    private String uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if("foodDetail".equals(method)){
            foodDetail(request,response);
        }

    }

    public void foodDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            HttpSession session = request.getSession();
            //获取餐桌id，根据id查，再把查询结果保存到session
            Object obj = session.getAttribute("Dinnertable");
            if(obj==null) {
                //只在第一次时查询餐桌对象
                String tableId = request.getParameter("tableId");
                Dinnertable dt = DinnerService.findById(Integer.parseInt(tableId));
                //保存到session
                session.setAttribute("Dinnertable", dt);
            }

            //查询所有菜品
            PageBean<Food> pb = new PageBean<Food>();
            //获取当前页
            String currPage = request.getParameter("currentPage");
            if(currPage==null || "".equals(currPage.trim())){
                pb.setCurrentPage(1);
            }else {
                pb.setCurrentPage(Integer.parseInt(currPage));
            }

            //条件对象
            Condition condition = new Condition();
            //分页参数,菜系id
            String foodTypeId = request.getParameter("foodType_id");
            if(foodTypeId!=null){
                condition.setFoodType_id(Integer.parseInt(foodTypeId));
            }
            //分页参数,菜名
            String foodName = request.getParameter("foodName");
            if(foodName!=null){
                condition.setFoodName(foodName);
            }

            //设置条件对象到pb
            pb.setCondition(condition);

            //分页查询
            foodService.getAll(pb);
            request.setAttribute("pb",pb);


            //查询所有菜品信息
            List<Foodtype> listFoodtype = typeService.findAll();
            request.setAttribute("listFoodtype",listFoodtype);
            uri="/app/detail/caidan.jsp";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
