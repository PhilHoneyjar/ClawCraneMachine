package src;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private double chanceToWin;

    public Toy(int id, String name, int quantity, double chanceToWin) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.chanceToWin = chanceToWin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getChanceToWin() {
        return chanceToWin;
    }

    public void setChanceToWin(double chanceToWin) {
        this.chanceToWin = chanceToWin;
    }
}