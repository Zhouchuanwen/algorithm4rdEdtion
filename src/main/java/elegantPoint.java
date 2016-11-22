import java.util.Scanner;

/**
 * Created by alan on 16/11/18.
 */
public class elegantPoint {

    //http://www.nowcoder.com/question/next?pid=2811407&qid=46574&tid=6014751

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int r=in.nextInt();
        System.out.println(elegantPoints(r));
    }


    public static int elegantPoints(int r2){
        if(r2==0) return 0;
        int count=0;

        //思维转换：由i*i+j*j=r --> r= Math.sqrt(r2-i*i);
        for(int i=0;i<r2;i++){
            double r= Math.sqrt(r2-i*i);
            if((int)r==r){
                count++;
            }
        }

        //位运算
        return count<<2;
    }

}
