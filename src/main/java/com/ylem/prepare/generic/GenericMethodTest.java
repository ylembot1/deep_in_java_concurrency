package com.ylem.prepare.generic;

public class GenericMethodTest {
    // 泛型类
    public class Generic<T> {
        // key这个成员变量的类型为T，T的类型由外部指定
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         */
//        public E setKey(E key) {
//            this.key = key;
//        }
    }

    /**
     * 泛型方法
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key: " + container.getKey());
        T key = container.getKey();
        return key;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    // 这个可以把Generic<Number>看做是一个类型
    public void showKeyValue1(Generic<Number> obj){
        System.out.println("key value is " + obj.getKey());
    }

    // 这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    // 同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj){
        System.out.println("key value is " + obj.getKey());
    }

    // 但是只声明了泛型类型T，并未声明泛型类型E
    // public <T, E> T showKeyName1(Generic<E> container)  // 这样是对的啊
//    public <T> T showKeyName1(Generic<E> container) {
//        return null;
//    }
}
