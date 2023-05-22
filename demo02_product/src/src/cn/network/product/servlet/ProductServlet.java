package src.cn.network.product.servlet;

import javassist.compiler.ast.Keyword;
import src.cn.network.myssm.myspringmvc.ViewBaseServlet;
import src.cn.network.myssm.util.StringUtil;
import src.cn.network.product.dao.ProductDAO;
import src.cn.network.product.dao.impl.ProductDAOImpl;
import src.cn.network.product.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: ProductServlet
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 20:58
 * @Version 1.0
 */

@WebServlet("/product.do")
public class ProductServlet extends ViewBaseServlet {

    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        switch (operate){
            case "index":
                index(request,response);
                break;
            default:
                throw new RuntimeException("operate值非法");
        }


    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer pageNo = 1;
        String Keyword = null;
        String oper = request.getParameter("oper");

        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            Keyword = request.getParameter("keyword");
            if (StringUtil.isEmpty(Keyword)) {
                Keyword = "";
            }
            session.setAttribute("keyword", Keyword);
        } else {
            String pageNoStr = request.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                Keyword = (String) keywordObj;
            } else {
                Keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);
        List<Product> productList = productDAO.getProductList(Keyword, pageNo);
        session.setAttribute("productList", productList);

        int productCount = productDAO.getProductCount(Keyword);
        int pageCount = (productCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);

        super.processTemplate("index", request, response);
    }
}
