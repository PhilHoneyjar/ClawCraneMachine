package src;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class ClawCrane {
    private List<Toy> craneToys;
    private List<Toy> trophyToys;
    private double totalSpent;

    private static ClawCrane instance;

    private ClawCrane() {
        craneToys = new ArrayList<>();
        trophyToys = new ArrayList<>();
        totalSpent = 0;
        initializeToys();
    }

    public static ClawCrane getInstance() {
        if (instance == null) {
            instance = new ClawCrane();
        }
        return instance;
    }

    public List<Toy> getCraneToys() {
        return craneToys;
    }

    public List<Toy> getTrophyToys() {
        return trophyToys;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void play(double amountToSpend) {
        int tries = (int) (amountToSpend / 2);

        for (int i = 0; i < tries; i++) {
            if (craneToys.isEmpty()) {
                System.out.println("You have won all the available toys!");
                break;
            }

            Toy selectedToy = selectToy();
            if (selectedToy != null) {
                trophyToys.add(selectedToy);
                craneToys.remove(selectedToy);
                System.out.println("Congratulations! You won a toy: " + selectedToy.getName());
            } else {
                System.out.println("Better luck next time!");
            }
        }

        totalSpent += amountToSpend;
    }

    private void initializeToys() {
        // Add initial toys to the crane machine
        craneToys.add(new Toy(1, "Teddy Bear", 5, 0.4));
        craneToys.add(new Toy(2, "Robot", 3, 0.3));
        craneToys.add(new Toy(3, "Car", 2, 0.2));
        craneToys.add(new Toy(4, "Doll", 4, 0.5));
    }

    private Toy selectToy() {
        double totalChances = 0;

        for (Toy toy : craneToys) {
            totalChances += toy.getChanceToWin();
        }

        double randomValue = Math.random() * totalChances;
        double cumulativeChances = 0;

        for (Toy toy : craneToys) {
            cumulativeChances += toy.getChanceToWin();

            if (randomValue <= cumulativeChances) {
                return toy;
            }
        }

        return null;
    }

    public void saveTrophyToys() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);

        try (FileWriter writer = new FileWriter("trophy_toys_" + timestamp + ".txt")) {
            writer.write("Amount spent: $" + totalSpent + "\n");
            writer.write("Trophy Toys:\n");

            for (Toy toy : trophyToys) {
                writer.write(toy.getName() + "\n");
            }

            System.out.println("Trophy toys have been saved to a file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the trophy toys.");
        }
    }
}
