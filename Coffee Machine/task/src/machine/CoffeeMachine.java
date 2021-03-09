package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner;

    static final String BUY_OPTION = "buy", FILL_OPTION = "fill", TAKE_OPTION = "take",
            REMAINING_OPTION = "remaining", EXIT_OPTION = "exit";

    final String ESPRESSO_OPTION = "1", LATTE_OPTION = "2", CAPPUCCINO_OPTION = "3", BACK_TO_MAIN_MENU = "back";

    final int WATER_ESPRESSO = 250, MILK_ESPRESSO = 0, BEANS_ESPRESSO = 16, PRICE_ESPRESSO = 4,
            WATER_LATTE = 350, MILK_LATTE = 75, BEANS_LATTE = 20, PRICE_LATTE = 7,
            WATER_CAPPUCCINO = 200, MILK_CAPPUCCINO = 100, BEANS_CAPPUCCINO = 12, PRICE_CAPPUCCINO = 6;

    private int water, milk, beans, cups, money;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
    }

    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public int getBeans() {
        return beans;
    }
    public void setBeans(int beans) {
        this.beans = beans;
    }
    public int getCups() {
        return cups;
    }
    public void setCups(int cups) {
        this.cups = cups;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public boolean checkResourcesAvailability(String option) {
        int currentWater = getWater(), currentMilk = getMilk(), currentBeans = getBeans(), currentCups = getCups();
        int neededWater = -1, neededMilk = -1, neededBeans = -1;

        switch (option) {
            case ESPRESSO_OPTION:
                neededWater = WATER_ESPRESSO;
                neededMilk = MILK_ESPRESSO;
                neededBeans = BEANS_ESPRESSO;
                break;
            case LATTE_OPTION:
                neededWater = WATER_LATTE;
                neededMilk = MILK_LATTE;
                neededBeans = BEANS_LATTE;
                break;
            case CAPPUCCINO_OPTION:
                neededWater = WATER_CAPPUCCINO;
                neededMilk = MILK_CAPPUCCINO;
                neededBeans = BEANS_CAPPUCCINO;
                break;
            default:
                break;
        }

        if (currentWater < neededWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (currentMilk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (currentBeans < neededBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (currentCups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    public void makingCoffee(String coffeeOption) {
        int neededWater = -1, neededMilk = -1, neededBeans = -1, price = -1;

        switch (coffeeOption) {
            case ESPRESSO_OPTION:
                neededWater = WATER_ESPRESSO;
                neededMilk = MILK_ESPRESSO;
                neededBeans = BEANS_ESPRESSO;
                price = PRICE_ESPRESSO;
                break;
            case LATTE_OPTION:
                neededWater = WATER_LATTE;
                neededMilk = MILK_LATTE;
                neededBeans = BEANS_LATTE;
                price = PRICE_LATTE;
                break;
            case CAPPUCCINO_OPTION:
                neededWater = WATER_CAPPUCCINO;
                neededMilk = MILK_CAPPUCCINO;
                neededBeans = BEANS_CAPPUCCINO;
                price = PRICE_CAPPUCCINO;
                break;
            default:
                break;
        }

        setWater(getWater() - neededWater);
        setMilk(getMilk() - neededMilk);
        setBeans(getBeans() - neededBeans);
        setCups(getCups() - 1);
        setMoney(getMoney() + price);
    }

    public void doCoffee(String option) {
        if (!checkResourcesAvailability(option)) {
            //System.out.println("\nSorry, not enough resources!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        makingCoffee(option);
    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.next();

        if (option.equalsIgnoreCase(BACK_TO_MAIN_MENU)) return;

        doCoffee(option);
    }

    public void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        setWater(getWater() + scanner.nextInt());
        System.out.println("\nWrite how many ml of milk do you want to add:");
        setMilk(getMilk() + scanner.nextInt());
        System.out.println("\nWrite how many grams of coffee beans do you want to add:");
        setBeans(getBeans() + scanner.nextInt());
        System.out.println("\nWrite how many disposable cups do you want to add:");
        setCups(getCups() + scanner.nextInt());
    }

    public void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", getWater());
        System.out.printf("%d of milk\n", getMilk());
        System.out.printf("%d of coffee beans\n", getBeans());
        System.out.printf("%d of disposable cups\n", getCups());
        System.out.printf("%d of money\n", getMoney());
    }

    public void take() {
        int currentMoney = getMoney();

        if (currentMoney == 0) {
            System.out.println("\nSorry, I have no money to give.");
            return;
        }

        System.out.printf("I gave you $%d\n", currentMoney);
        setMoney(0);  // setMoney(currentMoney - currentMoney);
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        scanner = new Scanner(System.in);

        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = scanner.next();

        while (!action.equalsIgnoreCase(EXIT_OPTION)) {
            switch (action) {
                case BUY_OPTION:
                    cm.buy();
                    break;
                case FILL_OPTION:
                    cm.fill();
                    break;
                case TAKE_OPTION:
                    cm.take();
                    break;
                case REMAINING_OPTION:
                    cm.remaining();
                    break;
                default:
                    System.out.println("\nInvalid action.");
                    break;
            }

            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
        }
    }
}