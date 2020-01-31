package com.forezp.thread.sameClass;

public class Dog {

    private String name;

    public String say() {
        return "hello dog" + name;
    }

    public static class Cat {

        private String catName;

        public String say() {
            return "hello cat" + catName;
        }


    }
}
