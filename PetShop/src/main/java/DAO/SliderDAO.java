package DAO;

import Model.ConnectDB;
import Model.Slider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SliderDAO implements ObjectDAO {
    public Map<String, Slider> mapSlider = getLoadSliderDB();


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

    public static Map<String, Slider> getLoadSliderDB() {
        Map<String, Slider> listSlider = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from slider");
                while (rs.next()) {
                    String IDSlider = rs.getString(1);
                    String title = rs.getString(2);
                    String description = rs.getString(3);
                    listSlider.put(IDSlider, new Slider(IDSlider, title, description));
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

        return listSlider;
    }
}
