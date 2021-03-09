import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int up = Integer.parseInt(scanner.nextLine());
        int down = Integer.parseInt(scanner.nextLine());

        int diff = up - down;

        int daysToReachTheTop = (height-up)/diff + 1;

        if (((height-up) % diff) > 0) {
            daysToReachTheTop++;
        }

        System.out.println(daysToReachTheTop);
    }
}