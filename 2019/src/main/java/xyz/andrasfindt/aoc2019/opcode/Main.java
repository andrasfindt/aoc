package xyz.andrasfindt.aoc2019.opcode;

import xyz.andrasfindt.aoc2019.opcode.common.Program;
import xyz.andrasfindt.aoc2019.opcode.common.connector.Connection;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static final int DESIRED_RESULT = 19690720;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        part1();
    }

    private static void part1() throws IOException {
        Connection connAB = new Connection("connAB.txt");
        Program programA = new Program(null, null, "2019/7/input.txt", System.in, System.out);
//        Program programB = new Program(null, null, "2019/7/input.txt", System.in, System.out);
//        Program programC = new Program(null, null, "2019/7/input.txt", System.in, System.out);
//        Program programD = new Program(null, null, "2019/7/input.txt", System.in, System.out);
//        Program programE = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        new Thread(programA::execute).start();
//        new Thread(programB::execute).start();
//        new Thread(programC::execute).start();
//        new Thread(programD::execute).start();
//        new Thread(programE::execute).start();


    }

    private static void part2() throws IOException {
        boolean found = false;
        for (int noun = 0; noun < 100 && !found; noun++) {
            for (int verb = 0; verb < 100 && !found; verb++) {
                int result = new Program(String.valueOf(noun), String.valueOf(verb), "2019/2/input.txt", System.in, System.out).execute();
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
