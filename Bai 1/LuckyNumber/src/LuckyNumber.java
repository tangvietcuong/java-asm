
import java.util.Scanner;
public class LuckyNumber {
    // TODO: Đặt biến có scope Global
    public static Scanner sc = new Scanner(System.in);
    public static int count = 0;                            // đặt biến đếm số lần nhập số của 1 lần chơi
    public static int totalGuesses = 0;                     // đặt biến đếm tổng số lần nhập số
    public static int totalGames = 0;                       // đặt biến tổng số lần chơi
    public static int bestGame = Integer.MAX_VALUE;         // lấy ra số lớn nhất
    public static String yourChoice = "";

    public static void main(String[] args) {
        /*
         *   TODO: dùng vòng lặp do..while
         *      1.để lặp lại lượt chơi và so sánh giá trị nhập vào với random.
         *      2.để hỏi xem người chơi có tiếp tục chơi,nếu chọn đúng thì lặp lại game
         * */
        System.out.println("GAME: LUCKY NUMBER ");
        do {
            play();

            totalGames++;                    // mỗi khi kết thúc 1 lượt chơi,totalGames tăng lên 1
            System.out.print("Play again? ('Yes' or 'Y' to Continue; press anykey to Exit): ");
            yourChoice = sc.next();
            totalGuesses += count;           // Tổng số lần nhập số trong tất cả các lượt chơi
            count = 0;                       // reset lại biến đếm số lần đoán sau 1 lượt chơi.
        } while (yourChoice.equalsIgnoreCase("Y") || yourChoice.equalsIgnoreCase("Yes"));

            report();
    }
    // TODO: Hàm play() để thực hiện trò chơi nhập số.
    public static void play() {
        int yourNumber;
        int max = 100;
        int random = (int) (Math.random() * (max + 1));        // max + 1:  để ra được số random từ 0 đến 100.
        System.out.println("I'm thinking of a number between 0 and " + max + " ...");
        do {
            System.out.print("Your Lucky Number is: ");
            yourNumber = sc.nextInt();
                if (yourNumber < 0 || yourNumber > max) {
                    throw new IllegalArgumentException();
                }
                if (yourNumber < random) {
                    System.out.println("No,it's higher");
                    count++;
                } else if (yourNumber > random) {
                    System.out.println("No,it's Lower");
                    count++;
                } else {
                    count++;
                        if (count < bestGame) {
                            bestGame = count;
                        }
                    System.out.println("Congratulations!");
                    System.out.println("You got it right in " + count + " guesses.");
                }
        } while (yourNumber != random);
    }
    public static void report() {
        // TODO: Hàm report() để in ra thống kê của người chơi
        double x = (double)totalGuesses / totalGames; // x bằng tổng lượt đoán các lượt chia cho tổng số lần chơi
        double average = (double)(Math.round(x*100))/100;     // làm tròn 2 số sau dấu thập phân
        System.out.println();
        System.out.println("Overall Result: ");
        System.out.println(" - Total Games: " + totalGames);
        System.out.println(" - Total Guesses: " + totalGuesses);
        System.out.println(" - Guesses/Games: " + average);
        System.out.println(" - Best Game: " + bestGame);
    }
}

