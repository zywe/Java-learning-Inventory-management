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
    List<Product> getProductList();
}
