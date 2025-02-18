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
            for (YogurtFlavor flavor : flavors) {
                System.out.println(flavor.getName() + " - $" + flavor.getPricePerScoop() + " per scoop");
            }
            System.out.println("\nEnter your yogurt flavor choice: ");
            int choice = scanner.nextInt();
            System.out.println("Enter number of scoops: ");
            int scoops = scanner.nextInt();
            order.addItem(flavors[choice - 1], scoops);

            System.out.println("Choose invoice format (text/csv): ");
            String format = scanner.next();
            order.generateInvoice(format);

            System.out.println("Invoice generated successfully!");
            scanner.close();
        }
}