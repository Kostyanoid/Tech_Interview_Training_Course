package storage;


import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Storage {

    private volatile String value = "DEFAULT";
    private final Object monitor = new Object();
    private volatile boolean writing = false;
    private volatile boolean reading = false;

    @SneakyThrows
    public String read() {
        if (isWriting()) {
            System.out.println(Thread.currentThread().getName() + "is waiting for the writer to read.");
            wait();
            System.out.println(Thread.currentThread().getName() + "is starting to read.");
            setReading(true);
        }
        try {
            System.out.println(Thread.currentThread().getName() + " has started reading.");
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " is reading '" + value + "'");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(Thread.currentThread().getName() + " has finished reading.");
            setReading(false);
            return value;
    }

    @SneakyThrows
    public void write(String newValue) {
        if (isReading()) {
            System.out.println(Thread.currentThread().getName() + "is waiting for readers to write.");
            wait();
            System.out.println(Thread.currentThread().getName() + "is starting to write.");
            setWriting(true);
        }
        synchronized (monitor) {
            System.out.println(Thread.currentThread().getName() + " has started writing.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.value = newValue;
            System.out.println(Thread.currentThread().getName() + " has wrote '" + newValue + "'.");
            System.out.println(Thread.currentThread().getName() + " has finished writing.");
            setWriting(false);
            notifyAll();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isWriting() {
        return writing;
    }

    public void setWriting(boolean writing) {
        this.writing = writing;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }
}