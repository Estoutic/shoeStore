package com.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.models.ProductDao;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DbManager {
    private ConnectionSource connection;
    private static DbManager instance = null;
    private static final String CON_STR = "jdbc:sqlite:C:\\Projects\\shoeStore\\shop.db";
    static Logger log = Logger.getLogger(DbManager.class);


    public static synchronized DbManager getInstance() {
        if (instance == null)
            instance = new DbManager();
        return instance;
    }

    private DbManager() {
        try {

            this.connection = new JdbcPooledConnectionSource(CON_STR);
        } catch (SQLException e) {
            log.error(e);
        }
        try {
            TableUtils.createTableIfNotExists(connection, ProductDao.class);
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public void insertProduct(String article, String name, Integer size, Integer numberPair, Integer price) {
        ProductDao productDao = new ProductDao();
        productDao.setArticle(article);
        productDao.setName(name);
        productDao.setSize(size);
        productDao.setNumberPair(numberPair);
        productDao.setPrice(price);
        try {
            Dao<ProductDao, String> stringDao = DaoManager.createDao(connection, ProductDao.class);
            stringDao.create(productDao);
        } catch (SQLException e) {
            log.error(e);
        }
    }


    public List<ProductDao> getDamsProduct(Integer size) {
        Dao<ProductDao, String> damsProductDaos = DaoManager.lookupDao(connection, ProductDao.class);
        Where<ProductDao, String> where = damsProductDaos.queryBuilder().where();

        try {
            where.eq("size", size).and().eq("article", "D");
            PreparedQuery<ProductDao> productDaoPreparedQuery = damsProductDaos.queryBuilder().prepare();
            List<ProductDao> res = damsProductDaos.query(productDaoPreparedQuery);
            return res;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    public List<ProductDao> getArticleShoes(String article) {
        Dao<ProductDao, String> damsProductDaos = DaoManager.lookupDao(connection, ProductDao.class);
        Where<ProductDao, String> where = damsProductDaos.queryBuilder().where();

        try {
            where.eq("article", article);
            PreparedQuery<ProductDao> productDaoPreparedQuery = damsProductDaos.queryBuilder().prepare();
            return damsProductDaos.query(productDaoPreparedQuery);
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
}