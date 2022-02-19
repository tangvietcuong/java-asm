package mypackage;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator {
    private long soGioLt;
    // constructor
    public Employee(String id, String ten, int tuoi, double heSoLuong, String ngayVaoLam,
                    String boPhan, int soNnPhep, long soGioLt) {
        super(id,ten,tuoi,heSoLuong,ngayVaoLam,boPhan,soNnPhep);
        this.soGioLt = soGioLt;
    }

    // getter and setter
    public void setSoGioLt (long soGioLt) {
        this.soGioLt = soGioLt;
    }

    public long getSoGioLt() {
        return soGioLt;
    }

    // hiển thị nhân viên
    public void displayInfomation() {
        System.out.println("ID: " + getId() + "  Tên: " + getTen() + "  Tuổi: " + getTuoi() + "  HS Lương: " + getHeSoLuong()
                            + "  Ngày vào làm: " + getNgayVaoLam() + "  Bộ phận: " + getBoPhan()
                            + "  Số ngày nghỉ: " + getSoNnPhep() + "  Số giờ làm thêm: " + soGioLt);
    }
    // tính lương nhân viên
    public long calculateSalary() {
        long luongnv;
        luongnv = (long) (getHeSoLuong() * 3000000 + getSoGioLt() * 200000);
        return luongnv;
    }

}
