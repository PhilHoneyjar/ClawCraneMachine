package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("==== Toy Claw Crane Game ====");
            System.out.println("1. Start Game");
            System.out.println("2. Try to Catch Toy and Show Result");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Commands.startGame();
                case 2 -> Commands.tryCatchToy();
                case 3 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

