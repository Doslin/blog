package algo;

import java.io.*;

public class Main2 {

    public static void  Main() throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("d://input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int[] arr = new int[1000];
        String ss;
        while((ss = bufferedReader.readLine()) != null)
        {
            int i =Integer.valueOf(ss);
            int m =0;
           while (true ){
               i =i/100;
               if (i >=1){
                    m++;
               }
               if (i <1){
                  arr[m] = arr[m]+1;
                  break;
               }
           }
        }
        for (int i = 0;i<arr.length;i++){
            int n =  100*i;
            int m = n+99;
            System.out.println(n+"-"+m+" "+arr[i]);
        }
        inputStream.close();
        bufferedReader.close();
    }
}
