package Models;

import java.io.IOException;

public class Counter implements AutoCloseable {
    private int value;
    private boolean isOpen;

    public Counter(int value) {
        this.value = value;
        this.isOpen = true;
    }

    public int getValue() {
        return value;
    }

    public void add() throws IOException {
        if (isOpen) {
            value++;
        } else {
            throw new IOException("The Counter is closed!");
        }
    }

    @Override
    public void close() {
        isOpen = false;
    }

    @Override
    public String toString() {
        return String.format("Today added %d animals to registry", value);
    }
}
