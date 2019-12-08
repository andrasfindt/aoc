package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.AdditionOperator;

import java.util.List;

public class IntegerAdditionOperator extends AdditionOperator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return operands.stream()
                .map(Operand::getValue)
                .reduce(0, Math::addExact);
    }
}
