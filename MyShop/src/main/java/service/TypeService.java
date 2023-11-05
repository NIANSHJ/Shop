package service;

import dao.TypeDao;
import model.Type;
import java.sql.SQLException;
import java.util.List;


//向视图层提供分类相关服务
public class TypeService {
    private TypeDao typeDao = new TypeDao();

    public void addType(Type type) {
        try {
            typeDao.addType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Type> selectType() {
        List<Type> list = null;
        try {
            list = typeDao.selectType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Type> selectType(int page, int count) {
        List<Type> list = null;
        try {
            list = typeDao.selectType(page, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int[] page(int count) {
        int[] array = null;
        try {
            array = typeDao.page(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public Type selectById(int id) {
        Type type = null;
        try {
            type = typeDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public void modifyType(Type type) {
        try {
            typeDao.modifyType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteType(int id) {
        try {
            typeDao.deleteType(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
