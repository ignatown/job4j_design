package put;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException();
        }
        for (String arg:
             args) {
            if (arg.startsWith("-")) {
                String[] temp = arg.substring(1).split("=");
                if (temp.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(temp[0], temp[1]);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}