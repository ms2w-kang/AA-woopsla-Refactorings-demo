package factory.method;

public class ElevatorController {
    private final int id;
    private final Motor motor;
    private int curFloor = 1;

    public ElevatorController(int id, Motor motor) {
        this.id = id;
        this.motor = motor;
    }

    public void gotoFloor(int destination) {
        if (destination == curFloor) return;
        Direction direction = getDirection(destination);
        motor.move(direction);
        System.out.print("Elevator [" + id + "] Floor: " + curFloor);

        curFloor = destination;
        System.out.println(" ==> " + curFloor + " with " + motor.getClass().getSimpleName());
        motor.stop();
    }

    private Direction getDirection(int destination) {
        return destination > curFloor ? Direction.UP : Direction.DOWN;
    }
}

