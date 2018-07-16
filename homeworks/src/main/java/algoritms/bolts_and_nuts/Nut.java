package algoritms.bolts_and_nuts;

public class Nut implements Comparable<Bolt> {
    int value;

    public Nut(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Bolt o) {
        return this.value - o.getValue();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
