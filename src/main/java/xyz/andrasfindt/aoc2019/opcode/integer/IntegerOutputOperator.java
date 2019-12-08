package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.OutputOperator;

import java.util.List;

public class IntegerOutputOperator extends OutputOperator<Integer> {
    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        Integer value = operands.get(0).getValue();
        System.out.println(value);
        return value;
    }
}
