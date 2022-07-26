package com.codygym.thuc_hanh_module_3.DAO;

import com.codygym.thuc_hanh_module_3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thuc_hanh_module_3?userSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    PreparedStatement ps;
    ResultSet rs;

    public Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> selectAllProduct() throws SQLException, ClassNotFoundException {

        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        String query = "select * from product";
        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            int idProduct = rs.getInt("idProduct");
            String tenSanPham = rs.getString("tenSanPham");
            Double gia = rs.getDouble("gia");
            int soLuong = rs.getInt("soLuong");
            String mauSac = rs.getString("mauSac");
            String moTa = rs.getString("moTa");
            int danhMuc = rs.getInt("danhMuc");
            products.add(new Product(idProduct, tenSanPham, gia, soLuong, mauSac, moTa, danhMuc));
        }
        connection.close();
        return products;
    }

    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "INSERT INTO product(idProduct,tenSanPham,gia,soLuong,mauSac, moTa, danhMuc) VALUES (?,?,?,?,?,?,?);";
//        Connection connection = getConnection();
        ps = connection.prepareStatement(query);
//        preparedStatement.setInt(1, customer.getIdCustomer());
        ps.setInt(1, product.getIdProduct());
        ps.setString(2, product.getTenSanPham());
        ps.setDouble(3, product.getGia());
        ps.setInt(4, product.getSoLuong());
        ps.setString(5, product.getMauSac());
        ps.setString(6, product.getMoTa());
        ps.setInt(7, product.getDanhMuc());

        ps.executeUpdate();


        connection.close();
    }

    public Product selectProduct(int id) throws SQLException, ClassNotFoundException {
        Product product = null;
        Connection connection = getConnection();
        String query = "SELECT tenSanPham,gia, soLuong , mauSac  , moTa , danhMuc from product WHERE idProduct = ?;";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
//            int idProduct = rs.getInt("idProduct");
            String tenSanPham = rs.getString("tenSanPham");
            Double gia = rs.getDouble("gia");
            int soLuong = rs.getInt("soLuong");
            String mauSac = rs.getString("mauSac");
            String moTa = rs.getString("moTa");
            int danhMuc = rs.getInt("danhMuc");
            product = new Product(id, tenSanPham, gia, soLuong, mauSac, moTa, danhMuc);
        }
        connection.close();
        return product;
    }

    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection connection = getConnection();
        String query = "UPDATE product SET tenSanPham = ?,gia = ?, soLuong = ?, mauSac = ? , moTa = ? , danhMuc = ? WHERE idProduct = ?;";
        ps = connection.prepareStatement(query);
//        preparedStatement.setInt(1, customer.getIdCustomer());
        ps.setString(1, product.getTenSanPham());
        ps.setDouble(2, product.getGia());
        ps.setInt(3, product.getSoLuong());
        ps.setString(4, product.getMauSac());
        ps.setString(5, product.getMoTa());
        ps.setInt(6, product.getDanhMuc());

        ps.setInt(7, product.getIdProduct());
        ps.executeUpdate();

        flag = ps.executeUpdate() > 0;
        connection.close();
        return flag;
    }

    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection connection = getConnection();
        String query = "DELETE FROM product WHERE idProduct = ?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        flag = ps.executeUpdate() > 0;
        connection.close();
        return flag;
    }
}
