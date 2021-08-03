package ood.solid.srp;

import java.io.File;
import java.util.List;

// 2 Пример
// Следовало бы создать 2 отдельных интерфейса для чтения и записи файлов.
public interface FileMaster {
    public List<String> readFile(File file);
    public void writeFile(File file, List<String> info);
}
