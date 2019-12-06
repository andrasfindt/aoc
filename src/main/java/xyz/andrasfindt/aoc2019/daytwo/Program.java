package xyz.andrasfindt.aoc2019.daytwo;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static xyz.andrasfindt.aoc2019.StringUtil.getLines;

@SuppressWarnings({"squid:S3655", "squid:S2629"})
public class Program {
    private static final Integer HALT_CODE = Integer.MIN_VALUE;
    private static final Logger LOGGER = Logger.getLogger(Program.class.getName());

    private final String[] memory;

    public Program(String noun, String verb) throws IOException {
        Optional<String> programContainer = getLines("2019/2/input.txt").findFirst();
        if (programContainer.isPresent()) {
            memory = programContainer.get().split(",");
            memory[1] = noun;
            memory[2] = verb;
        } else {
            throw new UnsupportedOperationException("program couldn't be loaded");
        }
    }

    public int execute() {
        int pc = 0;
        while (pc < memory.length) {
            IntegerOperation operation = new IntegerOperation(pc, memory);
            Result<Integer> result = operation.execute();
            Integer value = result.getValue();
            LOGGER.info(operation.toString());
            if (value.equals(HALT_CODE)) {
                break;
            }
            memory[result.getIndex()] = String.valueOf(value);
            pc += operation.getSize();
        }
        int output = Integer.parseInt(memory[0]);
        String msg = String.format("result: %s", output);
        LOGGER.info(msg);
        return output;
    }
}
