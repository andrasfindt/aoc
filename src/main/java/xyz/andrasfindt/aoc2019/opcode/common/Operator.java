package xyz.andrasfindt.aoc2019.opcode.common;

import java.util.List;

public abstract class Operator<T extends Number> {
    public abstract T operate(List<Operand<T>> operands);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public interface Halt {
    }

    public interface Addition {
    }

    public interface Multiplication {
    }

    public interface Input {
    }

    public interface Output {
    }


}
