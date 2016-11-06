public class Player {
    String name, token;
    int location, balance;

    public Player() {
        name = "";
        token = "";
        location = 0;
        balance = 1500;
    }
    public Player(String name, String token, int location, int balance) {
        this.name = name;
        this.token = token;
        this.location = location;
        this.balance = balance;
    }

    public String getName() { return name; }
    public String getToken() { return token; }
    public int getLocation() { return location; }
    public int getBalance() { return balance; }

    public void setName(String name) { this.name = name; }
    public void setToken(String token) { this.token = token; }
    public void setLocation(int location) { this.location = location; }
    public void setBalance(int balance) { this.balance = balance; }

    public String toString() {
        return name + ", " + token + ", " + Integer.toString(location) + ", $" + Integer.toString(balance);
    }
}
