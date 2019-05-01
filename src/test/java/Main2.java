import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        System.out.println("ÇëÊäÈë²ãÊı£º");
        Scanner scanner=new Scanner(System.in);
        String n = scanner.next();
        Integer integer= 0;
        int nm = 0 ;
        try{
            integer = Integer.valueOf(n);
        }catch (NumberFormatException e){

        }

     nm=  new Main2().climbStairs(integer);
        System.out.println(nm);
    }
    public  int  climbStairs(int n){
       return n;
    }
}
