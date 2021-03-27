package put;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private final String path;
    private static String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, Charset.forName("UTF-8"))))) {
            String text = in.readLine();
            out.println(text);
            boolean inWork = true;
            while (!text.equals(OUT)) {
                out.println(text);
                switch (text) {
                    case (STOP):
                        inWork = false;
                        break;
                    case (CONTINUE):
                        inWork = true;
                        break;
                }
                if (inWork) {
                    System.out.println(answer());
                    out.println(answer());
                }
                text = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String answer() {
        List<String> responses = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            while (in.ready()) {
                responses.add(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responses.get((int) (Math.random() * responses.size()));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./log.txt", "./responses.txt");
        cc.run();
    }
}