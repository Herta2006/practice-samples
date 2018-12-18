package practice.samples;

public class SyncCounter implements Counter {
    private volatile long counter;

    @Override
    public synchronized void increment() {
        ++counter;
    }

    @Override
    public long get() {
        return counter;
    }
}
