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

//获取类型列表的servlet
@WebServlet(name = "GetTypeListServlet",urlPatterns = "/get_type_list")
public class GetTypeListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> list = null;
        list = gService.getTypeList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("goods_add.jsp").forward(request,response);
    }
}
