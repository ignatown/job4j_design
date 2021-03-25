package put;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> data = new HashSet<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty crntFile = new FileProperty(file.toFile().getTotalSpace(), file.toFile().getName());
        if (!data.add(crntFile)) {
            System.out.println(crntFile);
        }
        return super.visitFile(file, attrs);
    }
    }
