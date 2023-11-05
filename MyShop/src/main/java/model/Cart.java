package model;


//购物车实体类
public class Cart {

    long id;       //购物车对象id
    String cover;  //商品封面图
    String name;   //商品名称
    float price;   //商品单价
    int count;     //购买商品数量
    long goodsId;  //商品id
    long userId;   //用户id
    long type;     //商品分类

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getType() { return type; }

    public void setType(long type) { this.type = type; }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Cart() {
        super();
    }

    public Cart(long id, String cover, String name, float price, int count, long type, long goodsId, long userId) {
        this.id = id;
        this.cover = cover;
        this.name = name;
        this.price = price;
        this.count = count;
        this.type = type;
        this.goodsId = goodsId;
        this.userId = userId;
    }

    public Cart(String cover, String name, float price, int count, long type, long goodsId, long userId) {
        this.cover = cover;
        this.name = name;
        this.price = price;
        this.count = count;
        this.type = type;
        this.goodsId = goodsId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", cover=" + cover + ", name=" + name + ", price=" + price
                + ", count=" + count + ", type=" + type + ", goodsId=" + goodsId + ", userId=" + userId + "]";
    }

}
