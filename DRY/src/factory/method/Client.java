package factory.method;

public class Client {
    public static void main(String[] args) {
        Motor lgMotor = new LGMotor(new Door());
        ElevatorController controller1 = new ElevatorController(1, lgMotor);
        controller1.gotoFloor(5);
        controller1.gotoFloor(3);

        Motor hyundaiMotor = new HyundaiMotor(new Door());
        ElevatorController controller2 = new ElevatorController(2, hyundaiMotor);
        controller2.gotoFloor(4);
        controller2.gotoFloor(6);
    }
}

