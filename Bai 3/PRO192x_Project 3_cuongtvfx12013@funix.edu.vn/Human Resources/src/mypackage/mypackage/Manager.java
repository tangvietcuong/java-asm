package mypackage;
import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
    private String chucDanh;
    // constructor
    public Manager(String id, String ten, int tuoi, double heSoLuong, String ngayVaoLam, String boPhan, int soNnPhep, String chucDanh) {
        super(id,ten,tuoi,heSoLuong,ngayVaoLam,boPhan,soNnPhep);
        this.chucDanh = chucDanh;
    }

    // getter and setter
    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    // hiển thị thông tin quản lý
    public void displayInfomation() {
        System.out.println("ID: " + getId() + "  Tên: " + getTen() + "  Tuổi: " + getTuoi() + "  Hệ Số Lương: "
                            + getHeSoLuong() + "  Ngày vào làm: " + getNgayVaoLam() + "  Bộ phận: " + getBoPhan()
                            + "  Số ngày nghỉ: " + getSoNnPhep() + "  Chức danh: " + getChucDanh());
    }

    // tính lương quản lý
    public long calculateSalary() {
        int luongTn = 0;
        if (getChucDanh().equalsIgnoreCase("Business Leader")) {
            luongTn = 8000000;
        }
        if (getChucDanh().equalsIgnoreCase("Project Leader")) {
            luongTn = 5000000;
        }
        if (getChucDanh().equalsIgnoreCase("Technical Leader")) {
            luongTn = 6000000;
        }
        long luongMng;
        luongMng = (long) (getHeSoLuong() * 5000000 + luongTn);
        return luongMng;
    }
}
