package Db;

import Db.models.ProductDao;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DbManager {
    private ConnectionSource connection;
    private static DbManager instance = null;
    private static final String CON_STR = "jdbc:sqlite:C:/Projects/Task/src/Db/shop.db";
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
            stringDao.queryForId(article);
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public ProductDao getProductInfo(String article) {
        Dao<ProductDao, String> productDaos = DaoManager.lookupDao(connection, ProductDao.class);
        try {
            return productDaos.queryForId(article);
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
    public List<ProductDao> getAllProductInfo(){
        Dao<ProductDao, String> productDaos = DaoManager.lookupDao(connection, ProductDao.class);
        try {
            return productDaos.queryForAll();
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
//    public DamsProductDao getDamsProduct(String name, Integer size){
//        Dao<DamsProductDao, String> damsProductDaos= DaoManager.lookupDao(connection, DamsProductDao.class);
//        try {
//            return damsProductDaos.queryForId(name);
//        } catch (SQLException e) {
//            log.error(e);
//        }
//
//        return null;
//
//
//    }
//
//    public void updateProduct(String article, Integer numberPair, Integer price) {
//        Dao<ProductDao, String> productManager = DaoManager.lookupDao(connection, ProductDao.class);
//        ProductDao productsDao = getProductInfo(article);
//        if (productsDao == null) return;
//        if (numberPair != null) {
//            productsDao.setNumberPair(numberPair);
//        }
//        if (price != null) {
//            productsDao.setPrice(price);
//        }
//        try {
//            productManager.update(productsDao);
//        } catch (SQLException e) {
//            log.error(e);
//        }
//    }
}
