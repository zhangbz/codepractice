import java.util.ArrayList;

public class Solution20 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        ArrayList<Integer> list = new ArrayList<>();

        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            list.add(pushA[i]);
            while (!list.isEmpty() && list.get(list.size() - 1) == popA[popIndex]) {
                list.remove(list.size() - 1);
                popIndex++;
            }
        }
        return list.isEmpty();
    }
}
