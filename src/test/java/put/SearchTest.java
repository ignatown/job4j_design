package put;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void search() throws IOException {
        Path start = Paths.get("C:\\projects\\job4j_design");
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith("log"));
        Files.walkFileTree(start, searcher);
        assertThat(searcher.getPaths().toString(), is("[C:\\projects\\job4j_design\\server.log]"));
    }
}