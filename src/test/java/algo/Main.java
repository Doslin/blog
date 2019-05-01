package algo;

import java.io.FileInputStream;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main
{
    public static void mainq(String[] args) throws IOException
    {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("d://input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        HashMap<String,String> map = new HashMap<>();
        String ss ;
        while((ss = bufferedReader.readLine()) != null)
        {
            char[] sm  = ss.toCharArray();
            Integer m =0;
            for (int i = 0 ;i <sm.length;i++){
                if (sm .equals(" ")){
                    m =i;
                }
            }
            ss.substring(0,m);
            map.put(ss.substring(0,m),ss);
        }
        FileInputStream inputStreams = new FileInputStream("d://keyword.conf");
        BufferedReader bufferedReaders = new BufferedReader(new InputStreamReader(inputStreams));
        while((ss = bufferedReaders.readLine()) != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String str = it.next();
               if (str.split(ss).length >0){
                   System.out.println(map.get(str));
               }
            }
        }
        //close
        inputStream.close();
        bufferedReader.close();
        inputStreams.close();
        bufferedReaders.close();
    }

}
