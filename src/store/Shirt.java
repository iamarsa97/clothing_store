package store;


import java.util.HashSet;
import java.util.Set;

public class Shirt extends Clothes<String> {

    //sizes set
    private static Set<String> sizes = new HashSet<>();

    //init sizes
    static {
        sizes.add("XS");
        sizes.add("S");
        sizes.add("M");
        sizes.add("L");
        sizes.add("XL");
        sizes.add("2XL");
    }

    public Shirt(String name, String brand, double price, String color, String size) throws InvalidSizeException {
        super(name, brand, price, color, size);
        this.type = ClothingType.SHIRT;
    }

    @Override
    protected boolean checkSize(String size) {
        return sizes.contains(size);
    }

}
