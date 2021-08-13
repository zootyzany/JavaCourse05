package com.zz.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件.
 *
 * @author zhouzeng
 * @date 2021/8/3
 */
public class XlassClassLoader2 extends ClassLoader {
    Logger log = LoggerFactory.getLogger(XlassClassLoader2.class);

    public static void main(String[] args) throws Exception {
        // 通过Spring可以将XlassFile动态注入.
        Class<?> clazz = new XlassClassLoader2().findClass("Hello");
        clazz.getMethod("hello").invoke(clazz.newInstance());
        // System.out.println(new XlassClassLoader2().findClasses());
    }


    /**
     * 获取对应的类
     *
     * @param className 类名字
     * @return class
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            URL url = XlassClassLoader.class.getResource("/");
            File file = new File(url.getPath());
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                if (listFile.getName().contains(className) && listFile.getName().endsWith(".xlass")) {
                    FileInputStream fis = new FileInputStream(new File(listFile.getPath()));
                    byte[] bytes = buildBytes(fis);
                    return defineClass(className, bytes, 0, bytes.length);
                }
            }
            return null;
        } catch (Exception e) {
            log.error("Find the class failed! cause:{}, className:{}", e, className);
            throw new ClassNotFoundException(className);
        }
    }

    public List<Class<?>> findClasses() throws ClassNotFoundException {
        try {
            List<Class<?>> classes = new ArrayList<>();
            URL url = XlassClassLoader.class.getResource("/");
            File file = new File(url.getPath());
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                if (listFile.getName().endsWith(".xlass")) {
                    String className = listFile.getName().split(".xlass")[0];
                    FileInputStream fis = new FileInputStream(new File(listFile.getPath()));
                    byte[] bytes = buildBytes(fis);
                    classes.add(defineClass(className, bytes, 0, bytes.length));
                }
            }
            return classes;
        } catch (Exception e) {
            log.error("Find the class failed! cause:{}", e);
            throw new ClassNotFoundException("class not found!");
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
