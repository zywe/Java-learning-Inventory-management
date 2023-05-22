package src.cn.network.product.dao.impl;


import src.cn.network.myssm.basedao.BaseDAO;
import src.cn.network.product.dao.ProductDAO;
import src.cn.network.product.pojo.Product;

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
    public List<Product> getProductList(String keyword, Integer pageNo) {
        return super.executeQuery("SELECT * FROM product where name like ? LIMIT ?,5;","%"+keyword+"%",(pageNo-1)*5);
    }

    @Override
    public int getProductCount(String keyword) {
        return ((Long) super.executeComplexQuery("select count(*) from product where name like ?","%"+keyword+"%") [0]).intValue();

    }


}
