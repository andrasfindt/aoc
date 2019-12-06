package xyz.andrasfindt.aoc2019.daytwo;

import java.util.List;

public class IntegerAdditionOperator extends Operator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return operands.stream()
                .map(Operand::getValue)
                .reduce(0, Math::addExact);
    }
}
