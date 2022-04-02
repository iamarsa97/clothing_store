package store;


public abstract class Clothes<T> {

    //attributes
    protected String name;
    protected String brand;
    protected double price;
    protected String color;
    protected T size;
    protected ClothingType type;

    //constructor
    protected Clothes(String name, String brand, double price, String color, T size) throws InvalidSizeException {

        if (!checkSize(size)) throw new InvalidSizeException("Wrong size");

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.size = size;

    }

    //abstract method to check if size is valid
    protected abstract boolean checkSize(T size);

    //return the discount amount
    public double applyDiscount(int percentage) {
        return price * percentage / 100;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public ClothingType getType() {
        return type;
    }

    //public String getColor() { return color; }

    //public T getSize() { return size; }


}
