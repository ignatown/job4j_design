package tdd.generrator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public void whenProduce() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("key", "value");
        String template = "KEY: ${key}";
        String exepted = "KEY: key";
        String rsl = generator.produce(template, args);
        assertThat(rsl, is(rsl));
    }

    @Test(expected = Exception.class)
    public void whenAnotherKey() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("key", "value");
        String template = "KEY: ${anotherKey}";
        String exepted = "KEY: key";
        generator.produce(template, args);
    }

    @Test(expected = Exception.class)
    public void whenMoreKey() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("key", "value");
        args.put("anotherKey", "anotherValue");
        String template = "KEY: ${anotherKey}";
        String exepted = "KEY: key";
        generator.produce(template, args);
    }

}