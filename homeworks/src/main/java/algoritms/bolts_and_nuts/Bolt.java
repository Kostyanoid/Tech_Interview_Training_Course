package algoritms.bolts_and_nuts;

public class Bolt implements Comparable<Nut> {
    int value;

    public Bolt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Nut o) {
        return this.value - o.getValue();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
