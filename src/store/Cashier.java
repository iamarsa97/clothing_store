package store;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cashier {

    //discount percentages
    private static final int quantityDiscount = 20;
    private static final int shirtTuesdayDiscount = 10;
    private static final int shoesTuesdayDiscount = 25;

    //checks if product applies for discount and returns discount percentage
    private static int discountPercentage(Clothes clothing, int quantityFlag, DayOfWeek day) {

        if (clothing.getType() == ClothingType.SHIRT && day == DayOfWeek.TUESDAY) {
            if ((quantityFlag * quantityDiscount) < shirtTuesdayDiscount) {
                return (shirtTuesdayDiscount);
            } else {
                return (quantityDiscount);
            }
        } else if (clothing.getType() == ClothingType.SHOES && day == DayOfWeek.TUESDAY) {
            if ((quantityFlag * quantityDiscount) < shoesTuesdayDiscount) {
                return (shoesTuesdayDiscount);
            } else {
                return (quantityDiscount);
            }
        } else {
            return (quantityFlag * quantityDiscount);
        }
    }

    //print purchase receipt
    public void printReceipt(ArrayList<Clothes> cart, LocalDate date, LocalTime time) {

        int quantityFlag = 0;
        double subtotal = 0;
        double discount = 0;
        int discPercentage;

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.printf("Date: %s %s\n\n", date.toString(), time.format(timeFormatter));
        System.out.println("---Products---");

        if (cart.size() >= 3) quantityFlag = 1;

        for (Clothes clothing : cart) {
            subtotal += clothing.getPrice();
            discPercentage = discountPercentage(clothing, quantityFlag, date.getDayOfWeek());
            System.out.println("\n" + clothing.getName() + " - " + clothing.getBrand());
            System.out.println("$" + clothing.getPrice());
            if (discPercentage != 0) {
                discount += clothing.applyDiscount(discPercentage);
                System.out.printf("#discount %d%% -$%.2f", discPercentage, clothing.applyDiscount(discPercentage));
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("SUBTOTAL: $%.2f\n", subtotal);
        System.out.printf("DISCOUNT: -$%.2f\n\n", discount);
        System.out.printf("TOTAL: $%.2f\n", subtotal - discount);

    }

    //main
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        ArrayList<Clothes> cart = new ArrayList<>();

        //add clothing to cart and print receipt
        try {
            cart.add(new Shirt("Blue Cotton Shirt", "BrandS", 18.5, "Blue", "XL"));
            cart.add(new Shoes("Black mamba", "BrandS", 79.99, "Black", 43));
            cart.add(new Trousers("Cotton Trousers", "BrandL", 25, "Blue", 42));
            cart.add(new Jacket("Leather jacket","BrandX",199.99,"Brown",44));

            cashier.printReceipt(cart, LocalDate.now(), LocalTime.now());

        } catch (InvalidSizeException err) {
            System.out.println(err.getMessage());
        }
    }
}
