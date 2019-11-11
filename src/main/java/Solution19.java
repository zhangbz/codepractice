import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution19 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            int top = stack2.peek();
            if (top < node) {
                stack2.push(top);
            } else {
                stack2.push(node);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack2.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
       return stack2.peek();
    }
}