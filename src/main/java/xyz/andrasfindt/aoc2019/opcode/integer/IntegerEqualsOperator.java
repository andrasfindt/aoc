package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.EqualsOperator;

import java.util.List;

public class IntegerEqualsOperator extends EqualsOperator<Integer> {
    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return operands.get(0).getValue().compareTo(operands.get(1).getValue()) == 0 ? 1 : 0;
    }
}
