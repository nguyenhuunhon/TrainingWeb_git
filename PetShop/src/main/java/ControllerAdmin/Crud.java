package ControllerAdmin;

import DAO.*;
import Model.ImageProduct;
import Model.Order;
import Model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "Crud", value = "/Crud")
public class Crud extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String curd = request.getParameter("crud");
        String id = request.getParameter("id");
        String type = request.getParameter("type");

        switch (type) {
            case "product":
                String title = request.getParameter("title");
                String selectSupplierPro = request.getParameter("selectSupplierPro");
                String selectObjectPro = request.getParameter("selectObjectPro");
                String selectCategoryPro = request.getParameter("selectCategoryPro");
                String selectPortfolioPro = request.getParameter("selectPortfolioPro");
                String condition = request.getParameter("condition");
                int pricePro = Integer.parseInt(request.getParameter("pricePro"));
                int amountPro = Integer.parseInt(request.getParameter("amountPro"));
                String descriptionPro = request.getParameter("descriptionPro");
                String checkBox = request.getParameter("showPro");
                boolean showPro = false;
                if (checkBox != null && checkBox.contentEquals("on")) {
                    showPro = true;
                }

                Product p = new Product(id, PortfolioProductDAO.mapPortfolioProduct.get(selectPortfolioPro), SupplierProductDAO.mapSupplierProduct.get(selectSupplierPro), title, descriptionPro, pricePro, showPro, amountPro, condition);
                if (curd.equals("delete")) {
                    new ProductDAO().del(id);
                } else if (curd.equals("edit")) {
                    new ProductDAO().edit(p);
                } else if (curd.equals("add")) {
                    new ProductDAO().add(p);
                }
                response.sendRedirect("Admin/ContentAdmin/Product.jsp?type=null&input=null&page=1");

                break;

            case "order":
                if (curd.equals("edit")) {
                    Order o = OrderDAO.mapOrder.get(id);
                    o.setStatus(true);
                    new OrderDAO().edit(o);
                } else {
                    if (curd.equals("delete")) {
                        new OrderDAO().del(id);
                    }
                }
                response.sendRedirect("Admin/ContentAdmin/Order.jsp");

                break;
            case "ImgProduct": {
                DiskFileItemFactory factory = new DiskFileItemFactory();

// Configure a repository (to ensure a secure temp location is used)
                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);

// Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                if (curd.equals("add")) {
                    ImageProduct igNew = null;
                    // Create a factory for disk-based file items


// Parse the request
                    try {
                        List<FileItem> items = upload.parseRequest(request);
                        // Process the uploaded items
                        Iterator<FileItem> iter = items.iterator();
                        while (iter.hasNext()) {
                            FileItem item = iter.next();
                            if (item.isFormField()) {

                                String name = item.getFieldName();
                                String value = item.getString();
                                System.out.println("name:" + name);
                                System.out.println("value:" + value);
                                igNew = new ImageProduct(ProductDAO.mapProduct.get(value.trim()));

                            } else {
                                if (item.getFieldName() == null || item.getFieldName().equals("")) {
                                    break;
                                } else {
                                    String storePath = servletContext.getRealPath("images/Product");
                                    File uploadFile = new File(storePath + "\\" + igNew.getIDImageProdcut() + ".jpg");
                                    item.write(uploadFile);
                                    System.out.println(storePath + "\\" + igNew.getIDImageProdcut() + ".jpg");
                                }
                            }
                        }
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    new ImageProductDAO().add(igNew);
                } else if (curd.equals("edit")) {
                    ImageProduct ig = null;
                    try {
                        List<FileItem> items = upload.parseRequest(request);
                        // Process the uploaded items
                        Iterator<FileItem> iter = items.iterator();
                        while (iter.hasNext()) {
                            FileItem item = iter.next();
                            if (item.isFormField()) {

                                String name = item.getFieldName();
                                String value = item.getString();
                                System.out.println("name:" + name);
                                System.out.println("value:" + value);
                                Product Pro = ProductDAO.mapProduct.get(value.trim());
                                ig = ImageProductDAO.mapImageProduct.get(id);
                                ig.setProduct(Pro);
                            } else {
                                if (item.getFieldName() == null || item.getFieldName().equals("")) {
                                    break;
                                } else {
                                    String storePath = servletContext.getRealPath("images/Product");
                                    File FileOld = new File(storePath + "\\" + ig.getIDImageProdcut() + ".jpg");
                                    FileOld.delete();
                                    File uploadFile = new File(storePath + "\\" + ig.getIDImageProdcut() + ".jpg");
                                    item.write(uploadFile);
                                    System.out.println(storePath + "\\" + ig.getIDImageProdcut() + ".jpg");
                                }
                            }
                        }


                        new ImageProductDAO().edit(ig);
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (curd.equals("delete")) {
                    String storePath = servletContext.getRealPath("images/Product");
                    File FileOld = new File(storePath + "\\" + id.trim() + ".jpg");
                    FileOld.delete();
                    new ImageProductDAO().del(id);
                }
                response.sendRedirect("Admin/ContentAdmin/ImageProduct.jsp?type=null&input=null&page=1");
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
