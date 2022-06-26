package servlet;

import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet",urlPatterns = "/delete_goods")
public class DeleteUserServlet extends HttpServlet {
    protected GoodsService gService = new GoodsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        gService.delete(id);
        request.getRequestDispatcher("/goods_list").forward(request,response);
    }

    protected void doPost(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        doGet(request,response);
    }
}
