package servlet;

import model.Page;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchGoodsServlet",urlPatterns = "/search_goods")
public class SearchGoodsServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName = request.getParameter("goodsName");
        int pageNumber = 1;
        //��ȡҳ�洫�ݹ����ĵ�ǰҳ��
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt((request.getParameter("pageNumber")));
        }
        //�����ǰҳ�����0 ���Ϊ1
        if (pageNumber<=0){
            pageNumber=1;
        }
        //��ȡҳ�����
        Page p = gService.getGoodsList(pageNumber,goodsName);
        //�ж���ҳ�� �Ƿ�Ϊ0
        if (p.getTotalPage() == 0){
            p.setTotalPage(1);
            p.setPageNumber(1);
        }else{
            //�����ǰҳ�������ҳ�� �����»�ȡҳ�� �൱����ת����һҳ
            if (pageNumber>p.getTotalPage()){
                p = gService.getGoodsList(pageNumber,goodsName);
            }
        }
        request.setAttribute("p",p);
        request.getRequestDispatcher("/goodslist.jsp").forward(request,response);
    }
}
