package simple.factory;

public class JumpingFrog extends Toy {
    @Override
    public void prepare() {
        System.out.println("Prepare Jumping Frog");
    }

    @Override
    public void label() {
        System.out.println("Label Jumping Frog");
    }

    @Override
    public void packaging() {
        System.out.println("Packaging Jumping Frog");
    }
}
