package DAO;

import Model.ConnectDB;
import Model.ImageProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageProductDAO implements ObjectDAO{
    Map<String,ImageProduct> mapImageProduct = getLoadImageProductDB();



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
    public ArrayList<ImageProduct> getProductByProduct(String IDProduct){
        List<ImageProduct> listImage=new ArrayList<>(mapImageProduct.values());
        ArrayList<ImageProduct> result=new ArrayList<>();
        for(ImageProduct i:listImage){
            if(i.getProduct().getIDProduct().equals(IDProduct)){
                result.add(i);
            }
        }
        return result;
    }
    public String getAvatarProduct(String IDProduct){
        List<ImageProduct> listImage=new ArrayList<>(mapImageProduct.values());
        for(ImageProduct i:listImage){
            if(i.getProduct().getIDProduct().equals(IDProduct)){
                return i.getIDImageProdcut();
            }
        }
        return null;
    }
    public Map<String, ImageProduct> getLoadImageProductDB() {
        Map<String,ImageProduct> listImageProduct=new HashMap<>() ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from image_product");
            while (rs.next()) {
                String IDImageProdcut = rs.getString(1);
                String IDProduct = rs.getString(2);
                listImageProduct.put(IDImageProdcut,new ImageProduct(IDImageProdcut, ProductDAO.mapProduct.get(IDProduct)));
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

        return listImageProduct;
    }
}

