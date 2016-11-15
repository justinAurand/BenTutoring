public class Feeding {
    public static void main(String[] args) {
        Cat catFace = new Cat("CatFace", "Puma", 12, 1, false);
        System.out.println(catFace.getFeedingTime());

        Cat cattyMcCatface = new Cat("Catty McCatface", "Leopard", 250, 20, true);
        System.out.println(cattyMcCatface.getFeedingTime());
    }
}
