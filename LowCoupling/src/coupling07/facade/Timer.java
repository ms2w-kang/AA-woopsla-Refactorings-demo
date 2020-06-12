package coupling07.facade;

public class Timer {
    public void schedule(DoorTimerTask task, int i) {
        try {
            Thread.sleep(i);
            task.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
    }
}
