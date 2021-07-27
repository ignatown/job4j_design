package gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder stringBuilder = new StringBuilder();
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cachingDir + "/" + key))) {
            bufferedReader.lines().forEach(s -> stringBuilder.append(s).append(System.lineSeparator()));
        } catch (IOException ioException) {
           ioException.printStackTrace();
       }
       return stringBuilder.toString();
    }

}