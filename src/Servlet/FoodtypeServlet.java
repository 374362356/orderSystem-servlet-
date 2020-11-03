package Servlet;

import BeanFactory.BeanFactory;
import Entity.Foodtype;
import Service.FoodtypeService;

import java.io.IOException;
import java.util.List;

public class FoodtypeServlet extends javax.servlet.http.HttpServlet {

    //调用的菜系service
    private FoodtypeService typeService = BeanFactory.getInstance("typeService", FoodtypeService.class);
    private String uri;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if("addFoodtype".equals(method)){
            //添加菜系
            addFoodtype(request,response);
        }else if("list".equals(method)){
            //列表展示
            list(request,response);
        }else if("viewUpdate".equals(method)){
            //进入更新页
            viewUpdate(request,response);
        }else if("update".equals(method)){
            //更新
            update(request,response);
        } else if("delete".equals(method)){
            //删除
            delete(request,response);

        }
    }

    public void addFoodtype(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        //获取请求封装
        try{
            String foodtypeName = request.getParameter("foodtypeName");
            Foodtype ft = new Foodtype();
            ft.setTypeName(foodtypeName);

            typeService.save(ft);
            uri="/foodType?method=list";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    public void list(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        try{
            List<Foodtype> list = typeService.findAll();
            //保存
            request.setAttribute("listfoodType",list);
            //跳到菜系列表
            uri="/sys/type/foodtype_list.jsp";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    public void viewUpdate(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        try{
            String foodtypeId = request.getParameter("id");
            int id = Integer.parseInt(foodtypeId);
            Foodtype ft = typeService.findByid(id);
            //保存
            request.setAttribute("foodType",ft);
            uri="/sys/type/foodtype_update.jsp";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    public void update(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        try{
            String foodtypeId = request.getParameter("id");
            int id =Integer.parseInt(foodtypeId);
            String name = request.getParameter("foodTypeName");

            //封装
            Foodtype foodtype = new Foodtype();
            foodtype.setId(id);
            foodtype.setTypeName(name);
            //调用更新
            typeService.update(foodtype);
            uri="/foodType?method=list";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    public void delete(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        try{
            String foodtypeId = request.getParameter("id");
            int id =Integer.parseInt(foodtypeId);

            //调用删除
            typeService.delete(id);
            uri="/foodType?method=list";
        }catch (Exception e){
            e.printStackTrace();
            uri="error.jsp";
        }

       response.sendRedirect(request.getContextPath()+uri);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
