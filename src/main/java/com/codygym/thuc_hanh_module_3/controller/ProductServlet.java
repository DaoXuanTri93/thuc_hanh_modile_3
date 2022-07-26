package com.codygym.thuc_hanh_module_3.controller;

import com.codygym.thuc_hanh_module_3.DAO.CategoryDAO;
import com.codygym.thuc_hanh_module_3.DAO.ProductDAO;
import com.codygym.thuc_hanh_module_3.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    ProductDAO productDAO;
    CategoryDAO categoryDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
        if (this.getServletContext().getAttribute("listCategory") == null) {
            try {
                getServletContext().setAttribute("listCategory", categoryDAO.selectAllCategory());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showAdd(req, resp);
                    break;
                case "edit":
                    showEdit(req, resp);
                    break;
                case "delete":
                    showDelete(req, resp);
                    break;
                default:
//                    listCustomer(req, resp);
                    listProduct(req, resp);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("delete"));
        productDAO.deleteProduct(idProduct);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int idProduct = Integer.parseInt(req.getParameter("product"));
        Product product = productDAO.selectProduct(idProduct);
        req.setAttribute("editProduct", product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> products = productDAO.selectAllProduct();
        req.setAttribute("listP", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(req, resp);
                    break;
                case "edit":
                    updateCustomer(req, resp);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idProduct"));

        String tenSanPham = req.getParameter("tenSanPham");
        Double gia = Double.parseDouble(req.getParameter("gia"));
        int soLuong = Integer.parseInt(req.getParameter("soLuong"));
        String mauSac = req.getParameter("mauSac");
        String moTa = req.getParameter("moTa");
        int danhMuc = Integer.parseInt(req.getParameter("danhMuc"));
        Product product = new Product(id, tenSanPham, gia, soLuong, mauSac, moTa, danhMuc);
        productDAO.updateProduct(product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("idProduct"));
        String tenSanPham = req.getParameter("tenSanPham");
        Double gia = Double.parseDouble(req.getParameter("gia"));
        int soLuong = Integer.parseInt(req.getParameter("soLuong"));
        String mauSac = req.getParameter("mauSac");
        String moTa = req.getParameter("moTa");
        int danhMuc = Integer.parseInt(req.getParameter("danhMuc"));
        Product product = new Product(tenSanPham, gia, soLuong, mauSac, moTa, danhMuc);
        productDAO.insertProduct(product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req, resp);
    }


}
