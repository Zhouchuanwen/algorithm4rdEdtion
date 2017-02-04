package puzzles.poj;

/**
 * Created by alan on 17/1/18.
 */
public class BubbleSort {



    public static void main(String[] args){
        int score[]={1,7,9,23,21,45,34,67,89,100};

        for (int i=0;i<score.length-1;i++){
            for(int j=0;j<score.length-1-i;j++){
                if(score[j] < score[j + 1]){
                    score[j]=score[j]^score[j+1];
                    score[j+1]=score[j+1]^score[j];
                    score[j]=score[j]^score[j+1];
                }
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for(int a = 0; a < score.length; a++){
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }

    }

}
