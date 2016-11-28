/**
 * Created by alan on 16/11/28.
 */
public class reverseInt {


    //https://leetcode.com/problems/reverse-integer/

    //如果想通过字符串的形式去解也行...，注意overflow的情况
    public int reverse(int x){
        int result=0;
        //取出低位数，将重新构造的数字与低位数求和
        while(x!=0){
            int tail=x%10;
            int res=result*10+tail;
            //overflow
            if((res-tail)/10!=result){
                return 0;
            }
            result=res;
            x=x/10;
        }
        return result;
    }


}
