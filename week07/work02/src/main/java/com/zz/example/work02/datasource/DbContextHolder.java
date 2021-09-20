package com.zz.example.work02.datasource;


/**
 * @author zhouzeng
 */
public class DbContextHolder {

    private static final ThreadLocal<DBTypeEnum> HOLDER = new ThreadLocal<>();

    public static DBTypeEnum get() {
        return HOLDER.get();
    }

    public static void master() {
        HOLDER.set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        HOLDER.set(DBTypeEnum.SLAVE);
        System.out.println("切换到slave");
    }

    public static void remove() {
        HOLDER.remove();
    }

}