package servlet;

import model.Page;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name="GoodsListServlet",urlPatterns = "/goods_list")
public class GoodsListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        //获取页面传递过来的当前页面
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt((request.getParameter("pageNumber")));
        }
        //如果当前页面等于0 则改为1
        if (pageNumber<=0){
            pageNumber=1;
        }
        //获取页面对象
        Page p = gService.getGoodsList(pageNumber);
        //判断总页数 是否为0
        if (p.getTotalPage() == 0){
            p.setTotalPage(1);
            p.setPageNumber(1);
        }else{
            //如果当前页面大于总页面 就重新获取页数 相当于跳转到第一页
            if (pageNumber>p.getTotalPage()){
                p = gService.getGoodsList(pageNumber);
            }
        }
        request.setAttribute("p",p);
        request.getRequestDispatcher("/goodslist.jsp").forward(request,response);
    }

}
