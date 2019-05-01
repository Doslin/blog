package algo;

import java.util.ArrayList;

public class Java109 {
    public static void main(String[] args){
            char[] sss ={'d','g','g','b'};
        System.out.println( new Java109().ss(sss));
    }
    public  int ss(char[] s) {
        char[] m = new char[1];
        int count = 0;
        ArrayList<String> s1 = new ArrayList<>();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if (m[0] == s[i]) {
                if (sf.toString() != null && sf.toString() != "")
                    count++;
                sf = new StringBuffer(new String(""));
                continue;
            } else {
                if (i > 1 && s[i - 1] == s[i - 2]) {
                    //防止最后那个数字是单独出现的
                    if (i == s.length - 1) {
                        count++;
                    }
                    //为了去除重复的字符
                    else
                        continue;
                }
                m[0] = s[i];
                if (i > 0) {
                    sf.append(s[i - 1]);
                }
            }
        }
        return count;
    }
}
