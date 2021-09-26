package machine;

import java.util.Scanner;

//make abstract class drink(water, milk, coffee, money, cups) in another file, and

public class CoffeeMachine {

    private static int mlOfWater = 400, mlOfMilk = 540, gOfCoffee = 120, numberOfCups = 9, funds = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String command = scanner.nextLine();
        while(!command.equals("exit")) {
            switch (command) {
                case "fill":
                    actionFill();
                    break;
                case "buy":
                    actionBuy();
                    break;
                case "take":
                    actionTake();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Command not recognized, please try again.");
                    break;

            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            command = scanner.next();
        }
    }

    private static void actionBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.next();
        switch (input) {
            case "1":
                if (makeCoffeePossible(250, 0, 16, 4)) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (makeCoffeePossible(350, 75, 20, 7)) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (makeCoffeePossible(200, 100, 12, 6)) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
        }
    }
            // separate makeCoffeePossible in two methods (checkPossibleCoffee and unableToMakeCoffee) to apply all OOP possible
    private static boolean makeCoffeePossible(int water, int milk, int coffee, int money) {

        if (mlOfWater - water >= 0 && mlOfMilk - milk >= 0 && gOfCoffee - coffee >= 0 && numberOfCups - 1 >= 0){
            mlOfWater -= water;
            mlOfMilk -= milk;
            gOfCoffee -= coffee;
            numberOfCups--;
            funds += money;
            return true;
        }
        System.out.print("Sorry, not enough ");
        if(mlOfWater - water < 0)
            System.out.println("water!");
        else
        if (mlOfMilk - milk < 0)
            System.out.println("milk!");
        else
        if(gOfCoffee - coffee < 0)
            System.out.println("coffee beans");
        else
            System.out.println("cups");
        return false;
    }

    private static void remaining() {
        System.out.println("The coffee machine has:\n" +
                mlOfWater + " ml of water\n" +
                mlOfMilk + " ml of milk\n" +
                gOfCoffee + " g of coffee beans\n" +
                numberOfCups + " disposable cups\n" +
                "$" + funds + " of money");
    }

    private static void actionTake(){
        System.out.println("I gave you $" + funds);
        funds = 0;
    }

    private static void actionFill(){
        System.out.println("Write how many ml of water you want to add:");
        mlOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        mlOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        gOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        numberOfCups += scanner.nextInt();
    }



}
