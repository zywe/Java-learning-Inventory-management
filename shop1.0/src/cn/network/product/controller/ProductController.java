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

@WebServlet("/product.do")
public class ProductController extends ViewBaseServlet {

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

        List<Product> productList = productDAO.getProduct();
        session.setAttribute("productList", productList);

        super.processTemplate("index", request, response);
    }



}
