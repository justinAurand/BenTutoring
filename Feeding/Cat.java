public class Cat {
    private String name;
    private String type;
    private double weight;
    private int age;
    private boolean isPregnant;

    public Cat() {
        name = "";
        type = "";
        weight = 0;
        age = 0;
        isPregnant = false;
    }
    public Cat(String name, String type, double weight, int age, boolean isPregnant) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.age = age;
        this.isPregnant = isPregnant;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getWeight() {
        return weight;
    }
    public int getage() {
        return age;
    }
    public boolean getIsPregnant() {
        return isPregnant;
    }

    public String getFeedingTime() {
        if (type == "Puma")
            return "8pm";
        return "8am";
    }

    public String toString() {
        return "Name: " + name + " Type: " + type + " Weight: " + weight +
            " Age: " + age + " isPregnant: " + isPregnant;
    }
}
