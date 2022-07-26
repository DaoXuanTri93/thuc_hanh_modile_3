package com.codygym.thuc_hanh_module_3.DAO;

import com.codygym.thuc_hanh_module_3.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
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
    public List<Category> selectAllCategory() throws ClassNotFoundException, SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category ";
        Connection connection= getConnection();
        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()){
            int idCategory = rs.getInt("idCategory");
            String danhMuc = rs.getString("tenDanhMuc");
            categories.add(new Category(idCategory,danhMuc));
        }
        connection.close();
        return categories;
    }
}
