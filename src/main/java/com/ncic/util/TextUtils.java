package com.ncic.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextUtils {
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
//                    System.out.println(m.group(count));
                    list.addFirst(m.group(count));
                }
                String midRes = String.join(",", list.toArray(new String[0]));
                String res = prefix + midRes + suffix + "\n";
//                System.out.println("------------------" + res + "-------------------");
                return res;
            }).reduce("", (x, y) -> x + y);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reduce);
        byte [] buf = reduce.getBytes();
        try {
            Files.write(Paths.get(targetPath),buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
