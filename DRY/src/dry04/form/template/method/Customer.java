package dry04.form.template.method;

public class Customer {
    private String name;
    private int point;

    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
