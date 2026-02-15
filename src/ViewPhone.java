
import java.util.Scanner;

public class ViewPhone {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        //見に来た回数
        System.out.println("見に来た回数");
        int N = sc.nextInt();

        //終業時間
        System.out.println("終業時間");
        int T = sc.nextInt();

        //スマホを見ているかどうか
        boolean isWatch = true;

        //現在時刻
        int currentTime=0;

        //見ている時間
        int time = 0;
        //再開した時刻
        int next=0;
        //計算用
        int L=0;

        int[] A = new int[N];
        // 見に来た時間
        System.out.println("見に来た時刻");
        for (int i = 0; i < A.length; i++) {
            
            int watch = sc.nextInt();
            A[i] = watch;

            //閉じている場合
            if (isWatch == false) {
                L=A[i]-currentTime;//現在イベント時刻-前の時刻
                if (L>=60) {//↑60秒より大きければスマホ再開
                    isWatch = true;
                }
                //現在時刻をイベント時間に変更
                currentTime = A[i];
            }

            //初回確認時
            if (isWatch == true && currentTime == 0) {
                // time+=A[i]-currentTime;//スマホを見ていた時間
                currentTime = A[i];//150
                time += A[i];//初回は A[i]-0が確認時間 150-0=150
                isWatch = false;//後ろを通ったのでfalseにする
                next=currentTime+60; //次に開く時刻の予約
                
            }
            //初回以外で開いた場合
            if(isWatch==true){
                time+=currentTime-next;//現在時刻-次に開く時刻
                isWatch = false;
                currentTime = A[i];
                next=currentTime+60; //次に開く時刻の予約
            }
        }
        System.out.println("総合時間"+time);
//見ている場合
        if(isWatch){
            time+=T;
        }else{
            //見ていない場合の処理
            if(next<T){
                time+=T-next;
            }

        }

    }

}


