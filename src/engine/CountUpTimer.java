package engine;

public class CountUpTimer {
    private long startTime;
    private long elapsedTime;
    private boolean running;

    public CountUpTimer() {
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
        running = true;
    }

    public void update() {
        if (running) {
            long currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - startTime;
        }
    }


    public long getElapsedTime() {
        return elapsedTime;
    }
}
