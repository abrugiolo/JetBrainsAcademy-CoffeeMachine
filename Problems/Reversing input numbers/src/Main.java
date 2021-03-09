import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());

        System.out.printf("%d %d\n", y, x);
    }
}