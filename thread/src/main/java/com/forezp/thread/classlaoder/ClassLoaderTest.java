package com.forezp.thread.classlaoder;

import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/8/26 上午4:27
 **/
public class ClassLoaderTest extends URLClassLoader {

    public ClassLoaderTest(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public ClassLoaderTest(URL[] urls) {
        super(urls);
    }

    public ClassLoaderTest(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //使用defineClass生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return new byte[]{};
    }

}
