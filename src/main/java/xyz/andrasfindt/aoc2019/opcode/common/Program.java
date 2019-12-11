package xyz.andrasfindt.aoc2019.opcode.common;

import xyz.andrasfindt.aoc2019.opcode.integer.IntegerOperation;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static xyz.andrasfindt.aoc2019.opcode.common.StringUtil.getLines;

public class Program {
    public static final Integer HALT_CODE = Integer.MIN_VALUE;
    public static final Integer CONTROL_CODE = Integer.MIN_VALUE + 1;
    private static final Logger LOGGER = Logger.getLogger(Program.class.getName());

    private final String[] memory;

    public Program(String noun, String verb, String fileName) throws IOException {
        Optional<String> programContainer = getLines(fileName).findFirst();
        if (programContainer.isPresent()) {
            memory = programContainer.get().split(",");
            if (noun != null) {
                memory[1] = noun;
            }
            if (verb != null) {
                memory[2] = verb;
            }
        } else {
            throw new UnsupportedOperationException("program couldn't be loaded");
        }
    }

    public int execute() {
        int programCounter = 0;
        while (programCounter < memory.length) {
            Operation<Integer> operation = new IntegerOperation(programCounter, memory);
            Result<Integer> result = operation.execute();
            int index = result.getIndex();
            Integer value = result.getValue();
            LOGGER.fine(operation.toString());
            if (value.equals(HALT_CODE)) {
                break;
            }
            if (!value.equals(CONTROL_CODE)) {
                memory[index] = String.valueOf(value);
            }
            programCounter = result.getProgramCounter();
        }
        int output = Integer.parseInt(memory[0]);
        String msg = String.format("result: %s", output);
        LOGGER.info(msg);
        return output;
    }
}
