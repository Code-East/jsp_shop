package servlet;

import model.Goods;
import model.User;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsEditShowServlet",urlPatterns = "/goods_edit_show")
public class GoodsEditShowServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) request.getAttribute("type_id");
        List list = (List) request.getAttribute("list");
        Goods goods = gService.getGoodsById(id);
        request.setAttribute("list",list);
        request.setAttribute("g",goods);
        request.getRequestDispatcher("/goods_update.jsp").forward(request,response);
    }
}
