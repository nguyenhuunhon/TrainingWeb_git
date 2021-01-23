package DAO;

import Model.ConnectDB;
import Model.PortfolioProduct;
import Model.Product;
import Model.SupplierProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ProductDAO implements ObjectDAO {
    public static Map<String, Product> mapProduct = getLoadProductDB();

    public Map<String, Product> mapProductByCategory(String IDCategoryProduct) throws Exception {
        Map<String, Product> rs = new HashMap<>();
        Iterator<Map.Entry<String, Product>> i = mapProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            Product value = (Product) entry.getValue();
            if (value.getPortfolio().getCategory().getIDCategoryProduct().equals(IDCategoryProduct)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

    public Map<String, Product> mapProductByPortfolio(String IDPortfolioProduct) throws Exception {
        Map<String, Product> rs = new HashMap<>();
        Iterator<Map.Entry<String, Product>> i = mapProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            Product value = (Product) entry.getValue();
            if (value.getPortfolio().getIDPortfolioProduct().equals(IDPortfolioProduct)) {
                rs.put(key, value);
            }
        }
        return rs;
    }







    public ArrayList<Product> getListProduct(String type, String id) {

        ArrayList<Product> listProduct = null;
        ArrayList<Product> listProductAll = new ArrayList<>(mapProduct.values());
        if(type.equals("null")&&id.equals("null")){
            return listProductAll;
        }
        switch (type) {
            case "Portfolio":
                listProduct = new ArrayList<>();
                for (Product p : listProductAll) {
                    if (p.getPortfolio().getIDPortfolioProduct().equals(id)) {
                        listProduct.add(p);
                    }
                }
                break;
            case "GeneralPortfolio":
                listProduct = new ArrayList<>();
                for (Product p : listProductAll) {
                    if (p.getPortfolio().getNamePortfolioProduct().equals(PortfolioProductDAO.mapPortfolioProduct.get(id).getNamePortfolioProduct())) {
                        listProduct.add(p);
                    }
                }
                break;
            case "GeneralCategory":
                listProduct = new ArrayList<>();
                for (Product p : listProductAll) {
                    if (p.getPortfolio().getCategory().getNameCategoryProduct().equals(CategoryProductDAO.mapCategoryProduct.get(id).getNameCategoryProduct())) {
                        listProduct.add(p);
                    }
                }
                break;
            case "Suplier":
                listProduct = new ArrayList<>();

                for (Product p : listProductAll) {
                    if (p.getSupplier().getIDSupplierProduct().equals(id)) {
                        listProduct.add(p);
                    }
                }
                break;
            case "Price":
                listProduct = new ArrayList<>();
                String[] priceS = id.split(",");
                int min = Integer.parseInt(priceS[0]);
                int max = Integer.parseInt(priceS[1]);
                for (Product p : listProductAll) {
                    if (p.getPrice() >= min && p.getPrice() < max) {
                        listProduct.add(p);
                    }
                }
                break;
            case "Search":
                listProduct=getLoadProductBykeySearch(id);
                break;
        }
        return listProduct;
    }

    public ArrayList<Product> getListProductWithPagination(String type, String id, String page,String sort,String price) {
        ArrayList<Product> listProduct=getListFillterPrice(price,getListProdcutSort(type,id,sort));
        ArrayList<Product> result = new ArrayList<>();
        int pageIndex = Integer.parseInt(page) - 1;
        for (int i = pageIndex * 12; i<pageIndex * 12 + 12;i++) {
            if(i<listProduct.size()) {
                result.add(listProduct.get(i));
            }else{
                break;
            }
        }
        return result;
    }
    public ArrayList<Product> getListFillterPrice(String price,ArrayList<Product> lisProduct){
        if (price.equals("null")){
            return lisProduct;
        }
        ArrayList<Product> result = new ArrayList<>();
        String[] priceS = price.split(",");
        int min = Integer.parseInt(priceS[0]);
        int max = Integer.parseInt(priceS[1]);
        for (Product p : lisProduct) {
            if (p.getPrice() >= min && p.getPrice() < max) {
                result.add(p);
            }
        }
        return result;
    }
    public ArrayList<Product> getListProdcutSort(String type,String id,String sort){
        ArrayList<Product> listProduct = getListProduct(type, id);
        switch (sort){
            case "minToMax":
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice()-o2.getPrice();
                    }
                });
                break;
            case "maxToMin":
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return -(o1.getPrice()-o2.getPrice());
                    }
                });
                break;
        }
        return listProduct;
    }
    public int countSupplierByID(String id) {
        ArrayList<Product> listProduct = new ArrayList<>(mapProduct.values());
        int result = 0;
        for (Product p : listProduct) {
            if (p.getSupplier().getIDSupplierProduct().equals(id)) {
                result += 1;
            }
        }
        return result;
    }
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
    public ArrayList<Product> getLoadProductBykeySearch(String key){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from product where Title like'%"+key+"%'");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    String show = rs.getString(8);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show));
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
        return listProduct;
    }
    public static Map<String, Product> getLoadProductDB() {
        Map<String, Product> listProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from product");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    String show = rs.getString(8);
                    listProduct.put(IDProduct, new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show));
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
        return listProduct;
    }

    public static void main(String[] args) throws Exception {
        List<Product> listProduct2= new ArrayList<>(ProductDAO.mapProduct.values());
        for (Product p : listProduct2) {
            System.out.println(p.getTitle());
        }
        List<Product> listProduct = new ProductDAO().getLoadProductBykeySearch("ABC");
        for (Product p : listProduct) {
            System.out.println(p.getTitle());
        }
    }
}
