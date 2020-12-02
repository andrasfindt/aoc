package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.MultiplicationOperator;

import java.util.List;

public class IntegerMultiplicationOperator extends MultiplicationOperator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return operands.stream()
                .map(Operand::getValue)
                .reduce(1, Math::multiplyExact);
    }
}
