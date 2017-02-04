package puzzles.poj;

/**
 *
 * http://acm.hdu.edu.cn/showproblem.php?pid=1874
 * Created by alan on 17/2/4.
 */


import java.util.Scanner;

/**
 *
 * dp[k][i][j]=min(dp[k-1][i][j],dp[k-1][i][k]+dp[k-1][k][j])
 *
 * =>由于方程只与k,k-1有关,所有三维转二维
 *
 *  dp[i][j]=min(dp[i][j],dp[i][k]+dp[k][j])
 *
 */
public class floyd {

    public static void main(String[] args){
        int n,m;
        int mp[][] = new int[205][205];

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            n=scanner.nextInt();
            m=scanner.nextInt();

            for(int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    if(i==j){
                        mp[i][j]=0;
                    } else{
                        mp[i][j]=Integer.MAX_VALUE;
                    }

            for(int i=1;i<=m;i++){
                int x=scanner.nextInt(),y=scanner.nextInt(),z=scanner.nextInt();
                mp[x][y]=Math.min(z,mp[x][y]);
                mp[y][x]=Math.min(z,mp[y][x]);
            }

            int s=scanner.nextInt(),t=scanner.nextInt();

            for (int k=0;k<n;k++)
                for (int i=0;i<n;i++)
                    for (int j=0;j<n;j++)
                        mp[i][j]=Math.min(mp[i][j],mp[i][k]+mp[k][j]);

            if(mp[s][t]==Integer.MAX_VALUE){
                System.out.println("-1");
            }else {
                System.out.println(mp[s][t]);
            }
        }

    }

}
