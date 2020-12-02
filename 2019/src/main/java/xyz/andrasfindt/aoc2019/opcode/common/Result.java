package xyz.andrasfindt.aoc2019.opcode.common;

public class Result<T extends Number> {
    private int index;
    private T value;
    private int programCounter;

    public Result(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    @Override
    public String toString() {
        return "Result{" +
                "index=" + index +
                ", value=" + value +
                ", programCounter=" + programCounter +
                '}';
    }
}
