package com.example.greendaodecoder;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.greendaodecoder.data.User;


import arcturis.greendao.DaoMaster;
import arcturis.greendao.DaoSession;
import arcturis.greendao.UserDao;

public class DataUtils {

    private DataUtils() {
        setDatabase();
    }

    private static volatile DataUtils instance;

    public static DataUtils getInstance() {
        if (instance == null) {
            synchronized (DataUtils.class) {
                if (instance == null) {
                    instance = new DataUtils();

                }
            }
        }
        return instance;
    }

    private DaoMaster.DevOpenHelper mDaoHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private SQLiteDatabase db;

    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mDaoHelper = new DaoMaster.DevOpenHelper(DemoApp.app, "notes-db", null);
        db = mDaoHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public void addItem(User item) {
        UserDao userDao = mDaoSession.getUserDao();
        userDao.insert(item);
    }

    public void removeItem(long id) {
        UserDao userDao = mDaoSession.getUserDao();
        userDao.deleteByKeyInTx(id);
    }
}
