package DAO;

import Model.ConnectDB;
import Model.ImageProduct;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageProductDAO implements ObjectDAO{
    public static Map<String,ImageProduct> mapImageProduct = getLoadImageProductDB();


    public ArrayList<ImageProduct> getListImgProductWithPaginationAd(String type,String input,String page){
        ArrayList<ImageProduct> listImgProduct=getFillterProductImgAd(type,input);
        int pageIndex = Integer.parseInt(page) - 1;
        if(page.equals("null")){
            pageIndex=1;
        }
        ArrayList<ImageProduct> result = new ArrayList<>();
        for (int i = pageIndex * 10; i<pageIndex * 10 + 10;i++) {
            if(i<listImgProduct.size()) {
                result.add(listImgProduct.get(i));
            }else{
                break;
            }
        }
        return result;
    }
    public ArrayList<ImageProduct> getFillterProductImgAd(String type,String input){
        if(type.equals("null")||type.equals("All")){
            return new ArrayList<>(mapImageProduct.values());
        }
        ArrayList<ImageProduct> listImg=new ArrayList<>();
        switch (type){
            case "IdProduct":
                listImg=getProductByProduct(input.trim());
                break;
        }
        return listImg;
    }

    @Override
    public boolean add(Object obj) {
        String query = "insert into image_product(Id_ImageProduct,Id_Product)values(?,?)";
        ImageProduct ig = (ImageProduct) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, ig.getIDImageProdcut());
                stmt.setString(2, ig.getProduct().getIDProduct());

                stmt.executeUpdate();
                mapImageProduct=getLoadImageProductDB();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update image_product set Id_Product=? where =Id_ImageProduct?";
        ImageProduct ig = (ImageProduct) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, ig.getProduct().getIDProduct());
                stmt.setString(1, ig.getIDImageProdcut());

                stmt.executeUpdate();
                mapImageProduct=getLoadImageProductDB();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(String id) {
        String query = "delete from image_product where Id_ImageProduct=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,id);
                stmt.executeUpdate();
                mapImageProduct=getLoadImageProductDB();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public static Map<String, ImageProduct> getLoadImageProductDB() {
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

