package servlet;

import model.Goods;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "GoodsUpdateServlet",urlPatterns = "/goods_update")
public class GoodsUpdateServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Goods g = new Goods();
        try {
            BeanUtils.copyProperties(g,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        gService.updateGoods(g);
        request.getRequestDispatcher("/goods_list").forward(request,response);
    }
//    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
