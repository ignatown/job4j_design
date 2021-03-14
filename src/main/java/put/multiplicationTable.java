package put;

import java.io.FileOutputStream;

public class multiplicationTable {
    public static void main(String[] args) {
        String a = "";
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                a+=i+"*"+j+"="+i*j+" ";
            }
            a+="\n";
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(a.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
