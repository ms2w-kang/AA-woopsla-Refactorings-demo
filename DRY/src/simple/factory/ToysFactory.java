package simple.factory;

public class ToysFactory {
    public Toy produceToy(String name) {
        Toy toy;

        switch (name) {
            case "Car":
                toy = new Car();
                break;
            case "Helicopter":
                toy = new Helicopter();
                break;
            case "Jumping Frog":
                toy = new JumpingFrog();
                break;
            default:
                toy = new NullToy();
                break;
        }


        toy.prepare();
        toy.packaging();
        toy.label();

        return toy;
    }
}
