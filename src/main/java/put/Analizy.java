package put;

import java.io.*;

public class Analizy {

    boolean check;
    StringBuilder data = new StringBuilder();

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
           in.lines().forEach(a -> {
               if ((a.startsWith("400") || a.startsWith("500")) && !check ) {
                   check = true;
                   data.append(a.substring(4)).append(";");
               }
               if ((a.startsWith("300") || a.startsWith("200")) && check ) {
                   check = false;
                   data.append(a.substring(4)).append(";").append(System.lineSeparator());
               }
           });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            out.write(String.valueOf(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}