package coupling07.facade;

public class ElevatorMotor implements IMotor {
    public void stop() {
        System.out.println("Elevator Motor Stop");
    }

    public void move(int direction) {
        System.out.println("Elevator Motor Move with direction " + direction);
    }
}

