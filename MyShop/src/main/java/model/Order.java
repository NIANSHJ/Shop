package model;

import java.sql.Timestamp;


public class Order {
    private long id;          //订单id
    private String cover;     //商品封面图
    private long goodsId;     //商品id
    private String goodsName; //商品名称
    private int count;        //购买商品数量
    private float total;      //商品总价
    private Timestamp time;   //下单时间
    private long userId;      //用户id

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

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() { return goodsName; }

    public void setGoodsName(String goodsName) { this.goodsName = goodsName; }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Order() {
        super();
    }

    public Order(long id, String cover, long goodsId, String goodsName, int count, float total, Timestamp time, long userId) {
        this.id = id;
        this.cover = cover;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.total = total;
        this.time = time;
        this.userId = userId;
    }

    public Order(String cover, long goodsId, String goodsName, int count, float total, Timestamp time, long userId) {
        this.cover = cover;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.total = total;
        this.time = time;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", cover=" + cover + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", count=" + count + ", total=" + total
                + ", time=" + time + ", userId=" + userId + "]";
    }

}
