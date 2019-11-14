import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution26 {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        findPermutation(str.toCharArray(), 0, result);

        Collections.sort(result);//使用Collections.sort()完成字符串数组的字典序排序
        return result;
    }

    private void findPermutation(char[] chars, int i, ArrayList<String> result) {
        if (i == chars.length - 1) {
            result.add(new String(chars));//char[]转String，要用new String(Char[])，不能用chars.toString()
        } else {
            HashSet<Character> charSet = new HashSet<>();//使用set去重
            for (int j = i; j < chars.length; j++) {
                if (!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    findPermutation(chars, i+1, result);//这里要用++i或者i+1，不能用i++
                    swap(chars, i, j);//需要恢复原来的顺序，避免影响下次遍历
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmpChar = chars[i];
        chars[i] = chars[j];
        chars[j] = tmpChar;
    }
}
