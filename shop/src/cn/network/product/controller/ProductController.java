package cn.network.product.controller;

import cn.network.myssm.myspringmvc.ViewBaseServlet;
import cn.network.myssm.util.StringUtil;
import cn.network.product.dao.ProductDAO;
import cn.network.product.dao.impl.ProductDAOImpl;
import cn.network.product.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName: ProductServlet
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 20:58
 * @Version 1.0
 */


public class ProductController {

    ProductDAO productDAO = new ProductDAOImpl();


    private String list(String oper, String Keyword, HttpServletRequest request) {
        HttpSession session = request.getSession();


        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            if (StringUtil.isEmpty(Keyword)) {
                Keyword = "";
            }
            session.setAttribute("keyword", Keyword);
        } else {

            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                Keyword = (String) keywordObj;
            } else {
                Keyword = "";
            }
        }

        List<Product> productList = productDAO.getProductListAll(Keyword);
        session.setAttribute("productList", productList);

        return "list";

    }


    private String update(Integer id, String name, Double price, String img) {

        productDAO.updateProduct(new Product(id, name, price, img));
        return "redirect:product.do";
    }


    private String edit(Integer id, HttpServletRequest request) {
        if (id != null) {
            Product product = productDAO.getProductById(id);
            request.setAttribute("product", product);
            return "edit";
        }
        return "error";
    }


    private String del(Integer id) {
        if (id != null) {
            productDAO.delProduct(id);
            return "redirect:product.do";
        }
        return "error";
    }

    private String add(Integer id, String name, Double price, String img) {

        Product product = new Product(0, name, price, img);
        productDAO.addProduct(product);
        return "redirect:product.do";


    }


    private String index(String oper, String Keyword, Integer pageNo, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (pageNo == null) {
            pageNo = 1;
        }

        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            if (StringUtil.isEmpty(Keyword)) {
                Keyword = "";
            }
            session.setAttribute("keyword", Keyword);
        } else {

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

        return "index";

    }
}
