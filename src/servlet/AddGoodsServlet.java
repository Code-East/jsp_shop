package servlet;
import model.Goods;
import org.apache.commons.beanutils.BeanUtils;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddGoodsServlet",urlPatterns = "/add_goods")
public class AddGoodsServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods = new Goods();

//        goods.setName(request.getParameter("name"));
//        goods.setCover(request.getParameter("cover"));
//        goods.setImage1(request.getParameter("image1"));
//        goods.setImage2(request.getParameter("image2"));
//        goods.setPrice(Float.parseFloat(request.getParameter("price")));
//        goods.setStock(Integer.parseInt(request.getParameter("stock")));
//        goods.setType_id(Integer.parseInt(request.getParameter("type_id")));
//        goods.setIntro(request.getParameter("intro"));
        try {
            BeanUtils.copyProperties(goods,request.getParameterMap());
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException");
            e.printStackTrace();
        }
        System.out.println("this is add");
        gService.addGoods(goods);
        request.getRequestDispatcher("goods_list").forward(request,response);
    }
}