import java.util.Scanner;

public class YogurtShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        // Available Yogurt Flavors
        YogurtFlavor[] flavors = {
                new YogurtFlavor("Cookies and Cream", 2.80),
                new YogurtFlavor("Chocolate Fudge", 3.00),
                new YogurtFlavor("Pistachio Delight", 3.25)
        };

        // Available Toppings
        YogurtTopping[] toppings = {
                new YogurtTopping("Sprinkles", 0.30),
                new YogurtTopping("Mixed chopped nuts", 0.80),
                new YogurtTopping("Crushed Gingerbread", 0.75),
                new YogurtTopping("Fresh Strawberries", 1.00)
        };

        System.out.println("Welcome to Yogurt Shop!\n");

        boolean moreFlavors = true;
        while (moreFlavors) {
            for (int i = 0; i < flavors.length; i++) {
                System.out.println((i + 1) + ". " + flavors[i].getName() + " - $" + flavors[i].getPricePerScoop() + " per scoop");
            }
            System.out.println("\nEnter your yogurt flavor choice: ");
            int flavorChoice = scanner.nextInt();
            System.out.println("Enter number of scoops: ");
            int scoops = scanner.nextInt();
            order.addItem(flavors[flavorChoice - 1], scoops);

            System.out.println("Would you like to add another flavor? (yes/no): ");
            moreFlavors = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nAvailable Toppings:");
        for (int i = 0; i < toppings.length; i++) {
            System.out.println((i + 1) + ". " + toppings[i].getName() + " - $" + toppings[i].getPrice());
        }
        System.out.println("Enter topping choices (comma separated, e.g., 1,3): ");
        scanner.nextLine(); // consume newline
        String[] toppingChoices = scanner.nextLine().split(",");
        for (String choice : toppingChoices) {
            int toppingIndex = Integer.parseInt(choice.trim()) - 1;
            order.addTopping(toppings[toppingIndex]);
        }

        System.out.println("Choose container type (1 for Glass Jar, 2 for Paper Cup): ");
        int containerChoice = scanner.nextInt();
        order.setGlassJar(containerChoice == 1);

        System.out.println("Choose invoice format (text/csv): ");
        scanner.nextLine(); // consume newline
        String format = scanner.nextLine();
        order.generateInvoice(format);

        System.out.println("Invoice generated successfully!");
        scanner.close();
    }
}