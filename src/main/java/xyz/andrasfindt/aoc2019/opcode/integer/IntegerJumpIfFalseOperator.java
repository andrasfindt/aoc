package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.JumpIfFalseOperator;

import java.util.List;

import static xyz.andrasfindt.aoc2019.opcode.common.Program.CONTROL_CODE;

public class IntegerJumpIfFalseOperator extends JumpIfFalseOperator<Integer> {
    private boolean jump;
    private int jumpIndex = -1;

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        jump = operands.get(0).getValue().equals(0);
        if (jump) {
            jumpIndex = operands.get(1).getValue();
        }
        return CONTROL_CODE;
    }

    @Override
    public int determineProgramCounter(int programCounter, int size) {
        if (jump) {
            return jumpIndex;
        }
        return super.determineProgramCounter(programCounter, size);
    }
}
