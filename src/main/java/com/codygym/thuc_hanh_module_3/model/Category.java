package com.codygym.thuc_hanh_module_3.model;

public class Category {
    private int idCategory;
    private String danhMuc;

    public Category() {
    }

    public Category(int idCategory, String danhMuc) {
        this.idCategory = idCategory;
        this.danhMuc = danhMuc;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", danhMuc='" + danhMuc + '\'' +
                '}';
    }
}
