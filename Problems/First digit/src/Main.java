import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int twoDigitNumber = scanner.nextInt();
        int firstDigit = (int) twoDigitNumber / 10;
        System.out.println(firstDigit);
    }
}