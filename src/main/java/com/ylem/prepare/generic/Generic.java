package com.ylem.prepare.generic;


/**
 * 泛型类
 * 泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型 。
 * @param <T>
 */
public class Generic<T> {
    // key这个成员变量的类型为T，T的类型由外部指定
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        /**
         * test1: 基本使用
         */
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic<String> genericString = new Generic<String>("abc");
        System.out.println(genericString.getKey());
        System.out.println(genericInteger.getKey());

        /**
         * test2
         */
        Generic generic = new Generic(123);
        Generic generic1 = new Generic("abc");
        Generic generic2 = new Generic(false);
        System.out.println(generic.getKey());
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());

        /**
         * test3
         */
        Generic tmp = new Generic(1);
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        tmp.showKeyValue(gInteger);   // 这里可以？？？？
        tmp.showKeyValue(gNumber);

        /**
         * test4
         */
        Foo foo = new Foo();
        Generic<Integer> gInteger1 = new Generic<Integer>(123);
        Generic<Number> gNumber1 = new Generic<Number>(456);
        // foo.showKeyValue(gInteger1);  // 这里不可以？？？？？编译错误
        foo.showKeyValue(gNumber1);

        /**
         * test5
         */
        Bar bar = new Bar();
        Generic<Integer> gInteger2 = new Generic<Integer>(123);
        Generic<Number> gNumber2 = new Generic<Number>(456);
        Generic<String> gString2 = new Generic<String>("abc");
        bar.showKeyValue(gInteger);
        bar.showKeyValue(gNumber);
        // bar.showKeyValue(gString2);   // 这里不行
    }

    public void showKeyValue(Generic<Number> obj) {
        System.out.println("obj key: " + obj.getKey());
    }
}

class Foo {
    public void showKeyValue(Generic<Number> obj) {
        System.out.println("obj key: " + obj.getKey());
    }
}

class Bar {
    public void showKeyValue(Generic<? extends Number> obj) {
        System.out.println("obj key: " + obj.getKey());
    }
}
