package mypackage;
public class Department {
    private String idBP;
    private String boPhan;
    public int soLuongNV;
    // Constructor
    public Department(String idBP, String boPhan) {
        this.idBP = idBP;
        this.boPhan = boPhan;
    }
    // getter and setter
    public String getIdBP() {
        return idBP;
    }

    public void setIdBP(String idBP) {
        this.idBP = idBP;
    }

    public String getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }
    // phương thức toString() trả về 1 chuỗi
    public String toString() {
        return "- Bộ phận: " + getIdBP() + "  - Tên bộ phận: " + getBoPhan()
                + "  - Số lượng nhân viên: " + soLuongNV;
    }
}
