package practice.samples;

public class NonSyncCounter implements Counter {
    private long counter;

    @Override
    public void increment() {
        ++counter;
    }

    @Override
    public long get() {
        return counter;
    }
}
