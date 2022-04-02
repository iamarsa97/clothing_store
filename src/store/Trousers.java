package store;

public class Trousers extends Clothes<Integer>{

    public Trousers(String name, String brand, double price, String color, Integer size) throws InvalidSizeException {
        super(name, brand, price, color, size);
        this.type = ClothingType.TROUSERS;
    }

    @Override
    protected boolean checkSize(Integer size) {
        return ((size >= 42) && (size <= 66) && (size % 2 == 0));
    }
}
