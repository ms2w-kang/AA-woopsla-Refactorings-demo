package factory.method;

public class Door {
    private DoorStatus doorStatus = DoorStatus.CLOSED;

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public void close() {
        setDoorStatus(DoorStatus.CLOSED);
    }

    public void open() {
        setDoorStatus(DoorStatus.OPENED);
    }
}
