package model;


//商品实体类
public class Goods {
    private long id;             //商品id
    private String name;         //商品名称
    private String cover;        //商品封面图
    private String image1;       //商品详情图1
    private String image2;       //商品详情图2
    private float price;         //商品价格
    private String introduction; //商品介绍
    private int stock;           //商品库存
    private int type;            //商品分类

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Goods() {
        super();
    }

    public Goods(long id, String name, String cover, String image1, String image2, float price, String introduction, int stock,
                 int type) {
        super();
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.introduction = introduction;
        this.stock = stock;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods [id=" + id + ", name=" + name + ", cover=" + cover + ", image1=" + image1 + ", image2=" + image2
                + ", price=" + price + ", intro=" + introduction + ", stock=" + stock + ", type=" + type + "]";
    }

}
