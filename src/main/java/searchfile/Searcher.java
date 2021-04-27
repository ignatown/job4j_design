package searchfile;

import put.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Searcher {
    private SearchFiles setPredicate(String type, String str) {
        SearchFiles searchFiles = null;
        switch (type) {
            case("name"):
                searchFiles = new SearchFiles(p -> p.toFile().getName().equals(str));
                break;
            case("mask"):
                String maskName = str.substring(0, str.indexOf(".")).replaceAll("\\*", "");
                String maskExt = str.substring(str.indexOf(".") + 1).replaceAll("\\*", "");
                searchFiles = new SearchFiles(p -> p.toFile().getName().contains(maskName) && p.toFile().getName().contains(maskExt));
                break;
            case("regex"):
                Pattern pattern = Pattern.compile(str);
                searchFiles = new SearchFiles(p -> pattern.matcher(p.toFile().getName()).matches());
                break;
        }
        return searchFiles;
    }
    private List<File> getFileList(Arguments arguments) {
        Path root = Paths.get(arguments.getDirectory());
        SearchFiles searchFiles = setPredicate(arguments.getFindType(), arguments.getFileName());
        try {
            Files.walkFileTree(root, searchFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Path> pList = searchFiles.getPaths();
        List<File> fList = new ArrayList<>();
        for (Path path: pList) {
            fList.add(path.toFile());
        }
        return fList;
    }
    private void writeOutput(List<File> fileList, File file) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(file)))) {
            for (File fileFrom: fileList) {
                printWriter.println(fileFrom);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)  {
        if (args.length == 4) {
        Arguments arguments = new Arguments(args);
        if (arguments.check()) {
            Searcher searchFile = new Searcher();
            List<File> fileList = searchFile.getFileList(arguments);
            searchFile.writeOutput(fileList, new File(arguments.getOutput()));
        }
    } else {
            throw new IllegalArgumentException("Parameters are set incorrectly");
        }
    }
}
