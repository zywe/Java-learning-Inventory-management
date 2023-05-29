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
 * ClassName: adminController
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/29 17:48
 * @Version 1.0
 */

@WebServlet("/admin.do")
public class AdminController extends ViewBaseServlet {

    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }

        //获取当前类中所有方法
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method m : methods) {
            //获取方法名
            String methodName = m.getName();
            if (operate.equals(methodName)) {
                //找到和operate同名方法，那么通过反射调用它
                try {
                    m.invoke(this, request, response);
                    return;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("operate error...");
    }




    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer pageNo = 1;
        String oper = request.getParameter("oper");
        String Keyword = null;

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

        super.processTemplate("admin/admin", request, response);
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (StringUtil.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);
            Product product = productDAO.getProductById(id);
            request.setAttribute("product", product);
            super.processTemplate("admin/edit", request, response);

        }
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        productDAO.updateProduct(new Product(id, name, price, img));
        response.sendRedirect("admin.do");

    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (StringUtil.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);
            productDAO.delProduct(id);
            response.sendRedirect("admin.do");

        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        Product product = new Product(0, name, price, img);
        productDAO.addProduct(product);
        response.sendRedirect("admin.do");
    }

}
