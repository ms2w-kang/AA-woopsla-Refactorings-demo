package simple.factory;

public class Car extends Toy {
    @Override
    public void prepare() {
        System.out.println("Prepare Car");
    }

    @Override
    public void label() {
        System.out.println("Label Car");
    }

    @Override
    public void packaging() {
        System.out.println("Packaging Car");
    }
}
