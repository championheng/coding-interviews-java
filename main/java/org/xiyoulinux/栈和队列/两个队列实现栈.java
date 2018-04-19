package org.xiyoulinux.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: spider_hgyi
 * @Date: Create in 12:02 2018/4/1
 * @Modified By:
 * @Description:
 * 实现思想：
 * 1. 入栈：两个队列都为空的话，随便入一个队，我在这里入 Queue1，否则哪个队不空入哪个队
 * 2. 出栈：哪个队列不为空，并且这个队列有 n 个元素，将这个队列中的 n-1 元素入队到另一个
 *  空队列中，并将最后一个元素进行弹出
 */
class MyStack {
    Queue<String> queue1 = new LinkedList<>();
    Queue<String> queue2 = new LinkedList<>();

    // 判断栈是否为空
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    // 入栈
    public void push(String string) throws Exception {
        if (string == null || string.length() == 0) {
            throw new Exception("input is null");
        }

        if (!queue1.isEmpty()) {
            queue1.offer(string);
        } else if (!queue2.isEmpty()) {
            queue2.offer(string);
        } else {
            queue1.offer(string);
        }
    }

    // 出栈
    public String pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }

            return queue2.poll();
        } else {
            return null;
        }
    }
}
public class 两个队列实现栈 {
    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack();
        String string = null;

        for (int i = 0; i < 10; i++) {
            string = String.valueOf(i);
            myStack.push(string);
        }

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}