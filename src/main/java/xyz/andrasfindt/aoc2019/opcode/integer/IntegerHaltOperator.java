package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.HaltOperator;

import java.util.List;

import static xyz.andrasfindt.aoc2019.opcode.common.Program.HALT_CODE;

public class IntegerHaltOperator extends HaltOperator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        return HALT_CODE;
    }
}
