package xyz.andrasfindt.aoc2019.opcode.common.connector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Connection {

    private PrintStream aliceOut;
    private InputStream bobIn;

    public Connection(String path) throws FileNotFoundException {
        this.aliceOut = new PrintStream(new FileOutputStream(path));
        this.bobIn = new FileInputStream(path);
    }

    public PrintStream getAOutput() {
        return aliceOut;
    }

    public InputStream getBInput() {
        return bobIn;
    }
}
