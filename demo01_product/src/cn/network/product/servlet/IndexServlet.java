package cn.network.product.servlet;

import cn.network.myssm.myspringmvc.ViewBaseServlet;
import cn.network.product.dao.ProductDAO;
import cn.network.product.dao.impl.ProductDAOImpl;
import cn.network.product.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: IndexServlet
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 20:15
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> productList = productDAO.getProductList();

        HttpSession session = request.getSession();
        session.setAttribute("productList",productList);
        super.processTemplate("index",request,response);
    }
}
