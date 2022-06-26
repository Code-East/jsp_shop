package servlet;

import model.Type;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowTypeListServlet",urlPatterns = "/show_type_list")
public class ShowTypeListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Type> list = null;
        list = gService.getTypeList();
        request.setAttribute("list",list);
        request.setAttribute("type_id",id);
        request.getRequestDispatcher("/goods_edit_show").forward(request,response);
    }
}
