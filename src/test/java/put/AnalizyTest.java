package put;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoPeriod() throws IOException {
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", target.getAbsolutePath());
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.toString(), is("[[server up: 10:58:01 ,  server down: 10:59:01 , server up: 11:01:02 ,  server down: 11:02:02 ]]"));
    }
}
