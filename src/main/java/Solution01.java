/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution01 {
    public String replaceSpace(StringBuffer str) {

        StringBuffer result = new StringBuffer();
        char temp;
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp == ' ') {
                result.append("%20");
            } else {
                result.append(temp);
            }
        }

        return result.toString();
    }
}
