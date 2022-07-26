package com.codygym.thuc_hanh_module_3.model;

public class Product {
    private int idProduct;
    private String tenSanPham;
    private Double gia;
    private int soLuong;
    private String mauSac;
    private String moTa;
    private int danhMuc;

    public Product() {
    }

    public Product(String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, int danhMuc) {
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
    }

    public Product(int idProduct, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa, int danhMuc) {
        this.idProduct = idProduct;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
    }



    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(int danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", mauSac='" + mauSac + '\'' +
                ", moTa='" + moTa + '\'' +
                ", danhMuc=" + danhMuc +
                '}';
    }
}
