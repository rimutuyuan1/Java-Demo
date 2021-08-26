package com.forezp.thread.classlaoder;

import java.io.InputStream;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/8/26 下午10:39
 **/
public class ClassEqualTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)
                    throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1)
                            + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);   // 递归调用父类加载器
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myClassLoader.loadClass("com.forezp.thread.classlaoder.ClassEqualTest")
                .newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.forezp.thread.classlaoder.ClassEqualTest);
    }
}
