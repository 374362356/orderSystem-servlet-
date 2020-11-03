package Servlet;

import BeanFactory.BeanFactory;
import Entity.Dinnertable;
import Service.DinnertableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    //创建service
    private DinnertableService DinnerService = BeanFactory.getInstance("DinnertableService", DinnertableService.class);
    private String uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if(null==method){
            method="listTable";
        }
        if("listTable".equals(method)){
            //首页
            listTable(request,response);
        }

    }

    public void listTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            //查询所有未预定
            List<Dinnertable> list = DinnerService.findByNoUse();
            request.setAttribute("listDinnerTable",list);
            uri="/app/index.jsp";
        }catch (Exception e){
            e.printStackTrace();
            uri="/error.jsp";
        }

        request.getRequestDispatcher(uri).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
