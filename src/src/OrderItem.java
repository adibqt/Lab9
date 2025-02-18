public class OrderItem {
    private YogurtFlavor flavor;
    private int scoops;

    public OrderItem(YogurtFlavor flavor, int scoops) {
        this.flavor = flavor;
        this.scoops = scoops;
    }

    public double getTotalPrice() {
        return scoops * flavor.getPricePerScoop();
    }

    public YogurtFlavor getFlavor() {
        return flavor;
    }
    public int getScoops() {
        return scoops;
    }
    public String toString() {
        return flavor.getName() + " - " + scoops + " scoop(s): $" + getTotalPrice();
    }
}
