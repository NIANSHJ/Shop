package service;

import dao.GoodsDao;
import model.Goods;
import java.sql.SQLException;
import java.util.List;


//向视图层提供商品相关服务
public class GoodsService {

    private GoodsDao goodsDao = new GoodsDao();

    public long addGoods(Goods goods) {
        long key = 0;
        try {
            key = goodsDao.addGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    public List<Goods> selectGoods(long page, long count) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectGoods(page, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public long[] page(long count) {
        long[] array = null;
        try {
            array = goodsDao.page(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public List<Goods> selectByKeyword(String keyword) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectByKeyword(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Goods> selectByKeyword(String keyword, int value) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectByKeyword(keyword, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Goods> selectByKeyword(long page, long count, String keyword) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectByKeyword(page, count, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public long[] page(long count, String keyword) {
        long[] array = null;
        try {
            array = goodsDao.page(count, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public Goods selectById(long id) {
        Goods goods = null;
        try {
            goods = goodsDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    public List<Goods> selectByTypeId(int id) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectByTypeId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Goods> selectByTypeId(int id, int value) {
        List<Goods> list = null;
        try {
            list = goodsDao.selectByTypeId(id, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void modifyGoods(Goods goods) {
        try {
            goodsDao.modifyGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGoods(long id) {
        try {
            goodsDao.deleteGoods(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
