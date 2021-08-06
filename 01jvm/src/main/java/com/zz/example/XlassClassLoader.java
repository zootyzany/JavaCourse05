package com.zz.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件.
 *
 * @author zhouzeng
 * @date 2021/8/3
 */
public class XlassClassLoader extends ClassLoader {
    Logger log = LoggerFactory.getLogger(XlassClassLoader.class);
    /**
     * 类名称(不包含后缀)
     */
    private static final String CLASS_NAME = "Hello";

    /**
     * 方法名称
     */
    private static final String METHOD_NAME = "hello";

    /**
     * 被解析的文件名(包含后缀)
     */
    private static final String FILE_NAME_WITH_SUFFIX = "Hello.xlass";

    public static void main(String[] args) throws Exception {
        Class<?> clazz = new XlassClassLoader().findClass(CLASS_NAME);
        clazz.getMethod(METHOD_NAME).invoke(clazz.newInstance());
    }

    /**
     * 获取对应的类
     *
     * @param className 类名字
     * @return class
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {

        // 可以使用Files.readAllBytes()
        URL url = XlassClassLoader.class.getClassLoader().getResource(FILE_NAME_WITH_SUFFIX);
        String fileFullPath = Objects.requireNonNull(url).getPath();

        try {
            FileInputStream fis = new FileInputStream(new File(fileFullPath));
            byte[] bytes = buildBytes(fis);
            return defineClass(className, bytes, 0, bytes.length);
        } catch (Exception e) {
            log.error("Find the class failed! cause:{}, className:{}", e, className);
            throw new ClassNotFoundException(className);
        }
    }

    /**
     * 文件内容中所有字节（x=255-x）处理后,往ByteArrayOutputStream中写.
     *
     * @param fis FileInputStream
     * @return 返回文件流对应的byte数组
     * @throws IOException e
     */
    public byte[] buildBytes(FileInputStream fis) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int temp;
        while ((temp = fis.read()) != -1) {
            bos.write(255 - temp);
        }
        fis.close();
        bos.close();
        return bos.toByteArray();
    }

}
