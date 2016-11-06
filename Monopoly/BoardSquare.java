public class BoardSquare {
    private String name, type, color;
    private int price, rent;

    public BoardSquare() {
        name = "";
        type = "";
        price = 0;
        rent = 0;
        color = "";
    }
    public BoardSquare(String name, String type, int price, int rent, String color) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.color = color;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getPrice() { return price; }
    public int getRent() { return rent; }
    public String getColor() { return color; }

    public String toString() {
        return name + ", " + type + ", " + price + ", " + rent + ", " + color;
    }
}
