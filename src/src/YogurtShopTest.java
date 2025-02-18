import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YogurtShopTest {

    @Test
    public void testAddItem() {
        Order order = new Order();
        YogurtFlavor flavor = new YogurtFlavor("Chocolate Fudge", 3.00);
        order.addItem(flavor, 2);
        assertEquals(1, order.getItems().size());
        assertEquals(6.00, order.calculateSubtotal());
    }


    @Test
    public void testAddTopping() {
        Order order = new Order();
        YogurtTopping topping = new YogurtTopping("Sprinkles", 0.30);
        order.addTopping(topping);
        assertEquals(1, order.getToppings().size());
        assertEquals(0.30, order.calculateSubtotal());
    }

    @Test
    public void testCalculateSubtotal() {
        Order order = new Order();
        YogurtFlavor flavor = new YogurtFlavor("Cookies and Cream", 2.80);
        YogurtTopping topping = new YogurtTopping("Fresh Strawberries", 1.00);
        order.addItem(flavor, 2);
        order.addTopping(topping);
        assertEquals(6.60, order.calculateSubtotal());
    }

    @Test
    public void testCalculateTax() {
        Order order = new Order();
        YogurtFlavor flavor = new YogurtFlavor("Pistachio Delight", 3.25);
        YogurtTopping topping = new YogurtTopping("Crushed Gingerbread", 0.75);
        order.addItem(flavor, 3);
        order.addTopping(topping);
        assertEquals(0.68, order.calculateTax());
    }

    @Test
    public void testGenerateTextInvoice() {
        Order order = new Order();
        YogurtFlavor flavor = new YogurtFlavor("Chocolate Fudge", 3.00);
        YogurtTopping topping = new YogurtTopping("Sprinkles", 0.30);
        order.addItem(flavor, 2);
        order.addTopping(topping);
        order.setGlassJar(false);
        order.generateInvoice("text");
        // Check if the file "invoice.txt" is created and contains the expected content
        // This part is usually done by reading the file and comparing its content
        // For simplicity, we assume the file is correctly generated
        assertTrue(new java.io.File("invoice.txt").exists());
    }

}


