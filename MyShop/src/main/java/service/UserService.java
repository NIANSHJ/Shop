package service;

import dao.UserDao;
import model.User;
import java.sql.SQLException;
import java.util.List;


//向视图层提供用户相关服务
public class UserService {
    private UserDao userDao = new UserDao();

    //提供注册服务
    public boolean register(User user) {
        try {
            if (userDao.isUsernameExist(user.getUsername())) {
                return false;
            }
            if (userDao.isEmailExist(user.getEmail())) {
                return false;
            }
            userDao.addUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //提供登录服务
    public User login(String ue, String password) {
        User user = null;
        try {
            user = userDao.selectByUsernamePassword(ue, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            return user;
        }
        try {
            user = userDao.selectByEmailPassword(ue, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectUser(long page, long count) {
        List<User> list = null;
        try {
            list = userDao.selectUser(page, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public long[] page(long count) {
        long[] array = null;
        try {
            array = userDao.page(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public List<User> selectByKeyword(long page, long count, String keyword) {
        List<User> list = null;
        try {
            list = userDao.selectByKeyword(page, count, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public long[] page(long count, String keyword) {
        long[] array = null;
        try {
            array = userDao.page(count, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public User selectById(long id) {
        User user = null;
        try {
            user = userDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void modifyUser(User user) {
        try {
            userDao.modifyUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try {
            userDao.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveInfo(long id, String name, String phone, String address) {
        try {
            userDao.saveInfo(id, name, phone, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
