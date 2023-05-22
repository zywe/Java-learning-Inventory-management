package cn.network.product.pojo;

/**
 * ClassName: Product
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/22 19:56
 * @Version 1.0
 */
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String img;

    public Product(){}

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
