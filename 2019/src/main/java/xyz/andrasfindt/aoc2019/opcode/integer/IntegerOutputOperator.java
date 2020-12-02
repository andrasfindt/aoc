package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.OutputOperator;

import java.io.PrintStream;
import java.util.List;

import static xyz.andrasfindt.aoc2019.opcode.common.Program.CONTROL_CODE;

public class IntegerOutputOperator extends OutputOperator<Integer> {

    private PrintStream outputStream;

    public IntegerOutputOperator(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        Integer value = operands.get(0).getValue();
        outputStream.println(value);
        return CONTROL_CODE;
    }
}
