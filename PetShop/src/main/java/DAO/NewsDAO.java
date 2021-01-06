package DAO;

import Model.ConnectDB;
import Model.News;
import Model.SalePriceProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NewsDAO implements ObjectDAO {
    public Map<String, News> mapNews = getLoadNewsDB();


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

    public Map<String, News> getLoadNewsDB() {
        Map<String, News> listNews = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from news");
                while (rs.next()) {
                    String IDNews = rs.getString(1);
                    String titleNews = rs.getString(2);
                    String contentNews = rs.getString(3);
                    String IDCategoyNews = rs.getString(4);
                    Date date = rs.getDate(5);
                    int view = rs.getInt(6);
                    listNews.put(IDNews, new News(IDNews, titleNews, contentNews, CategoryNewsDAO.mapCategoyNews.get(IDCategoyNews), date, view));
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

        return listNews;
    }
}
