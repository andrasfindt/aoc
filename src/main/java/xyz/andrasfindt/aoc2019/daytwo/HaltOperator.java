package xyz.andrasfindt.aoc2019.daytwo;

import java.util.List;

public class HaltOperator extends Operator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return Integer.MIN_VALUE;
    }
}
