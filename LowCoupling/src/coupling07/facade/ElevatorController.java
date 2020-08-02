package coupling07.facade;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private int curFloor = 1;
    private final List<Integer> destinations = new ArrayList<>();

    private final IMotor motor;
    private boolean isMoving = false;
    private final ElevatorDoor elevatorDoor;
    private final List<FloorDoor> floorDoors;
    private final DoorTimer doorTimer;

    public ElevatorController(IMotor motor, ElevatorDoor elevatorDoor,
                              List<FloorDoor> floorDoors, DoorTimer doorTimer) {
        super();
        this.motor = motor;
        this.elevatorDoor = elevatorDoor;
        this.floorDoors = floorDoors;
        this.doorTimer = doorTimer;
    }

    public void goTo(int destination) {
        if (!destinations.contains(destination)) destinations.add(destination);
        if (!isMoving) {
            int direction = determineMovingDirection();
            if (direction != 0) {
                motor.move(direction);
                isMoving = true;
            }
        }
    }

    public void approaching(int floor) {
        System.out.println("\nApproaching " + floor + "th floor");
        curFloor = floor;
        if (needToStop(floor)) {
            motor.stop();
            isMoving = false;
            elevatorDoor.open();
            floorDoors.get(curFloor - 1).open();
            doorTimer.start(this);
            destinations.remove(Integer.valueOf(floor));
        }
    }

    private boolean needToStop(int floor) {
        return destinations.contains(floor);
    }

    public void doorTimeout() {
        if (isMoving) return;
        elevatorDoor.close();
        floorDoors.get(curFloor - 1).close();
        doorTimer.stop();
        int direction = determineMovingDirection();
        if (direction != 0) {
            motor.move(direction);
            isMoving = true;
        }
    }

    private int determineMovingDirection() {
        if (destinations.size() == 0) return 0;
        int destination = destinations.get(0);
        if (destination > curFloor) return 1;
        return -1;
    }
}


