package mypackage;
import java.util.*;

public class HumanResources {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        optionUser();
    }
    // tạo biến static
    static int count1;           // 4 biến đếm số lượng nhân viên từng phòng
    static int count2;
    static int count3;
    static int count4;

    static String id;
    static String ten;
    static int tuoi;
    static double heSoLuong;
    static String ngayVaoLam;
    static String boPhan;
    static int soNnPhep;
    static long soGioLt;
    static String chucDanh;
    static int luaChon;

    // tạo ArrayList lưu trữ toàn bộ nhân viên công ty (Staff)
    public static ArrayList<Staff> listStaff() {
        ArrayList<Staff> danhSachNv = new ArrayList<Staff>();
        Employee nv1 = new Employee("E-001", "Tiến Linh", 25, 2.0, "20/10/2009",
                        "Phong IT", 7, 30);
        Employee nv2 = new Employee("E-002", "Văn Toàn", 30, 2.0, "15/05/2010",
                        "Ke Toan", 7, 45);
        Employee nv3 = new Employee("E-003", "Quang Hải", 25, 2.0, "06/10/2005",
                        "Kinh Doanh", 7, 25);
        danhSachNv.add(nv1);                // Thêm từng nhân viên vào Arraylist
        danhSachNv.add(nv2);
        danhSachNv.add(nv3);
        Manager mn1 = new Manager("M-001", "Văn Hậu", 35, 3.0, "15/10/2000", "Quan Ly", 7, "Business Leader");
        Manager mn2 = new Manager("M-002", "Hải Quế", 32, 2.5, "15/08/2000", "Quan Ly", 3, "Project Leader");
        Manager mn3 = new Manager("M-003", "Duy Mạnh", 45, 3.5, "05/10/2002", "Quan Ly", 4, "Technical Leader");
        danhSachNv.add(mn1);                 // Thêm từng quản lí vào Arraylist
        danhSachNv.add(mn2);
        danhSachNv.add(mn3);

        return danhSachNv;
    }

    // Hiển thị danh sách người dùng chọn
    static void menu() {
        System.out.println("Danh sách các chức năng");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty (Nhấn 1)");
        System.out.println("2. Hiển thị các bộ phận trong công ty (Nhấn 2)");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận (Nhấn 3)");
        System.out.println("4. Thêm nhân viên mới vào công ty (Nhấn 4)");
        System.out.println("5. Tìm kiếm theo tên nhân viên (Nhấn 5)");
        System.out.println("6. Hiển thị bảng lương của nhân viên công ty (Nhấn 6)");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần (Nhấn 7)");
        System.out.println("8. Thoát (Nhấn 8)");
    }

    // Phương thức cho người dùng nhập vào và thực hiện từng nhiệm vụ trong menu
    public static void optionUser() {
        ArrayList<Staff> danhSachNv = listStaff();
        // Vòng lặp Do - While chạy đến khi user chọn "8" để thoát
        do {
            System.out.print("Vui lòng chọn chức năng với số tương ứng: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                // option 1: in ra danh sách nhân viên
                case 1 -> {
                    System.out.println("Danh sách nhân viên hiện có trong công ty: ");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        danhSachNv.get(i).displayInfomation();
                    }
                }
                // option 2: in ra bộ phận trong công ty
                case 2 -> {
                    System.out.println("Các bộ phận hiện có trong công ty: ");
                    for (Staff staff : danhSachNv) {
                        switch (staff.getBoPhan()) {
                            case "Phong IT" -> count1++;
                            case "Ke Toan" -> count2++;
                            case "Kinh Doanh" -> count3++;
                            case "Quan Ly" -> count4++;
                        }
                    }
                    Department phongIT = new Department("IT", "Phong IT");
                    phongIT.soLuongNV = count1;
                    System.out.println(phongIT);
                    count1 = 0;
                    Department phongKT = new Department("KT", "Ke Toan");
                    phongKT.soLuongNV = count2;
                    System.out.println(phongKT);
                    count2 = 0;
                    Department phongKD = new Department("KD", "Kinh Doanh");
                    phongKD.soLuongNV = count3;
                    System.out.println(phongKD);
                    count3 = 0;
                    Department phongQL = new Department("QL", "Quan Ly");
                    phongQL.soLuongNV = count4;
                    System.out.println(phongQL);
                    count4 = 0;
                }
                // option 3: in ra nhân viên theo từng phòng
                case 3 -> {
                    System.out.println("Các nhân viên theo từng phòng: ");
                    System.out.println("Phòng IT:");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        if (danhSachNv.get(i).getBoPhan().equals("Phong IT")) {
                            danhSachNv.get(i).displayInfomation();
                        }
                    }
                    System.out.println("Phòng Kế Toán:");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        if (danhSachNv.get(i).getBoPhan().equals("Ke Toan")) {
                            danhSachNv.get(i).displayInfomation();
                        }
                    }
                    System.out.println("Phòng Kinh Doanh:");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        if (danhSachNv.get(i).getBoPhan().equals("Kinh Doanh")) {
                            danhSachNv.get(i).displayInfomation();
                        }
                    }
                    System.out.println("Phòng Quản Lý:");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        if (danhSachNv.get(i).getBoPhan().equals("Quan Ly")) {
                            danhSachNv.get(i).displayInfomation();
                        }
                    }
                }
                // option 4: Thêm mới nhân viên vào công ty
                case 4 -> {
                    System.out.println();
                    System.out.println("Thêm mới nhân viên vào công ty:");
                    // Dùng vòng lặp Do - While cho phép người dùng nhập nhiều nhân viên
                    do {
                        System.out.print("Nhấn \"1\" nếu bạn muốn thêm nhân viên, \"2\" nếu bạn muốn thêm quản lý: ");
                        luaChon = sc.nextInt();
                        if (luaChon == 1) {
                            // Người dùng nhập các thông tin cho nhân viên mới
                            System.out.print("-Mã nhân viên: ");
                            id = sc.next();
                            sc.nextLine();
                            System.out.print("-Tên nhân viên: ");
                            ten = sc.nextLine();
                            System.out.print("-Tuổi nhân viên: ");
                            tuoi = Integer.parseInt(sc.nextLine());
                            System.out.print("-Hệ số lương: ");
                            heSoLuong = Double.parseDouble(sc.nextLine());
                            System.out.print("-Ngày vào làm: ");
                            ngayVaoLam = sc.next();
                            System.out.println("-Bộ phận:");
                            System.out.println("Chọn 1: Phòng IT - Chọn 2: Phòng Kế Toán - Chọn 3: Phòng Kinh Doanh");
                            System.out.print("-Bạn chọn: ");
                            int luaChon = sc.nextInt();
                            if (luaChon == 1) {
                                boPhan = "Phong IT";
                            } else if (luaChon == 2) {
                                boPhan = "Ke Toan";
                            } else if (luaChon == 3) {
                                boPhan = "Kinh Doanh";
                            }
                            System.out.print("-Số ngày nghỉ phép: ");
                            soNnPhep = sc.nextInt();
                            System.out.print("-Số giờ làm thêm: ");
                            soGioLt = sc.nextInt();
                            // thêm nhân viên mới vào Arraylist
                            Employee nvMoi = new Employee(id, ten, tuoi, heSoLuong, ngayVaoLam, boPhan, soNnPhep, soGioLt);
                            danhSachNv.add(nvMoi);
                        } else if (luaChon == 2) {
                            // Người dùng nhập các thông tin cho Quản Lý mới
                            System.out.print("-Mã nhân viên: ");
                            id = sc.next();
                            sc.nextLine();
                            System.out.print("-Tên nhân viên: ");
                            ten = sc.nextLine();
                            System.out.print("-Tuổi nhân viên: ");
                            tuoi = Integer.parseInt(sc.nextLine());
                            System.out.print("-Hệ số lương: ");
                            heSoLuong = Double.parseDouble(sc.nextLine());
                            System.out.print("-Ngày vào làm: ");
                            ngayVaoLam = sc.next();
                            boPhan = "Quan Ly";
                            System.out.print("-Số ngày nghỉ phép: ");
                            soNnPhep = sc.nextInt();
                            System.out.println("- Chức danh:");
                            System.out.println("Chọn 1: Business Leader - Chọn 2: Project Leader - Chọn 3: Technical Leader");
                            System.out.print("Bạn chọn: ");
                            int x = sc.nextInt();
                            if (x == 1) {
                                chucDanh = "Business Leader";
                            } else if (x == 2) {
                                chucDanh = "Project Leader";
                            } else if (x == 3) {
                                chucDanh = "Technical Leader";
                            }
                            // thêm quản lý mới vào Arraylist
                            Manager qlMoi = new Manager(id, ten, tuoi, heSoLuong, ngayVaoLam, boPhan, soNnPhep, chucDanh);
                            danhSachNv.add(qlMoi);
                        }
                        System.out.println("Bạn có muốn nhập thêm nhân viên không?");
                        System.out.print("Chọn 1: Có - Chọn 2: Không ");
                        luaChon = sc.nextInt();
                    } while (luaChon == 1);
                }
                // option 5 : Tìm kiếm theo tên nhân viên
                case 5 -> {
                    System.out.print("Nhập vào tên nhân viên bạn muốn tìm: ");
                    String timTenNV = sc.nextLine();
                    boolean check = false;
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        if (danhSachNv.get(i).getTen().equalsIgnoreCase(timTenNV.trim())) {
                            danhSachNv.get(i).displayInfomation();
                            check = true;
                        }
                    }
                    if (!check) {
                        System.out.println(">>> Rất tiếc,nhân viên bạn tìm không có trong công ty <<<");
                    }
                }
                // option 6: Hiển thị bảng lương nhân viên
                case 6 -> {
                    System.out.println("Bảng lương toàn bộ nhân viên công ty:");
                    for (int i = 0; i < danhSachNv.size(); i++) {
                        System.out.println("Mã nhân viên: " + danhSachNv.get(i).getId() + "  Tên: " + danhSachNv.get(i).getTen()
                                            + "  Hệ số lương: " + danhSachNv.get(i).getHeSoLuong() + "  Bộ phận: "
                                            + danhSachNv.get(i).getBoPhan() + "   Lương: " + danhSachNv.get(i).calculateSalary());
                    }
                }
                // option 7: Bảng lương nhân viên từ thấp đến cao
                // Dùng Collections.sort
                case 7 -> {
                    // sao chép arrayList sang 1 arrayList Clone
                    ArrayList<Staff> arrClone = new ArrayList<>();
                    arrClone = (ArrayList<Staff>)(danhSachNv.clone());
                    System.out.println("Bảng lương toàn bộ nhân viên công ty theo thứ tự tăng dần:");
                    Collections.sort(arrClone, new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            return (int) (o1.calculateSalary() - (o2.calculateSalary()));
                        }
                    });
                    for (int i = 0; i < arrClone.size(); i++) {
                        System.out.println("Mã nhân viên: " + arrClone.get(i).getId() + "  Tên: " + arrClone.get(i).getTen()
                                            + "  Hệ số lương: " + arrClone.get(i).getHeSoLuong() + "  Bộ phận: "
                                            + arrClone.get(i).getBoPhan() + "   Lương: " + arrClone.get(i).calculateSalary());
                    }
                }
            }
        } while (luaChon != 8);
        // Hiện thông báo khi thoát chương trình
        System.out.println(">>>>>   Hẹn Gặp Lại  <<<<<");
    }
}
// Kết thúc
