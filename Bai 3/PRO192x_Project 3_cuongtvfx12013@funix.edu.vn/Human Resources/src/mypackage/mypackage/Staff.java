package mypackage;
import java.util.*;

public abstract class Staff {
    private String id;
    private String ten;
    private int tuoi;
    private double heSoLuong;
    private String ngayVaoLam;
    private String boPhan;
    private int soNnPhep;

    public Staff(String id, String ten, int tuoi, double heSoLuong, String ngayVaoLam, String boPhan, int soNnPhep) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhan = boPhan;
        this.soNnPhep = soNnPhep;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    public int getSoNnPhep() {
        return soNnPhep;
    }

    public void setSoNnPhep(int soNnPhep) {
        this.soNnPhep = soNnPhep;
    }
    // PT trừu tượng hiển thị thông tin nhân viên
    public abstract void displayInfomation();
    // PT trừu tượng tính lương nhân viên
    public abstract long calculateSalary();
}
