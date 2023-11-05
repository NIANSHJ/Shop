package model;

public class Sell {
    private long goodsId; //商品id
    private int stock;    //商品原库存
    private int sell;     //商品销量
    private int remain;   //商品现库存

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public Sell() {
        super();
    }

    public Sell(long goodsId, int stock, int sell, int remain) {
        this.goodsId = goodsId;
        this.stock = stock;
        this.sell = sell;
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Sell [goodsId=" + goodsId + ", stock=" + stock + ", sell=" + sell + ", remain=" + remain + "]";
    }

}
