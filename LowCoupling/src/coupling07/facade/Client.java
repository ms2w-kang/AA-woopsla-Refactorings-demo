package coupling07.facade;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String args[]) {
        final int MAX_FLOOR = 10;
        ElevatorMotor elevatorMotor = new ElevatorMotor();
        ElevatorDoor elevatorDoor = new ElevatorDoor();
        List<FloorDoor> floorDoors = new ArrayList<>(MAX_FLOOR);
        for (int i = 0; i < MAX_FLOOR; i++)
            floorDoors.add(new FloorDoor(i + 1));
        DoorTimer timer = new DoorTimer();
        ElevatorController controller = new ElevatorController(
            elevatorMotor, elevatorDoor, floorDoors, timer);

        controller.goTo(4);
        controller.approaching(2);
        controller.approaching(3);
        controller.approaching(4);
    }
}

