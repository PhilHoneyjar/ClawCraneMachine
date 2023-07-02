package src;

import java.util.Scanner;

class Commands {
    private static final Scanner scanner = new Scanner(System.in);

    public static void startGame() {
        ClawCrane clawCrane = ClawCrane.getInstance();

        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Enter the amount of money you want to spend (in dollars): ");
            double amountToSpend = scanner.nextDouble();

            clawCrane.play(amountToSpend);

            System.out.println("Would you like to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (playAgainInput.equalsIgnoreCase("no")) {
                playAgain = false;
                clawCrane.saveTrophyToys();
            }
        }
    }

    public static void tryCatchToy() {
        ClawCrane clawCrane = ClawCrane.getInstance();

        System.out.print("Enter the amount of money you want to spend (in dollars): ");
        double amountToSpend = scanner.nextDouble();

        clawCrane.play(amountToSpend);

        System.out.println("Amount spent: $" + clawCrane.getTotalSpent());
        System.out.println("Trophy Toys: ");
        for (Toy toy : clawCrane.getTrophyToys()) {
            System.out.println(toy.getName());
        }

        clawCrane.saveTrophyToys();
    }
}
