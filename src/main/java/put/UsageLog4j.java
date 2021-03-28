package put;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte a = 1;
        short b = 20;
        int c = 30000;
        long d = 400000000;
        float e = (float) 5.12345;
        double f = 6.123456;
        boolean g = true;
        char h = 56;
        LOG.debug("Variables. byte: {}; short: {}; int: {}; long: {}; float: {}; " +
                "double: {}; boolean: {}; char: {};", a, b, c, d, e, f, g, h);
    }
}