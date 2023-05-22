package cn.network.product.dao.impl;

import cn.network.myssm.basedao.BaseDAO;
import cn.network.product.dao.ProductDAO;
import cn.network.product.pojo.Product;

import java.util.List;

/**
 * ClassName: ProductDAOImpl
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 20:13
 * @Version 1.0
 */
public class ProductDAOImpl extends BaseDAO<Product> implements ProductDAO {
    @Override
    public List<Product> getProductList() {
        return super.executeQuery("select * from product");
    }
}
