package xyz.andrasfindt.aoc2019.opcode.common;

import java.util.List;

public abstract class Operator<T extends Number> {
    public abstract T operate(List<Operand<T>> operands);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public int determineProgramCounter(int programCounter, int size) {
        return programCounter + size;
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

    public interface JumpIfTrue {
    }

    public interface JumpIfFalse {
    }

    public interface LessThan {
    }

    public interface Equals {
    }

}
