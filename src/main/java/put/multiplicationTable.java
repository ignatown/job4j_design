package put;

import java.io.FileOutputStream;

public class multiplicationTable {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                a.append(i + "*" + j + "=" + i * j+System.lineSeparator());
            }

        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(a.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
