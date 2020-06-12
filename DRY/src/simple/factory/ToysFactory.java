package simple.factory;

public class ToysFactory {
    public Toy produceToy(String name) {
        Toy toy = null;

        if (name.equals("Car")) {
            toy = new Car();
        } else if (name.equals("Helicopter")) {
            toy = new Helicopter();
        } else {
            toy = new NullToy();
        }

        //region @Frog
//		else if (name.equals("Jumping Frog"))
//		{
//			toy = new JumpingFrog();
//		}
        //endregion

        toy.prepare();
        toy.packaging();
        toy.label();

        return toy;
    }
}
