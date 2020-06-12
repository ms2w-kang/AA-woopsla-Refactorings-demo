package coupling07.facade;

public class FloorDoor implements IDoor {
    private int floor;

    public FloorDoor(int floor) {
        this.floor = floor;
    }
    public void open() {
        System.out.println(floor + "th Floor Door Open");
    }

    public void close() {
        System.out.println(floor + "th Floor Door Close");
    }
}
