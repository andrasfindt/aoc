package xyz.andrasfindt.aoc2019;

import java.io.IOException;
import java.util.logging.Logger;

import static xyz.andrasfindt.aoc2019.StringUtil.getLines;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        d1p1();
        d1p2();
    }

    private static void d1p1() throws IOException {
        Integer fuelRequired = getLines("2019/1/input.txt")
                .map(i -> calcFuelReq(Integer.parseInt(i)))
                .reduce(0, Integer::sum);
        String output = String.format("d1p1: %d", fuelRequired);
        LOGGER.info(output);
    }

    private static void d1p2() throws IOException {
        Integer fuelRequired = getLines("2019/1/input.txt")
                .map(i -> calcFuel(Integer.valueOf(i)))
                .reduce(0, Integer::sum);
        String output = String.format("d1p2: %d", fuelRequired);
        LOGGER.info(output);
    }

    private static int calcFuelReq(int i) {
        return i / 3 - 2;
    }

    private static int calcFuel(Integer fuelRequired) {
        int sum = 0;
        do {
            fuelRequired = calcFuelReq(fuelRequired);
            if (fuelRequired <= 0) {
                break;
            }
            sum += fuelRequired;
        } while (true);
        return sum;
    }
}
