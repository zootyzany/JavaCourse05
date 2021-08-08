package com.zz.example;

import java.net.URL;
import java.util.Objects;

/**
 * @author sp0038
 * @date 2021/8/8
 */
public interface XlassFile {

    /**
     * 获取文件所在路径
     *
     * @return 文件路径
     */
    default String getFilePath() {
        URL url = XlassClassLoader.class.getClassLoader().getResource("Hello.xlass");
        return Objects.requireNonNull(url).getPath();
    }

    /**
     * 获取文件名字
     *
     * @return 文件名字
     */
    default String getClassName() {
        return "Hello";
    }

    /**
     * 获取方法名字
     *
     * @return 方法名字
     */
    default String getMethodName() {
        return "hello";
    }
}
