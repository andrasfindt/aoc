package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.InputOperator;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class IntegerInputOperator extends InputOperator<Integer> {

    private InputStream inputStream;

    public IntegerInputOperator(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }
}
