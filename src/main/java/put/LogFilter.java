package put;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        StringBuilder data = new StringBuilder();
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(a -> data.append(a + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        data.toString().split("\n");

        for (String str:
                data.toString().split("\n")) {
            for (String pr:
                    str.split(" ")) {
                if (pr.equals("404")) {
                    list.add(str);
                }
            }
        }
        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String l:
                 log) {
                out.write(l + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}