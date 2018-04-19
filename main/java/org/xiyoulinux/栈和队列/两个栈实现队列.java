package org.xiyoulinux.栈和队列;

import java.util.Stack;

/**
 * @Author: spider_hgyi
 * @Date: Create in 11:19 2018/4/1
 * @Modified By:
 * @Description:
 * 实现思想：
 * 1. 将两个栈分为 stack1 和 stack2
 * 2. 入队：将数据压入 stack1 中
 * 3. 出队：
 *  （1）首先判断 stack2 是否为空，不为空则出栈
 *  （2）stack2 为空，判断 stack1 是否为空，不为空将 stack1 中的数据弹出并压入 stack2 中，
 *  直到 stack1 为空，弹出 stack2 栈顶元素
 *  （3）stack1，stack2 皆为空，则队列为空
 */
class MyQueue {
    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();

    // 判断队列是否为空
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();

    }

    // 入队
    public void offer(String string) throws Exception {
        if (string == null || string.length() == 0) {
            throw new Exception("input is null");
        }

        stack1.push(string);
    }

    // 出队
    public String poll() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            return stack2.pop();
        }

        return null;
    }
}

public class 两个栈实现队列 {
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        String string = null;

        for (int i = 0; i < 10; i++) {
            string = String.valueOf(i);
            myQueue.offer(string);
        }



        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }
    }
}