package DAO;

import Model.CategoryNews;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CategoryNewsDAO implements  ObjectDAO{
    public static Map<String, CategoryNews> mapCategoyNews = getLoadCategoyNewsDB();


    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        return false;
    }

    @Override
    public boolean del(String id) {
        return false;
    }
    public static Map<String, CategoryNews> getLoadCategoyNewsDB()  {
        Map<String, CategoryNews> listCategoyNews=new HashMap<>() ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from category_news");
            while (rs.next()) {
                String IDCategoyNews = rs.getString(1);
                String nameCategoyNews = rs.getString(2);
                listCategoyNews.put(IDCategoyNews,new CategoryNews(IDCategoyNews, nameCategoyNews));
            }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCategoyNews;
    }
}
