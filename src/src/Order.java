import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order {

    private List<OrderItem> items = new ArrayList<>();
    private List<YogurtTopping> toppings = new ArrayList<>();
    private boolean isGlassJar;
    private static final double TAX_RATE = 0.08;
    private static final double GLASS_JAR_COST = 5.00;

    public void addItem(YogurtFlavor flavor, int scoops) {
        items.add(new OrderItem(flavor, scoops));
    }

    public void addTopping(YogurtTopping topping) {
        toppings.add(topping);
    }

    public void setGlassJar(boolean isGlassJar) {
        this.isGlassJar = isGlassJar;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getTotalPrice();
        }
        for (YogurtTopping topping : toppings) {
            subtotal += topping.getPrice();
        }
        if (isGlassJar) {
            subtotal += GLASS_JAR_COST;
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void generateInvoice(String format) {
        if (format.equalsIgnoreCase("text")) {
            generateTextInvoice();
        } else if (format.equalsIgnoreCase("csv")) {
            generateCSVInvoice();
        }
    }

    private void generateTextInvoice() {
        try (FileWriter writer = new FileWriter("invoice.txt")) {
            writer.write("Yogurt Shop Invoice\n");
            for (OrderItem item : items) {
                writer.write(item.toString() + "\n");
            }
            for (YogurtTopping topping : toppings) {
                writer.write(topping.getName() + " - 1 time: $" + topping.getPrice() + "\n");
            }
            writer.write("Subtotal: $" + calculateSubtotal() + "\n");
            writer.write("Tax: $" + calculateTax() + "\n");
            writer.write("Total Amount Due: $" + calculateTotal() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateCSVInvoice() {
        try (FileWriter writer = new FileWriter("invoice.csv")) {
            writer.write("Ingredients,Amount,Price\n");
            for (OrderItem item : items) {
                writer.write(item.getFlavor().getName() + "," + item.getScoops() + "," + item.getTotalPrice() + "\n");
            }
            for (YogurtTopping topping : toppings) {
                writer.write(topping.getName() + ",1," + topping.getPrice() + "\n");
            }
            writer.write("Subtotal,-," + calculateSubtotal() + "\n");
            writer.write("Tax,-," + calculateTax() + "\n");
            writer.write("Total Amount Due,-," + calculateTotal() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Object> getItems() {
        return new ArrayList<>(items);

    }

    public Collection<Object> getToppings() {
        return new ArrayList<>(toppings);
    }
}
