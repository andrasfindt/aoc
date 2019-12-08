package xyz.andrasfindt.aoc2019.opcode.integer;

import xyz.andrasfindt.aoc2019.opcode.common.Operand;
import xyz.andrasfindt.aoc2019.opcode.common.operator.InputOperator;

import java.util.List;
import java.util.Scanner;

public class IntegerInputOperator extends InputOperator<Integer> {

    @Override
    public Integer operate(List<Operand<Integer>> operands) {
        System.out.println("enter a number:");
        return new Scanner(System.in).nextInt();
    }
}
