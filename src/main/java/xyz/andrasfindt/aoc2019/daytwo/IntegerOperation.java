package xyz.andrasfindt.aoc2019.daytwo;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperation {
    public static final String HALT = "99";
    public static final String ADD = "1";
    public static final String MUL = "2";
    private Result<Integer> result;
    private List<Operand<Integer>> operands = new ArrayList<>();
    private Operator<Integer> operator;
    private int size;

    public IntegerOperation(int programCounter, String... args) {
        int operand0Index;
        int operand1Index;
        switch (args[programCounter]) {
            case HALT:
                operator = new HaltOperator();
                result = new Result<>(-1);
                size = 1;
                break;
            case ADD:
                operator = new IntegerAdditionOperator();
                operand0Index = Integer.parseInt(args[programCounter + 1]);
                operand1Index = Integer.parseInt(args[programCounter + 2]);
                operands.add(new Operand<>(Integer.valueOf(args[operand0Index])));
                operands.add(new Operand<>(Integer.valueOf(args[operand1Index])));
                result = new Result<>(Integer.parseInt(args[programCounter + 3]));
                size = 4;
                break;
            case MUL:
                operator = new IntegerMultiplicationOperator();
                operand0Index = Integer.parseInt(args[programCounter + 1]);
                operand1Index = Integer.parseInt(args[programCounter + 2]);
                operands.add(new Operand<>(Integer.valueOf(args[operand0Index])));
                operands.add(new Operand<>(Integer.valueOf(args[operand1Index])));
                result = new Result<>(Integer.parseInt(args[programCounter + 3]));
                size = 4;
                break;
            default:
                throw new UnsupportedOperationException("dunno what this is, yo");
        }
    }

    public int getSize() {
        return size;
    }

    public Result<Integer> execute() {
        result.setValue(operator.operate(operands));
        return result;
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
