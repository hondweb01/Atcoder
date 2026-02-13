import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChokutterAddiction {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("チェック回数");
        Integer checkCount = Integer.parseInt(sc.nextLine());// チェック回数
        System.out.println("就業時間");
        Integer workinghours = Integer.parseInt(sc.nextLine());// 始業～終業
        System.out.println("チェック時間");
        List<Integer> list = new ArrayList<>();
        if (checkCount != 0) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                // 空なら終了
                if (str.isEmpty()) {
                    break;
                }

                Integer checkTime = Integer.parseInt(str);// チェックした時間

                list.add(checkTime);
            }
        }else{
            System.out.println(workinghours);
        }
        int beforeCheck=0;

        int noCheckTime = 0;

        if (checkCount != null) {
            for (int i = 0; i < workinghours; i++) {
                // 入力された確認時間を取り出す
                for (int time : list) {
                    // 比較して同じであれば100追加
                    if (i == time && time<=100 || i == time && time-beforeCheck>100) {
                        i = i + 100;
                        noCheckTime = noCheckTime + 100;
                    }
                    beforeCheck=time;

                }

            }
            int time = workinghours - noCheckTime;
            System.out.println(time);
            sc.close();

        }

    }
    /**
     * 答え
     * 
     * 
     * 通った回数と閉じる回数は一致しない
     * →100に通る（+100）150通る(この間は閉じているのでカウントしない)
     *秒でなくイベントを回す
     * 区間で考える（見ている区間を足し合わせる
     * 状態管理が必要　checkttorを見ているかどうか（後ろを通り過ぎる-100の範囲は見ていない
     * 最初は時刻0で開く

青木君が来たとき

開いていたら

その時刻まで加算

閉じる

100秒後に再オープン予約

最後まで処理したら、終業時間まで加算


記述順
１．標準入力
２．内部処理
     */

    public static void main2(String[] args) throws Exception {
        
        //１．標準入力
        Scanner sc=new Scanner(System.in);
        //後ろを通る回数
        int N=sc.nextInt();
        //終業する時刻
        long T=sc.nextLong();
        //A 通りかかった時刻 N 回数
        //青木君が通りかかった時刻を、N個ぶんまとめて保存する配列を作っている
        long []A=new long[N];
        for(int i=0;i<N;i++){
            //通りかかった時刻と回数の標準入力を配列に格納する。
            A[i]=sc.nextLong();

        }

    long total=0;//開いていた時間の合計
    long current=0;//現在時刻
    long nextOpen=0;//次に開く時刻
    boolean open=true;//今開いているかどうか（0時点では見ているのでtrueスタート）

        // aokiに標準入力の値を通った回数分渡す。
    for(int i=0;i<N;i++){
        long aoki=A[i];//確認した時間をaokiに入れて各ifで比較

        //開いておらず、次に開く時間よりaokiの方が大きい場合
        if(!open && aoki>=nextOpen){
            open=true;
            current=nextOpen;
        }

        //開いている時にaokiが通りかかった場合の処理
        if(open){
            total+=aoki-current;
            open=false;
            nextOpen=aoki+100;//次に開くのは通り過ぎた100後
        }
        //見ていた時間の合計を追加する（終業時間-現在時間）
        if(open){
            total+=T-current;

        }else if(nextOpen<T){
            total+=T-nextOpen;

        }
        System.out.println(total);

    }






    }
}
