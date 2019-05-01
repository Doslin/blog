import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner=new Scanner(System.in);
        Main ma = new Main();
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            String rex =ma.zipData(str);
            System.out.println(rex);
        }
    }
    public  String zipData(String str){

        if(str==null){
            return str;
        }
        StringBuilder sb= new StringBuilder();
        //字符串中第一个字符
        char fChar=str.charAt(0);
        //字符数量默认为1
        int count=1;
        //数组下标从1开始
        for(int i = 1; i < str.length(); i++){
            if("".equals(str)){
                continue;
            }
            if(" ".equals(str)){
                continue;
            }
            char s=str.charAt(i);//字符串中第2个字符
            if(fChar==s){//如果第1个字符和第2个相等，数量+1
                count++;
            }else{//如果第1个字符和第2个字符不相等
                if(count>1){//数量大于1
                    sb.append(fChar);//把第2个字符赋值给第一个字符的值追加到StringBuilder中
                    sb.append(count);//数量追加到StringBuilder中
                    count=1;//重新初始化数量为1
                }else{//如果第1个字符和第2个字符不相等，并且数量不大于1，把第一个字符追加到StringBuilder中
                    sb.append(fChar);
                }
            }
            fChar=s;//把第2个字符赋值给第一个字符
        }
        sb.append(fChar);//最后把字符追加到StringBuilder中
        if (count>1) {//如果数量大于1，把count追加到StringBuilder中
            sb.append(count);
        }
        return sb.toString();
    }
}
