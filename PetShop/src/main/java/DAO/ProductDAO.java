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
    public ArrayList<Product> getListProductHot(){
        ArrayList<Product> result=new ArrayList<>();
        ArrayList<Product> ProductAll=new ArrayList<>(mapProduct.values());
        for(Product p:ProductAll){
            if(p.getCondition().equals("Hot")){
                result.add(p);
            }
        }
        return  result;
    }
    public ArrayList<Product> getListProductWithPagination(String type, String id, String page,String sort,String price) {
        ArrayList<Product> listProduct=getListFillterPrice(price,getListProdcutSort(type,id,sort));
        ArrayList<Product> result = new ArrayList<>();
        int pageIndex = Integer.parseInt(page) - 1;
        for (int i = pageIndex * 15; i<pageIndex * 15 + 15;i++) {
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
    public ArrayList<Product> getLoadProductByObject(String name){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select product.Id_Product,product.Id_PortfolioProduct,product.Id_SupplierProduct,product.Date,product.Title,product.Desription,product.Price,product.`Show`,product.Inventory,product.`Condition` from product JOIN portfolio_product on product.Id_PortfolioProduct=portfolio_product.Id_PortfolioProduct JOIN category_product on portfolio_product.Id_CategoryProduct=category_product.Id_CategoryProduct JOIN object_pet ON category_product.Id_Object=object_pet.Id_ObjectPet WHERE object_pet.NameObjectPet LIKE '%"+name+"%'");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
    public ArrayList<Product> getLoadProductByCategory(String name){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select product.Id_Product,product.Id_PortfolioProduct,product.Id_SupplierProduct,product.Date,product.Title,product.Desription,product.Price,product.`Show`,product.Inventory,product.`Condition` from product JOIN portfolio_product on product.Id_PortfolioProduct=portfolio_product.Id_PortfolioProduct JOIN category_product on portfolio_product.Id_CategoryProduct=category_product.Id_CategoryProduct WHERE category_product.Name_Category LIKE '%"+name+"%'");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
    public ArrayList<Product> getLoadProductByNamePortfolio(String name){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select product.Id_Product,product.Id_PortfolioProduct,product.Id_SupplierProduct,product.Date,product.Title,product.Desription,product.Price,product.`Show`,product.Inventory,product.`Condition` from product JOIN portfolio_product on product.Id_PortfolioProduct=portfolio_product.Id_PortfolioProduct WHERE portfolio_product.Name_PortfolioProduct LIKE '%"+name+"%'");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
    public ArrayList<Product> getLoadProductBySupplier(String name){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select product.Id_Product,product.Id_PortfolioProduct,product.Id_SupplierProduct,product.Date,product.Title,product.Desription,product.Price,product.`Show`,product.Inventory,product.`Condition` from product JOIN supplier_product ON product.Id_SupplierProduct=supplier_product.Id_SupplierProduct WHERE supplier_product.Name_SupplierProduct  LIKE '%"+name+"%'");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
    public ArrayList<Product> getLoadProductbyPrice(String pricef,int lenght){
        ArrayList<Product> listProduct=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * FROM product WHERE Price like '"+pricef+"%'AND LENGTH(Price)="+lenght+"");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.add(new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
    public ArrayList<Product> getListProductWithPaginationAd(String type,String input,String page){
        ArrayList<Product> listProduct=getFillterProductAd(type,input);
        int pageIndex = Integer.parseInt(page) - 1;
        if(page.equals("null")){
            pageIndex=1;
        }
        ArrayList<Product> result = new ArrayList<>();
        for (int i = pageIndex * 15; i<pageIndex * 15 + 15;i++) {
            if(i<listProduct.size()) {
                result.add(listProduct.get(i));
            }else{
                break;
            }
        }
        return result;
    }
    public ArrayList<Product> getFillterProductAd(String type,String input){
        String inputE=input.trim();

        ArrayList<Product> result=new ArrayList<>();
        if(type.equals("All")||type.equals("null")){
            return new ArrayList<>(mapProduct.values());
        }
        switch (type){
            case "IdProduct":
                result.add(mapProduct.get(input));
            break;
            case "nameProduct":
                result=getLoadProductBykeySearch(inputE);
                break;
            case "Portfolio":
                result=getLoadProductByNamePortfolio(inputE);
                break;
            case "Category":
                result=getLoadProductByCategory(inputE);
                break;
            case "Object":
                result=getLoadProductByObject(inputE);
                break;
            case "Supplier":
                result=getLoadProductBySupplier(inputE);
                break;
            case "Price":
                result=getLoadProductbyPrice(inputE.substring(0,1),inputE.length());
                break;
            default:
                result=new ArrayList<>(mapProduct.values());
                break;
        }
        return result;
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
                    boolean show = rs.getBoolean(8);
                    int inventory=rs.getInt(9);
                    String condition=rs.getString(10);
                    listProduct.put(IDProduct, new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show,inventory,condition));
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
