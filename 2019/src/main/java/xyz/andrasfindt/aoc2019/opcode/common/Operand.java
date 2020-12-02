package xyz.andrasfindt.aoc2019.opcode.common;

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
                "value=" + value +
                '}';
    }

    public enum Mode {
        BY_REFERENCE, BY_VALUE
    }
}
