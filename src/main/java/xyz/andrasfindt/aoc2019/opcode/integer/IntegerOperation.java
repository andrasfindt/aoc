package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.Operation;
import xyz.andrasfindt.aoc2019.opcode.common.Result;
import xyz.andrasfindt.aoc2019.opcode.common.operator.AdditionOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.HaltOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.InputOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.MultiplicationOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.OutputOperator;

public class IntegerOperation extends Operation<Integer> {

    public IntegerOperation(int programCounter, String... args) {
        super(programCounter, args);
    }

    @Override
    public Result<Integer> execute() {
        result.setValue(operator.operate(operands));
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
        return new IntegerInputOperator();
    }

    @Override
    protected OutputOperator<Integer> createOutputOperator() {
        return new IntegerOutputOperator();
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
