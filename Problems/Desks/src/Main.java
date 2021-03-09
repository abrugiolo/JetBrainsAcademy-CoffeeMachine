import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grupo1 = Integer.parseInt(scanner.next());
        int grupo2 = Integer.parseInt(scanner.next());
        int grupo3 = Integer.parseInt(scanner.next());

        int numMesas = grupo1/2 + grupo1%2 +grupo2/2 + grupo2%2 +grupo3/2 + grupo3%2;

        System.out.println(numMesas);
    }
}