package put;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            for (String s:
            text.toString().split("\r\n")) {
                if (Integer.valueOf(s) % 2 == 0) {
                    System.out.println(s + " is even");
                } else {
                    System.out.println(s + " not is even");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
