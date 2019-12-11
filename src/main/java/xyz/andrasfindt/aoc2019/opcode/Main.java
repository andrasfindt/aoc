package xyz.andrasfindt.aoc2019.opcode;

import xyz.andrasfindt.aoc2019.opcode.common.Program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Main {
    public static final int DESIRED_RESULT = 19690720;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        List<String> amplifierPhases = getPossiblePhases("56789");
        List<Integer> thrusterStrength = new ArrayList<>();
        for (String phase : amplifierPhases) {
            thrusterStrength.add(part1(phase));
        }
        System.out.println(thrusterStrength.stream().max(Integer::compareTo).get());
    }

    private static List<String> getPossiblePhases(String in) {
        ArrayList<String> strings = new ArrayList<>();

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                            Set<Character> chars = new HashSet<>();
                            chars.add(in.charAt(a));
                            chars.add(in.charAt(b));
                            chars.add(in.charAt(c));
                            chars.add(in.charAt(d));
                            chars.add(in.charAt(e));
                            if (chars.size() > 4) {
                                String e1 = "" + in.charAt(a) + in.charAt(b) + in.charAt(c) + in.charAt(d) + in.charAt(e);
                                strings.add(e1);
                            }
                        }
                    }
                }
            }
        }
        return strings;
    }

    private static int part1(String phase) throws IOException {
        System.out.format("phase: %s\n", phase);
        Program programA = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        ArrayList<Integer> inputResponses = new ArrayList<>();
        inputResponses.add(Integer.parseInt("" + phase.charAt(0)));
        inputResponses.add(0);
        programA.execute(inputResponses);
        Program programB = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        inputResponses = new ArrayList<>();
        inputResponses.add(Integer.parseInt("" + phase.charAt(1)));
        inputResponses.add(Program.lastOutput);
        programB.execute(inputResponses);
        Program programC = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        inputResponses = new ArrayList<>();
        inputResponses.add(Integer.parseInt("" + phase.charAt(2)));
        inputResponses.add(Program.lastOutput);
        programC.execute(inputResponses);
        Program programD = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        inputResponses = new ArrayList<>();
        inputResponses.add(Integer.parseInt("" + phase.charAt(3)));
        inputResponses.add(Program.lastOutput);
        programD.execute(inputResponses);
        Program programE = new Program(null, null, "2019/7/input.txt", System.in, System.out);
        inputResponses = new ArrayList<>();
        inputResponses.add(Integer.parseInt("" + phase.charAt(4)));
        inputResponses.add(Program.lastOutput);
        programE.execute(inputResponses);
        System.out.format("result:%d\n", Program.lastOutput);
        return Program.lastOutput;
    }

}
