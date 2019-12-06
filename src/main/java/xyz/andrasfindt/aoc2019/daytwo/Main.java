package xyz.andrasfindt.aoc2019.daytwo;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static final int DESIRED_RESULT = 19690720;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        part1();
        part2();
    }

    private static void part1() throws IOException {
        int i = new Program("12", "02").execute();
        if (i == 5866714) {
            LOGGER.info("SUCCESS");
        }
    }

    private static void part2() throws IOException {
        boolean found = false;
        for (int noun = 0; noun < 100 && !found; noun++) {
            for (int verb = 0; verb < 100 && !found; verb++) {
                int result = new Program(String.valueOf(noun), String.valueOf(verb)).execute();
                if (result == DESIRED_RESULT) {
                    LOGGER.info("SUCCESS");
                    int intCode = noun * 100 + verb;
                    String msg = String.valueOf(intCode);
                    LOGGER.info(msg);
                    found = true;
                }
            }
        }
    }

}
