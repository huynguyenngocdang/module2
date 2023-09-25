public class StopWatch {
    long startTime;
    long endTime;
    boolean running;

    public StopWatch(long startTime, long endTime, boolean running) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.running = running;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
        this.running = false;
    }

    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = endTime - startTime;
        }
        return elapsed;
    }
}
