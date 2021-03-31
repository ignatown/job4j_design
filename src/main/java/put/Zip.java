package put;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream data = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (Path source : sources) {
                data.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toString()))) {
                    data.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream data = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            data.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                data.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName argNames = ArgsName.of(args);
        List<Path> paths = Search.search(Path.of(argNames.get("d")),
                p -> p.toFile().getName().endsWith(argNames.get("e")));
        Path out = Path.of(argNames.get("o"));
        new Zip().packFiles(paths, out);
    }
}
