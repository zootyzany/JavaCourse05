package io.github.kimmking.gateway.util;

/**
 * @author sp0038
 * @date 2021/8/22
 */
public class TimeElapsedUtil {
    private static ThreadLocal<Long> ST = new ThreadLocal<>();

    public static void setST(Long time) {
        ST.set(time);
    }

    public static Long getST() {
        return ST.get();
    }
}
