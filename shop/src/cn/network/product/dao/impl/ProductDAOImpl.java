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
    public List<Product> getProductList(String keyword, Integer pageNo) {
        return super.executeQuery("SELECT * FROM product where name like ? LIMIT ?,5;", "%" + keyword + "%", (pageNo - 1) * 5);
    }

    @Override
    public int getProductCount(String keyword) {
        return ((Long) super.executeComplexQuery("select count(*) from product where name like ?", "%" + keyword + "%")[0]).intValue();

    }

    @Override
    public Product getProductById(Integer id) {
        return super.load("select * from product where id = ? ", id);
    }

    @Override
    public void addProduct(Product product) {
        String sql = "insert into product values(0,?,?,?)";
        super.executeUpdate(sql, product.getName(), product.getPrice(), product.getImg());

    }

    @Override
    public void delProduct(Integer id) {
        super.executeUpdate("delete from product where id = ? ", id);

    }

    @Override
    public void updateProduct(Product product) {
        String sql = "update product set name = ? , price = ? , img = ? where id = ? ";
        super.executeUpdate(sql, product.getName(), product.getPrice(), product.getImg(), product.getId());

    }


}
