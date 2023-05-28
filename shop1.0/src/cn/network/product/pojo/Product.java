package cn.network.product.pojo;

/**
 * ClassName: Product
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 19:56
 * @Version 1.0
 */

/*
USE shop;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) ,
  `price` double(10,2) DEFAULT NULL,
  `img` varchar(255) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (1, '罗蒙（ROMON）品牌轻奢男装', 369.00, 'https://img10.360buyimg.com/n7/jfs/t1/159883/31/14482/165951/6056b0cfEdc1b89c5/1604f5ef3ba61d5e.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (2, '雅戈尔【免烫】衬衫男 纯色衬衫', 379.00, 'https://img14.360buyimg.com/n7/jfs/t1/191306/8/7840/212682/60c389a3E4d080f79/546034a1c6c28bf0.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (3, 'HCVIP轻奢品牌高端晚礼服女2021新款气', 2580.00, 'https://img13.360buyimg.com/n7/jfs/t1/188622/32/704/123685/608bb368Ea05b145f/9a5d576898472bef.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (4, '麦斯贝思金色晚礼服女平时可穿气质高贵', 218.00, 'https://img10.360buyimg.com/n7/jfs/t1/109500/23/6039/135637/5e4409a4Ee7be1b01/4597b75151056635.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (5, '男童衬衫2021款童装', 65.00, 'https://img10.360buyimg.com/n7/jfs/t1/171671/39/13772/212032/60c0c5b4E67783809/3e224c90283ab157.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (6, 'fila斐乐童装女童针织短袖衫', 279.50, 'https://img14.360buyimg.com/n7/jfs/t1/181620/22/8787/210827/60c4ecf0Ec3023621/3e182380bfffc9ad.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (7, '波司登2021年秋季轻薄羽绒服', 469.00, 'https://img12.360buyimg.com/n7/jfs/t1/143892/4/27206/221885/61f0f924E13765f76/30f3a6799f9a0645.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (11, '高品质羊绒大衣女高品质双面羊绒大衣女', 1664.00, 'https://img13.360buyimg.com/n7/jfs/t1/164048/32/21807/92631/61c3e36bEfcb65daa/375f2c47fec0ffe1.jpg');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (12, 'michael', 235.00, 'fafa');
INSERT INTO `product` (`id`, `name`, `price`, `img`) VALUES (13, 'Apple iPhone 13 (A2634)512GB 绿色', 8399.00, 'https://img12.360buyimg.com/babel/s320x320_jfs/t1/123191/23/25287/57026/6227ced5E4890e6fc/40077f40e621da37.jpg!cc_320x320.webp');

*/

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String img;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }
}
