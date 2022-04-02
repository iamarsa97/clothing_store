package store;

public class Shoes extends Clothes<Integer> {


    public Shoes(String name, String brand, double price, String color, Integer size) throws InvalidSizeException {
        super(name, brand, price, color, size);
        this.type = ClothingType.SHOES;
    }

    @Override
    protected boolean checkSize(Integer size) {
        return ((size >= 36) && (size <= 46));

    }
}
