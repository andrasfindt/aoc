package xyz.andrasfindt.aoc2019.daytwo;

import java.util.List;

public abstract class Operator<T extends Number> {
    public abstract T operate(List<Operand<T>> operands);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
