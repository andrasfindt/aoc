package xyz.andrasfindt.aoc2019.opcode.common;

import xyz.andrasfindt.aoc2019.opcode.common.operator.AdditionOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.HaltOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.InputOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.MultiplicationOperator;
import xyz.andrasfindt.aoc2019.opcode.common.operator.OutputOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Operation<T extends Number> {
    protected static final int HALT = 99;
    protected static final int ADD = 1;
    protected static final int MUL = 2;
    protected static final int IN = 3;
    protected static final int OUT = 4;
    protected Result<T> result;
    protected List<Operand<T>> operands = new ArrayList<>();
    protected Operator<T> operator;
    protected int size;

    public Operation(int programCounter, String... args) {
        String command = padLeft(args[programCounter]);
        int operation = determineOperation(command);
        Map<Integer, Operand.Mode> modes = determineModes(command);
        switch (operation) {
            case HALT:
                operator = createHaltOperator();
                result = new Result<>(-1);
                size = 2;
                break;
            case ADD:
                operator = createAdditionOperator();
                operands.add(createOperandWithMode(modes.get(0), programCounter + 1, args));
                operands.add(createOperandWithMode(modes.get(1), programCounter + 2, args));
                result = createResult(modes.get(2), programCounter + 3, args);
                size = 4;
                break;
            case MUL:
                operator = createMultiplicationOperator();
                operands.add(createOperandWithMode(modes.get(0), programCounter + 1, args));
                operands.add(createOperandWithMode(modes.get(1), programCounter + 2, args));
                result = createResult(modes.get(2), programCounter + 3, args);
                size = 4;
                break;
            case IN:
                operator = createInputOperator();
                result = createResult(modes.get(0), programCounter + 1, args);
                size = 2;
                break;
            case OUT:
                operator = createOutputOperator();
                operands.add(createOperandWithMode(modes.get(0), programCounter + 1, args));
                result = createResult(modes.get(0), programCounter + 1, args);
                size = 2;
                break;
            default:
                throw new UnsupportedOperationException("dunno what this is, yo");
        }
    }

    private int determineOperation(String command) {
        return Integer.parseInt(command.substring(3));
    }

    private Map<Integer, Operand.Mode> determineModes(String operation) {
        HashMap<Integer, Operand.Mode> parameterModes = new HashMap<>();
        parameterModes.put(0, operation.charAt(2) == '0' ? Operand.Mode.BY_REFERENCE : Operand.Mode.BY_VALUE);
        parameterModes.put(1, operation.charAt(1) == '0' ? Operand.Mode.BY_REFERENCE : Operand.Mode.BY_VALUE);
        parameterModes.put(2, operation.charAt(0) == '0' ? Operand.Mode.BY_REFERENCE : Operand.Mode.BY_VALUE);
        return parameterModes;
    }

    private String padLeft(String operation) {
        StringBuilder operationBuilder = new StringBuilder(operation);
        while (operationBuilder.length() < 5) {
            operationBuilder.insert(0, "0");
        }
        operation = operationBuilder.toString();
        return operation;
    }

    public abstract Result<T> execute();

    protected abstract HaltOperator<T> createHaltOperator();

    protected abstract AdditionOperator<T> createAdditionOperator();

    protected abstract MultiplicationOperator<T> createMultiplicationOperator();

    protected abstract InputOperator<T> createInputOperator();

    protected abstract OutputOperator<T> createOutputOperator();

    protected abstract Operand<T> createOperand(Integer value);

    protected abstract Operand<T> createOperandWithMode(Operand.Mode mode, int position, String[] args);

    protected abstract Result<T> createResult(Operand.Mode mode, int position, String[] args);

    public int getSize() {
        return size;
    }


}
