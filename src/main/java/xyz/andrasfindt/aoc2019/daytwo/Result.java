package xyz.andrasfindt.aoc2019.daytwo;

public class Result<T extends Number> {
    private int index;
    private T value;

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

    @Override
    public String toString() {
        return "Result{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}
