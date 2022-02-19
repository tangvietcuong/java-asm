import java.util.Scanner;

public class gradeStudent {
    // đặt biến
    static int max = 100;
    static Scanner sc = new Scanner(System.in);
    static int weightValue1;
    static int weightValue2;
    static int weightValue3;
    static int totalPoint;
    public static void main(String[] args) {
        begin();
        /* 3 biến dưới đây thực thi 2 nhiệm vụ:
         *   - 1. thực thi hàm gọi tên
         *   - 2. nhận giá trị được return
        */
        double weightedMidTermScore = midTerm();
        double weightedFinalTermScore = finalTerm();
        double weightedHomeworkScore = homeWork();
        report(weightedMidTermScore,weightedFinalTermScore,weightedHomeworkScore);
    }
    // Hàm 1: Bắt đầu - tạo thông báo cho người dùng
    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
        System.out.println("Let's enter your score!");
    }
    // Hàm 2: Người dùng nhập điểm thi giữa kì và tính ra tổng điểm theo trọng số
    public static double midTerm() {
        System.out.println("Midterm Score: ");
        do {
            System.out.print("Weight 1 (0-100): ");
            weightValue1 = sc.nextInt();                     // trọng số từ 0 - 100;
        } while (weightValue1 < 0 || weightValue1 > 100);
        System.out.print("Score earned: ");
        int scoreMTerm = sc.nextInt();                          // điểm thi giữa kì
            System.out.print("Were scores shifted (1 = yes, 2 = no): ");
            int option = sc.nextInt();
        if (option == 1) {
            System.out.print("Shift amount: ");         // điểm cộng
            int shilftAmount = sc.nextInt();
            scoreMTerm += shilftAmount;
        }
        totalPoint = Math.min(scoreMTerm, max);         // đảm bảo totalPoint k vượt quá max
        System.out.println("Total points = " + totalPoint + "/" + max);    // tổng điểm = điểm + điểm cộng
        double x = (double)totalPoint/max*weightValue1;                  // điểm theo trọng số
        double weightedScore = (double)Math.round(x*10)/10;          // Lấy sau dấu thập phân 1 chữ số
        System.out.println("Weighted score = " + weightedScore + "/" + weightValue1);
        System.out.println();
        return weightedScore;              // trả về tổng điểm thi giữa kì
    }
    // Hàm 3: Người dùng nhập điểm thi cuối kì và tính ra tổng điểm theo trọng số
    public static double finalTerm() {
        System.out.println("FinalTerm Score: ");
        do {
            System.out.print("Weight 2 (0-100): ");
            weightValue2 = sc.nextInt();                            // trọng số từ 0 - 100;
        } while (weightValue2 < 0 || weightValue2 > 100);
        System.out.print("Score earned: ");
        int scoreFTerm = sc.nextInt();                                 // điểm thi cuối kì
        System.out.print("Were scores shifted (1 = yes, 2 = no): ");
        int option = sc.nextInt();
        if (option == 1) {
            System.out.print("Shift amount: ");                       // điểm cộng
            int shilftAmount = sc.nextInt();
            scoreFTerm += shilftAmount;
        }
        totalPoint = Math.min(scoreFTerm, max);
        System.out.println("Total points = " + totalPoint + "/" + max);     // tổng điểm = điểm thi + điểm cộng
        double x = (double)totalPoint/max*weightValue2;                     // điểm theo trọng số
        double weightedScore = (double)Math.round(x*10)/10;                 // Lấy sau dấu thập phân 1 chữ số
        System.out.println("Weighted score = " + weightedScore + "/" + weightValue2 );
        System.out.println();
        return weightedScore;              // trả về tổng điểm thi cuối kì
    }
    // Hàm 4: Bài tập về nhà
    public static double homeWork() {
        System.out.println("Homework Score:");
        do {
            System.out.print("Weight 3 (Note:Weight 1 + Weight 2 + Weight 3 = 100): ");
            weightValue3 = sc.nextInt();                             // trọng số 3
        } while(weightValue3 != 100 - (weightValue1+weightValue2));  // tổng 3 trọng số = 100;
        System.out.print("Number of assignments: ");            // số lượng bài tập
        int num = sc.nextInt();
        int asmScore = 0;
        int asmMaxScore = 0;
        for (int i=1; i<=num; i++) {        // vòng lặp in ra từng bài tập với điểm và điểm tối đa.
            System.out.println("Assignment " + i + ":");
            System.out.print("   - Your score and max: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            asmScore += a;
            asmMaxScore += b;
        }
        System.out.print("How many sections did you attend: ");          // số lần điểm danh
        int section = sc.nextInt();
        int sectionPoint = section*5;               // 1 lần điểm danh tương ứng 5 point
        int maxSectionPoint = 30;                   //  tương ứng tối đa 6 lần điểm danh
        if (sectionPoint > maxSectionPoint) {
            sectionPoint = maxSectionPoint;
        }
        System.out.println("Section points: " + sectionPoint + "/" + maxSectionPoint);   // điểm chuyên cần
        totalPoint = asmScore + sectionPoint;
        if (totalPoint > 150) {
            totalPoint = 150;
        }
        int totalMaxScore = asmMaxScore + maxSectionPoint;
        if (totalMaxScore > 150) {
            totalMaxScore = 150;
        }
        System.out.println("Total points: " + totalPoint + "/" + totalMaxScore);   // tổng điểm / tổng max
        double x = (double) totalPoint/totalMaxScore*weightValue3;             //tổng điểm theo trọng số
        double weightScore = (double)Math.round(x*10)/10;             // làm tròn sau dấu thập phân 1 chữ số
        System.out.println("Weighted score: " + weightScore + "/" + weightValue3);
        System.out.println();
        return weightScore;                 // trả về tổng điểm phần bài tập
    }
    // Hàm 5: Hàm Tổng kết với 3 tham số là 3 giá trị trả về của 3 hàm trên.
    public static void report(double weightedMidTermScore,double weightedFinalTermScore,double weightedHomeworkScore) {
        double x = weightedMidTermScore + weightedFinalTermScore + weightedHomeworkScore;
        double grade = (double)Math.round(x*10)/10;
        System.out.println("Total and Rating: ");
        System.out.println("Overall percentage: " + grade + "%");  // tổng điểm tính theo thang 100 đ
        // tính điểm theo thang GPA và hiện thông báo điểm tương ứng
        double resultGPA;
        double maxGPA = 4.0;
        if (grade == 100) {
            resultGPA = maxGPA;
            System.out.println("Your grade will be at least: " + resultGPA);
            System.out.println(">>>>>Congratulations! You got the best score<<<<<");
        }
        else if (grade >= 85) {
            resultGPA = 3.0;
            System.out.println("Your grade will be at least: " + resultGPA);
            System.out.println(">>>>>Congratulations! You got a perfect score<<<<<");
        } else if (grade < 85 && grade >= 75) {
            resultGPA = 2.0;
            System.out.println("Your grade will be at least: " + resultGPA);
            System.out.println(">>>>>You did it Well!<<<<<");
        } else if (grade < 75 && grade >= 60) {
            resultGPA = 1.0;
            System.out.println("Your grade will be at least: " + resultGPA);
            System.out.println(">>>>>Well, You tried so hard!<<<<<");
        } else {
            resultGPA = 0.0;
            System.out.println("Your grade will be at least: " + resultGPA);
            System.out.println(">>>>>Caution: You have to study again!<<<<<");
        }
    }
    // Kết thúc
}
