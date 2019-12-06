package xyz.andrasfindt.aoc2019.daytwo;

public class Operand<T extends Number> {
    private T value;

    public Operand(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Operand{" +
                ", value=" + value +
                '}';
    }
}
