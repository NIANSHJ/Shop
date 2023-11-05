package model;

import java.sql.Timestamp;


public class Log {
    private long id;          //日志（订单）id
    private String username;  //用户名
    private String email;     //用户邮箱
    private long goodsId;     //商品id
    private String goodsName; //商品名称
    private int count;        //购买商品数量
    private float total;      //商品总价
    private Timestamp time;   //下单时间
    private boolean validate; //是否已发货

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

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

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public Log() {
        super();
    }

    public Log(long id, String username, String email, long goodsId, String goodsName, int count, float total, Timestamp time, boolean validate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.total = total;
        this.time = time;
        this.validate = validate;
    }

    public Log(String username, String email, long goodsId, String goodsName, int count, float total, Timestamp time, boolean validate) {
        this.username = username;
        this.email = email;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.total = total;
        this.time = time;
        this.validate = validate;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", username=" + username + ", email=" + email + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", count=" + count
                + ", total=" + total + ", time=" + time + ", validate=" + validate + "]";
    }
}
