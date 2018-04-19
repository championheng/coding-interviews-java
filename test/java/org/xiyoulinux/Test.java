package org.xiyoulinux;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: spider_hgyi
 * @Date: Create in 15:20 2018/4/6
 * @Modified By:
 * @Description:
 */
class Outer {
    class Inner { }
    static class staticInner {}
}

public class Test {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        Outer.staticInner staticInner = new Outer.staticInner();

        Map map = new HashMap();
    }
}
