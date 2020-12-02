package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.Operation;
import xyz.andrasfindt.aoc2019.opcode.common.Result;
import xyz.andrasfindt.aoc2019.opcode.common.operator.AdditionOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.EqualsOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.HaltOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.InputOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.JumpIfFalseOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.JumpIfTrueOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.LessThanOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.MultiplicationOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.OutputOperator;

import java.io.InputStream;
import java.io.PrintStream;

public class IntegerOperation extends Operation<Integer> {

    public IntegerOperation(InputStream inputStream, PrintStream outputStream, int programCounter, String... args) {
        super(inputStream, outputStream, programCounter, args);
    }

    @Override
    public Result<Integer> execute() {
        result.setValue(operator.operate(operands));
        result.setProgramCounter(operator.determineProgramCounter(programCounter, size));
        return result;
    }

    @Override
    protected HaltOperator<Integer> createHaltOperator() {
        return new IntegerHaltOperator();
    }

    @Override
    protected AdditionOperator<Integer> createAdditionOperator() {
        return new IntegerAdditionOperator();
    }

    @Override
    protected MultiplicationOperator<Integer> createMultiplicationOperator() {
        return new IntegerMultiplicationOperator();
    }

    @Override
    protected InputOperator<Integer> createInputOperator() {
        return new IntegerInputOperator(inputStream);
    }

    @Override
    protected OutputOperator<Integer> createOutputOperator() {
        return new IntegerOutputOperator(outputStream);
    }

    @Override
    protected JumpIfTrueOperator<Integer> createJumpIfTrueOperator() {
        return new IntegerJumpIfTrueOperator();
    }

    @Override
    protected JumpIfFalseOperator<Integer> createJumpIfFalseOperator() {
        return new IntegerJumpIfFalseOperator();
    }

    @Override
    protected LessThanOperator<Integer> createLessThanOperator() {
        return new IntegerLessThanOperator();
    }

    @Override
    protected EqualsOperator<Integer> createEqualsOperator() {
        return new IntegerEqualsOperator();
    }

    @Override
    protected Operand<Integer> createOperand(Integer value) {
        return new Operand<>(value);
    }

    @Override
    protected Operand<Integer> createOperandWithMode(Operand.Mode mode, int position, String[] args) {
        if (mode == Operand.Mode.BY_REFERENCE) {
            int index = Integer.parseInt(args[position]);
            return createOperand(Integer.valueOf(args[index]));
        } else {
            return createOperand(Integer.valueOf(args[position]));
        }
    }

    @Override
    protected Result<Integer> createResult(Operand.Mode mode, int position, String[] args) {
        if (mode == Operand.Mode.BY_REFERENCE) {
            int index = Integer.parseInt(args[position]);
            return new Result<>(index);
        } else {
            return new Result<>(Integer.parseInt(args[position]));
        }
    }

    @Override
    public String toString() {
        return "IntegerOperation{" +
                "result=" + result +
                ", operands=" + operands +
                ", operator=" + operator +
                ", size=" + size +
                '}';
    }
}
