package manage.util;

import java.util.Date;
import java.util.Random;

public class RandomUtil {
    private static Random rand = new Random();

    public synchronized static String generate() {
        long ran = rand.nextInt(10);
        String now = String.valueOf((new Date()).getTime() / 1000 + ran);
        return now;
    }
}