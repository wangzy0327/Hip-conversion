package com.ncic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextUtils {

    private static final Logger logger = LoggerFactory.getLogger(TextUtils.class);

    public static void main(String[] args) {
        String pastr = "\\\"([\\w|/|\\.]+)\\\"";
        Pattern pattern = Pattern.compile(pastr);
//        try {
//            File targetFile = new File("C://new1.txt");
//            FileWriter fw = new FileWriter(targetFile);
//            BufferedWriter bw = new BufferedWriter(fw);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String srcPath = "C:\\Users\\wzy\\Documents\\1.txt";
        String targetPath = "C:\\Users\\wzy\\Documents\\new1.txt";
        String prefix = "put(";
        String suffix = ");";
        String reduce = "";
        try (Stream<String> lines = Files.lines(Paths.get(srcPath))) {
            reduce = lines.map((x) -> {
                Matcher m = pattern.matcher(x);
                int count = 0;
                LinkedList<String> list = new LinkedList<>();
                while (m.find()) {
//                    logger.info(m.group(count));
                    list.addFirst(m.group(count));
                }
                String midRes = String.join(",", list.toArray(String[]::new));
                String res = prefix + midRes + suffix + "\n";
//                logger.info("------------------" + res + "-------------------");
                return res;
            }).reduce("", (x, y) -> x + y);
        } catch (IOException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
        logger.info(reduce);
        byte [] buf = reduce.getBytes();
        try {
            Files.write(Paths.get(targetPath),buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
