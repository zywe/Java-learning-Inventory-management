package cn.network.product.dao;


import cn.network.product.pojo.Product;

import java.util.List;

/**
 * ClassName: ProductDAO
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 20:10
 * @Version 1.0
 */
public interface ProductDAO {
    List<Product> getProductList(String keyword, Integer pageNo);

    List<Product> getProduct();

    int getProductCount(String keyword);

    Product getProductById(Integer id);

    void addProduct(Product product);

    void delProduct(Integer id);

    void updateProduct(Product product);


}
