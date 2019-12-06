package xyz.andrasfindt.aoc2019;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StringUtil {


    public static Stream<String> getLines(String fileName) throws IOException {
        Path path = new File(ClassLoader.getSystemClassLoader().getResource(fileName).getFile()).toPath();
        return Files.lines(path);
    }

}
