package srp15.move.embellishment.to.decorator;

public class Driver {

    public static void main(String[] args) {

        WriterPolicy policy = new WriterPolicy();
        policy.setCapitalized(true);

        Writer writer = new StringWriter(policy.isCapitalized());

        writer.write("This is stupid");
        System.out.println(writer);
    }
}
