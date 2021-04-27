package searchfile;

import put.ArgsName;

public class Arguments {
    private final ArgsName argsName;

    public Arguments(String[] args) {
        argsName = ArgsName.of(args);
    }

    public boolean check() {
        if (getFindType().contains("name") || getFindType().contains("mask") || getFindType().contains("regex")) {
            return true;
        }
        throw new IllegalArgumentException("Неверный параметр -t");
    }

    public String getOutput() {
        return argsName.get("o");
    }

    public String getDirectory() {
        return argsName.get("d");
    }

    public String getFileName() {
        return argsName.get("n");
    }

    public String getFindType() {
        return argsName.get("t");
    }

}