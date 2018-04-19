package org.xiyoulinux.单例模式;

/**
 * @Author: spider_hgyi
 * @Date: Create in 12:09 2018/3/28
 * @Modified By:
 * @Description: 实现单例模式的各种方法
 */

/**
 * 1. 适用单线程
 */
//public class Singleton {
//    private Singleton() { }
//
//    private static Singleton singleton = null;
//
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//
//        return singleton;
//    }
//}

/**
 * 2. 适用多线程但效率不高
 */
//public class Singleton {
//    private Singleton() { }
//
//    private static Singleton singleton = null;
//
//    public static Singleton getSingleton() {
//        synchronized (Singleton.class) {
//            if (singleton == null) {
//                singleton = new Singleton();
//            }
//        }
//
//        return singleton;
//    }
//}

/**
 * 3. 适用多线程（DCL双检测机制）
 */
//public class Singleton {
//    private Singleton() { }
//
//    private static Singleton singleton = null;
//
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//
//        return singleton;
//    }
//}

/**
 * 4. 饿汉式（天生线程安全，降低内存使用效率）
 */
//public class Singleton {
//    private Singleton() { }
//
//    private static Singleton singleton = new Singleton();
//
//    public static Singleton getSingleton() {
//        return singleton;
//    }
//}

/**
 * 5. 静态内部类（线程安全，按需创建）
 *
 * 关于静态内部类与内部类的说明：https://www.zhihu.com/question/28197253
 */
public class Singleton {
    private Singleton() { }

    // 这里是静态方法（只能访问静态变量）
    public static Singleton getSingleton() {
        return Nested.singleton;
    }

    // 只能是静态内部类（内有静态变量）
    private static class Nested {
        private static Singleton singleton = new Singleton();
    }
}