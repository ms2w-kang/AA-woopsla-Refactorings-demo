package simple.factory;

public class Helicopter extends Toy {
    @Override
    public void prepare() {
        System.out.println("Prepare Hellicopter");
    }

    @Override
    public void label() {
        System.out.println("Label Hellicopter");
    }

    @Override
    public void packaging() {
        System.out.println("Packaging Hellicopter");
    }
}
