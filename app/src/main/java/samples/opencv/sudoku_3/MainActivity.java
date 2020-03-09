package samples.opencv.sudoku_3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static java.lang.String.valueOf;

//ボタンのIDは共有できる

public class MainActivity extends AppCompatActivity {

    //アプリ開始
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._0_activity_main);//activity_mainを表示
        //3秒たったら、自動的にホーム画面に飛ばす
        SetSudokuHomeAuto();
    }
    //3秒間、skipボタンを押さなかったら数独ホームに移動する
    private void SetSudokuHomeAuto(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                setContentView(R.layout._1_sudoku_home);
                SetSudokuDemoTrainOriginal();
            }
        }, 3000);
    }
    //_1_sudoku_homeのボタンによって別のページに行く
    private void SetSudokuDemoTrainOriginal(){
        //sudoku_home内のボタンをクリックしたら移動する
        Button button_sudoku_demo_demo = this.findViewById(R.id.button_sudoku_demo_demo);
        button_sudoku_demo_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout._2_1_sudoku_demo);
                //fgm_sudoku_table_demo_();//フラグメント1 数独表
                fgm_sudoku_tv_demo_for_demo_();////フラグメント1 数独表 テキスト
                fgm_sudoku_analysis_states_demo_();//フラグメント2 数独の解析ボタン
                //BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_train_ボタンをクリックしたら移動する
        Button button_sudoku_train_ = this.findViewById(R.id.button_sudoku_train_);
        button_sudoku_train_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する トレーニング選択肢にいく
                setContentView(R.layout._2_2_sudoku_training_samples);
                //BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_original_ボタンをクリックしたら移動する
        Button button_sudoku_original_ = this.findViewById(R.id.button_sudoku_original_);
        button_sudoku_original_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_3_sudoku_original_question);
                //初期化処理が必要
                SS.Button_No_back = 1;//今の値
                //_3_sudoku_original();//ただフラグメントを設置しただけ
                fgm_sudoku_table_();//フラグメント1 数独表
                fgm_sudoku_input_number_();//フラグメント2 数字入力
                fgm_sudoku_analysis_states_();//フラグメント3 解析スタートボタン（ページ移動）
                //BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_quiz_ボタンをクリックしたら移動する
        Button button_sudoku_quiz_ = this.findViewById(R.id.button_sudoku_quiz);
        button_sudoku_quiz_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_4_sudoku_quiz);
                //BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_quiz_ボタンをクリックしたら移動する
        Button button_sudoku_profile_ = this.findViewById(R.id.button_sudoku_maker_profile);
        button_sudoku_profile_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_5_sudoku_maker_profile);
                 //BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
    }

    //数独クラスを定義
    public class_sudoku SS = new class_sudoku();

    //数独表の入力変数
    int sudoku_input_number_ = 1;//とりあえずは初期値1

    //もし解析が終わった数字入力ボタン（delete）をクリックしたら無効にする


    /**数独のターゲット入力ボタンと解析ボタンの色を反映**/
    public void Input_1(View v) {//解析ボタン１だったら変更
        //すでにdeleteされたボタン(true状態)だったらクリックの反応すらもさせない
        if (!SS.delete_btn_number[1]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 1;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_2(View v) {
        if (!SS.delete_btn_number[2]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 2;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_3(View v) {
        if (!SS.delete_btn_number[3]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 3;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_4(View v) {
        if (!SS.delete_btn_number[4]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 4;//入力数値

            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_5(View v) {
        if (!SS.delete_btn_number[5]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 5;//入力数値

            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_6(View v) {
        if (!SS.delete_btn_number[6]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 6;//入力数値

            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_7(View v) {
        if (!SS.delete_btn_number[7]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 7;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_8(View v) {
        if (!SS.delete_btn_number[8]) {//探査可能な入力数字なのか
            sudoku_input_number_ = 8;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }
    public void Input_9(View v) {
        if(!SS.delete_btn_number[9]) {//探査可能な入力数字なのか
        sudoku_input_number_ = 9;//入力数値
            if (change_als_step_color_ == 1)
                OnBnClickedButtonNoChanger_assist(sudoku_input_number_);
        }
    }





    //デモ入力が押されていなかったら、解析を発動しない変数
    boolean input_for_demo_sudoku = false;

    /*数独デモの入力*/
    public void demo_input(View v){
        input_for_demo_sudoku = true;//デモ入力が押されたらtrue
        //数独の初期値を代入
        SS.set_demo_input();
        //for文でボタンに数独を
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //もし0であったら入力しない
                if (SS.s[tate_][yoko_] != 0) {
                    //初期値の値をボタンに反映
                    TextView t = findViewById(SS.tv_demo_s[tate_][yoko_]);
                    t.setText(valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map(int number_) {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //反映させるTextViewを指定
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //初期化されたnum_workingの値と解析の値が一致していたら空文字
                if(SS.num_working[tate_][yoko_][number_].equals(valueOf(number_)))
                {
                    t.setText("");
                }
                else{
                    t.setText(SS.num_working[tate_][yoko_][number_]);
                }
                //指定した数字があると、それは書き残しておく
                if (SS.s[tate_][yoko_] == number_) {
                    t.setText(valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map_with_specified_number(int number_) {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //反映させるTextViewを指定
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //解析した文字列を代入
                t.setText(SS.num_working[tate_][yoko_][number_]);
                //指定した数字があると、それは書き残しておく
                if (SS.s[tate_][yoko_] == number_) {
                    t.setText(valueOf(SS.s[tate_][yoko_]));
                }
                //初期化されたnum_workingの値と解析の値が一致していたら空文字
                if(SS.num_working[tate_][yoko_][number_].equals("M"))
                {
                    t.setText("確");
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map_with_all_specified_number_() {
        for(int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //反映させるTextViewを指定
                    TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                    //指定した数字があると、それは書き残しておく
                    if (SS.s[tate_][yoko_] == number_) {
                        t.setText(valueOf(SS.s[tate_][yoko_]));
                    }
                    //初期化されたnum_workingの値と解析の値が一致していたら空文字
                    if (SS.num_working[tate_][yoko_][number_].equals("M")) {
                        t.setText("確");
                    }
                }
            }
        }
    }
    //解析マップを初期化して表示
    public void show_rls_map_init(){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //特徴マップ 初期化
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //文字数字が確定していたら、その値を代入
                if (SS.s[tate_][yoko_] == 0) {
                    t.setText("");
                }
                else{
                    t.setText(valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析結果をテキストに表示
    public void show_als_tv_states(int SS_comment_result_num){
        TextView t = findViewById(R.id.tv_als_states);
        if(SS_comment_result_num > 0){
            t.setText("解析結果　解析できました");
        }
        else{
            t.setText("解析結果　解析できませんでした");
        }
    }



    //数独内でその数字が9個使われたらボタンを消去
    public void delete_button_number_name(int sudoku_input_number_){
//        for (int number_ = 1; number_ <= 9; number_++) {
            //消去する番号のカウンター
            int delete_number_counter = 0;
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //番号と数字が一致した回数
                    if (SS.s[tate_][yoko_] == sudoku_input_number_) {
                        delete_number_counter++;
                    }
                }
            }
            //数字のカウンターが9個だったら、ボタンの文字を消す
            if (delete_number_counter == 9) {
                //解析数字ボタンを指定
                Button btn = findViewById(SS.input_number[sudoku_input_number_]);
                btn.setText("");//空文字を入力
                //ボタンを消去するようにうごく
                SS.delete_btn_number[sudoku_input_number_] = true;
            }
//        }
    }



    //1~9までのボタンの簡単処理をまとめる
    public void btn_number_1_9_easy(View v) {
        for (int time_ = 1; time_ <= 10; time_++) {
            for (int number_ = 1; number_ <= 9; number_++) {//1~9

                SS._1_initialize();
                SS._2_1_Nth_0_1_checker_1_TEISU(number_);
                SS._2_2_Nth_0_1_checker_2_area_3_3(number_);
                SS._2_3_Nth_0_1_checker_3_row_col_3_3(number_);
                SS._2_4_special_delete_ver2(number_);
                SS._2_5_change_1_to_number_in_3_3_blocks(number_);

            }
        }
        show_rls_map_init();
    }


    //トレーニング問題1
    public void btn_trn_1(View v) {
        /**前半**/
        //数独の初期値を代入
        SS.set_demo_input_1();
        /**後半**/
        //数独の解析マップの初期化をする
        input_for_demo_sudoku = true;
        SS.Button_No_back = 1;//今の値
        setContentView(R.layout._3_1_1_demo_result_demo);//クリックしたら飛ぶレイアウトページを選択する
        fgm_sudoku_rlt_map_demo_demo_();//解析結果マップ
        fgm_sudoku_input_table_3_3_();//3*3インプット数独表
        fgm_sudoku_analysis_step_demo();//解析手順　ただの解析ボタンの状態

        //解析手順をクリックしては消してという、フラグメントオブフラグメントの処理をする
        //1つ目のボタンを表示
        fgm_sudoku_view_step_1_();

        //3秒間、skipボタンを押さなかったら数独ホームに移動する
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                //数独の解析テキストにマルチスレッドで書き込んでいる
                for (int tate_1 = 1; tate_1 <= 9; tate_1++) {
                    for (int yoko_1 = 1; yoko_1 <= 9; yoko_1++) {
                        //もし0であったら入力しない
                        if (SS.s[tate_1][yoko_1] != 0) {
                            //初期値の値をテキストに反映
                            TextView t = findViewById(SS.tv_rlt_s[tate_1][yoko_1]);
                            t.setText(valueOf(SS.s[tate_1][yoko_1]));
                            SS._1_initialize();//初期化
                        }
                    }
                }
                //数独の解析マップの初期化をする
                SS.Button_No_back = 1;//今の値
            }
        }, 2000);
    }
    public void btn_trn_2(View v) {
        /**前半**/
        //数独の初期値を代入
        SS.set_demo_input_2();
        /**後半**/
        //数独の解析マップの初期化をする
        input_for_demo_sudoku = true;
        SS.Button_No_back = 1;//今の値
        setContentView(R.layout._3_1_1_demo_result_demo);//クリックしたら飛ぶレイアウトページを選択する
        fgm_sudoku_rlt_map_demo_demo_();//解析結果マップ
        fgm_sudoku_input_table_3_3_();//3*3インプット数独表
        fgm_sudoku_analysis_step_demo();//解析手順　ただの解析ボタンの状態

        //解析手順をクリックしては消してという、フラグメントオブフラグメントの処理をする
        //1つ目のボタンを表示
        fgm_sudoku_view_step_1_();

        //3秒間、skipボタンを押さなかったら数独ホームに移動する
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                //数独の解析テキストにマルチスレッドで書き込んでいる
                for (int tate_1 = 1; tate_1 <= 9; tate_1++) {
                    for (int yoko_1 = 1; yoko_1 <= 9; yoko_1++) {
                        //もし0であったら入力しない
                        if (SS.s[tate_1][yoko_1] != 0) {
                            //初期値の値をテキストに反映
                            TextView t = findViewById(SS.tv_rlt_s[tate_1][yoko_1]);
                            t.setText(valueOf(SS.s[tate_1][yoko_1]));
                            SS._1_initialize();//初期化
                        }
                    }
                }
                //数独の解析マップの初期化をする
                SS.Button_No_back = 1;//今の値
            }
        }, 2000);
    }


    //どこでターゲットボタンの数字を刑しているのか


    //デモ数独のデモの解析結果を示す
    public void lets_analysis_demo(View v){
        //数独表の入力が行われたら実行
        if(input_for_demo_sudoku){
            //数独の解析マップの初期化をする
            SS.Button_No_back = 1;//今の値
            //レイアウトだけ変えたいので、これで問題ない
            setContentView(R.layout._3_1_2_result_map_for_demo);//通常解析
            //setContentView(R.layout._3_1_1_demo_result_demo);//最強解析ボタンあり
            fgm_sudoku_rlt_map_demo_demo_();//解析結果マップ
            fgm_sudoku_input_table_3_3_();//3*3インプット数独表

            //fgm_sudoku_analysis_step_demo();//解析手順　ただの解析ボタンの状態
            fgm_sudoku_analysis_step_demo_for_demo();

            //解析手順をクリックしては消してという、フラグメントオブフラグメントの処理をする
            fgm_sudoku_view_step_1_(); //1つ目のボタンを表示
            //3秒間、skipボタンを押さなかったら数独ホームに移動する
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    // ここに5秒後に実行したい処理 数独ホームの表示 マルチスレッドで書き込み
                    for (int tate_1 = 1; tate_1 <= 9; tate_1++) {
                        for (int yoko_1 = 1; yoko_1 <= 9; yoko_1++) {
                            //もし0であったら入力しない
                            if (SS.s[tate_1][yoko_1] != 0) {
                                //初期値の値をテキストに反映
                                TextView t = findViewById(SS.tv_rlt_s[tate_1][yoko_1]);
                                t.setText(valueOf(SS.s[tate_1][yoko_1]));
                                SS._1_initialize(); //初期化する
                            }
                        }
                    }
                    //数独の解析マップの初期化をする
                    SS.Button_No_back = 1;//今の値
                }
            }, 2000);
        }
    }





    /**オリジナル数独で、独立した解析を始めるボタンに独立した関数を定義し、初期化(true)し、いつもの関数を組み込む**/
    //オリジナル数独で、独立した解析を始めるボタンに独立した関数を定義し、初期化(true)し、いつもの関数を組み込む
    public void lets_analysis_by_reuse_demo(View v){
        input_for_demo_sudoku = true;//オリジナル数独なので改めてtrueを定義


        //オリジナル数独画面で、完全に数独が解析できるかできないかを表示


        lets_analysis_demo(v);
    }





















    //そのマスに数字が1,2,3,4,5,6,7,8,9だっらた
    public void btn_special_als(View v){


        SS._1_initialize();//初期化
        for (int number_ = 1; number_ <= 9; number_++) {//1~9
            SS._2_1_Nth_0_1_checker_1_TEISU(number_);
            SS._2_2_Nth_0_1_checker_2_area_3_3(number_);
            SS._2_3_Nth_0_1_checker_3_row_col_3_3(number_);
            SS._2_4_special_delete_ver2(number_);
        }
        SS.decrement_3N_to_2N();
        for (int number_ = 1; number_ <= 9; number_++) {//1~9
            SS._2_5_change_1_to_number_in_3_3_blocks(number_);
        }
        //全体の特徴量マップの中に1があったら定数に変化
        SS.find_1_in_each_f_map();
        //SS.special_special_();//そのマスに数字が1,2,3,4,5,6,7,8,9だっらた
        show_rlt_map_with_all_specified_number_();
    }

    public void btn_als_perfectly(View v) {

    }

    //クリックしたら実行してマルチスレッドで次のボタンを表示させる
    public void als_step_demo_1_(View v) {
        //ターゲット数字がdeleteされたら解析させない
        if(!SS.delete_btn_number[sudoku_input_number_]){
            // //指定したボタン数字はいくつなのか	ANALYSIS_Button_No_back
            SS._2_1_Nth_0_1_checker_1_TEISU(SS.Button_No_back);
            //それに対する関数処理をまとめる
            show_rlt_map(SS.Button_No_back);//解析マップを表示
            fgm_sudoku_view_step_2_();//ボタン１のフラグメントをボタン2のフラグメントに置換
            change_als_step_color_ = 2;
            change_als_step_color(change_als_step_color_);//解析状態の色を変化
        }
    }
    public void als_step_demo_2_(View v) {
        //3*3エリアにあると表示
        SS._2_2_Nth_0_1_checker_2_area_3_3(SS.Button_No_back);
        show_rlt_map(SS.Button_No_back);//解析マップを表示
        fgm_sudoku_view_step_3_();//ボタン１のフラグメントをボタン2のフラグメントに置換
        change_als_step_color_ = 3;
        change_als_step_color(change_als_step_color_);//解析状態の色を変化
    }
    public void als_step_demo_3_(View v){
        SS._2_3_Nth_0_1_checker_3_row_col_3_3(SS.Button_No_back);
        show_rlt_map(SS.Button_No_back);//解析マップを表示
        fgm_sudoku_view_step_4_(); //ボタン１のフラグメントをボタン2のフラグメントに置換
        change_als_step_color_ = 4;
        change_als_step_color(change_als_step_color_);//解析状態の色を変化
    }
    public void als_step_demo_4_(View v){
       //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_5_();//ボタン１のフラグメントをボタン2のフラグメントに置換
        change_als_step_color_ = 5;
        change_als_step_color(change_als_step_color_);//解析状態の色を変化
    }
    public void als_step_demo_5_(View v){
        SS._2_4_special_delete_ver2(SS.Button_No_back);
        //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_6_();//ボタン１のフラグメントをボタン2のフラグメントに置換
        change_als_step_color_ = 6;
        change_als_step_color(change_als_step_color_);//解析状態の色を変化
    }
    public void als_step_demo_6_(View v){
        //3*3ボックス内に指定数字が1つのみだったら確定
        SS._2_5_change_1_to_number_in_3_3_blocks(SS.Button_No_back);
        //確定した数字があるかどうかを表示
        show_als_tv_states(SS.comment_result_num);

        //数独内での数字で全て使われたらボタンに数字を消す
        delete_button_number_name(sudoku_input_number_);




        //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_7_();//ボタン１のフラグメントをボタン2のフラグメントに置換
        change_als_step_color_ = 7;
        change_als_step_color(change_als_step_color_);//解析状態の色を変化
    }
    public void als_step_demo_7_(View v){//初期化
        //ターゲット数独値がすべてなくなったら解析を終了させる
        int target_input_number = 0;
        for(int i = 1; i <= 9;i++){
            if(!SS.delete_btn_number[i]){//true(解析終了)だったら解析終了
                target_input_number++;
            }
        }
        //ターゲット数字がすべて解析し終わったら、[解析完了テキスト]を表示
        if(target_input_number == 0){//加算がされなかったら[終了]
            fgm_sudoku_view_step_8_perfect_();//完成したら終了
        }
        else{
            SS._1_initialize();//初期化
            fgm_sudoku_view_step_1_();//ボタン１のフラグメントをボタン2のフラグメントに置換
            change_als_step_color_ = 1;
            change_als_step_color(change_als_step_color_);//解析状態の色を変化
        }
        //数独の解析マップ　きれいに初期化する
        show_rls_map_init();
    }


    //管理者用ページに移行 数独のテキストを確認
    public void Go_to_private_page(View v){
        //管理者用ページ
        setContentView(R.layout._3_5_private_page);//通常解析
    }

    //インクリメンター
    int plusplus = 0;

    //数独表テキストに書き込む 以下のコードが必要らしい 開発のバージョンによる
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void private_page_to_write(View v){

        //作成ファイル
        String fileName = "sudoku_table_csv.txt";
        String str = "1,4,5,1,6,7,2,3,2,2,4,4,2,6,6,2,7,3,3,2,9,3,5,1,3,8,2,4,1,2,4,2,7,4,8,6,4,9,8,5,3,3,5,7,1,6,1,1,6,2,4,6,8,9,6,9,3,7,2,6,7,5,4,7,8,5,8,3,9,8,4,2,8,6,5,8,7,6,9,4,9,9,6,3";

        //初期値の値をテキストに反映
        TextView t = findViewById(R.id.check_to_write);
        TextView t_ = findViewById(R.id.check_to_write_sudoku);
        //t.setText(String.valueOf(SS.s[tate_1][yoko_1]));

        // try-with-resources テキストを書き込む
        try (FileOutputStream fileOutputstream = openFileOutput(fileName, Context.MODE_PRIVATE)){
            fileOutputstream.write(str.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(str.length() == 0){
            t.setText("書き込み：失敗");
        }
        else{
            t.setText("書き込み：成功");
            t_.setText(str);
        }
    }



    //数独表テキストに読み込む
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void private_page_to_read(View v){

        //初期値の値をテキストに反映
        TextView t = findViewById(R.id.check_to_read);
        TextView t_ = findViewById(R.id.check_to_read_sudoku);

        String text = null;

        //作成ファイル
        String fileName = "sudoku_table_csv.txt";

        // try-with-resources
        try (FileInputStream fileInputStream = openFileInput(fileName);
             BufferedReader reader= new BufferedReader(
                     new InputStreamReader(fileInputStream, StandardCharsets.US_ASCII))) {

            String lineBuffer;
            while( (lineBuffer = reader.readLine()) != null ) {
                //ここでテキストを書き込む
                text = lineBuffer;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //nullではなかったらテキストビューに入力
        if (text != null) {
            t.setText("読み込み：成功");
            t_.setText(text);
        } else {
            //nullだったらエラー
            t.setText("読み込み：失敗");
        }
    }


    int[][] SUDOKU_TABLE = new int[10][10];

    //テキストを読み込んで、数独表に置き換える
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void private_page_to_read_sudoku(View v){


        //初期値の値をテキストに反映
        TextView t_2 = findViewById(R.id.check_to_read2);
        TextView t_3 = findViewById(R.id.check_to_read3);

        //テキスト内容
        String text = null;
        //String[] sudoku_ = new String[sudoku_reader.length];//コンマで区切る

        //作成ファイル
        String fileName = "sudoku_table_csv.txt";

        // try-with-resources
        try (FileInputStream fileInputStream = openFileInput(fileName);
             BufferedReader reader= new BufferedReader(
                     new InputStreamReader(fileInputStream, StandardCharsets.US_ASCII))) {

            String lineBuffer;
            while( (lineBuffer = reader.readLine()) != null ) {

                //ここでテキストを書き込む
                text = lineBuffer;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert text != null;
        String[] sudoku_reader = text.split(",");//コンマで区切る

        //3番目をスキップする
//        for(int i=0;i<=sudoku_reader.length;i+=3){
//            //s[0][1]=[2]
//            //SUDOKU_TABLE[Integer.parseInt(sudoku_reader[i])][Integer.parseInt(sudoku_reader[i+1])] = Integer.parseInt(sudoku_reader[i+2]);
//
//        }

        int i = 0;
        boolean working_reading = true;
//        while (working_reading){
//
//            //SUDOKU_TABLE[Integer.parseInt(sudoku_reader[i])][Integer.parseInt(sudoku_reader[i+1])] = Integer.parseInt(sudoku_reader[i+2]);
//            i = i + 3;
//            if(i<=sudoku_reader.length) working_reading = false;
//        }

        //i = sudoku_reader[1];
        String s = sudoku_reader[1];
        i = Integer.valueOf(s);

        t_2.setText(s);
        t_3.setText(i);
        //nullではなかったらテキストビューに入力
        //if (text != null) {
           //t_.setText("読み込み：成功");

            //t_3.setText(Integer.parseInt(sudoku_reader[1]) + Integer.parseInt(sudoku_reader[2]));
            //t_3.setText(Integer.parseInt(s));
//        } else {
//            t_2.setText("読み込み：失敗");
//        }

    }




    //解析中の際にターゲット数字を維持する
    int change_als_step_color_ = 1;//解析ボタンの色変えカウンター
    public void change_als_step_color(int change_als_step_color){
        //今のボタンをいつもの色に変えて、次のボタンを特別色にする
        TextView btn_set_now = findViewById(SS.fgm_fgm_btn_als_step_[change_als_step_color]);//今のボタン
        int change_als_step_color__ = change_als_step_color - 1;//新たに変数を加える
        //解析ボタンは合計7つ
        if(change_als_step_color__ == 0){
            change_als_step_color__ = 7;//8までいったら1に戻す
        }
        TextView btn_set_next = findViewById(SS.fgm_fgm_btn_als_step_[change_als_step_color__]);//次のボタン
        //リソースから作成したDrawableのリソースを取得
        Drawable btn_clr_now = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_green_yellow, null);
        //ボタンにDrawableを適用する
        btn_set_next.setBackground(btn_clr_now);
        //今のボタンの名前に変更すし、前のボタンの名前も変更する
        //リソースから作成したDrawableのリソースを取得
        Drawable btn_color_back = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_sky_blue, null);
        //ボタンにDrawableを適用する
        btn_set_now.setBackground(btn_color_back);
    }




    //以前と同じ数独値を入力するとき、置き換える
    public void btn_tv_s_table_(int tate_,int yoko_,int sudoku_input_number__) {
        //以前と同じ数独値を入力するとき、置き換える
        Button t = findViewById(SS.button_s[tate_][yoko_]);//数独ボタンに記入
         if(SS.s[tate_][yoko_] == sudoku_input_number__){ //以前と同じ値を入力すると置換
            SS.s[tate_][yoko_] = 0;//数独値を0
            t.setText("");//空文字を入力
        }
        else{
            //以前と同じ数独値を入力するとき、置き換える
            SS.s[tate_][yoko_] = sudoku_input_number__;//数独表に代入
            t.setText(valueOf(SS.s[tate_][yoko_]));//数字が確定していたら、値を代入
        }
    }



    /***********************解析ボタン1番目の時のみ入力番号を変換***************************************/
    public void OnBnClickedButtonNoChanger_assist(int number_){
        if(SS.booleans_btn_als_step_[1]) {//解析ボタン1番目の時のみ入力番号を変換
            SS.Button_No_now = number_;//今のボタン
            OnBnClickedButtonNoChanger();//前のボタンと一致していなかったら色を変える
            SS.Button_No_back = number_;//前のボタンとして保存
        }
    }
    /***********************数字入力ボタン 他のボタンに移ったらボタンの色を維持*******************************/
    public void OnBnClickedButtonNoChanger() {
        Button btn_set_now = findViewById(SS.input_number[SS.Button_No_now]);//今のボタン
        Button btn_set_back = findViewById(SS.input_number[SS.Button_No_back]);//前のボタン
        //今の値と前の値が一致しなかったら、
        if (SS.Button_No_back != SS.Button_No_now) {
            //リソースから作成したDrawableのリソースを取得
            Drawable btn_clr_now = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_green_yellow, null);
            //ボタンにDrawableを適用する
            btn_set_back.setBackground(btn_clr_now);
            //今のボタンの名前に変更すし、前のボタンの名前も変更する
            //リソースから作成したDrawableのリソースを取得
            Drawable btn_color_back = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_sky_blue, null);
            //ボタンにDrawableを適用する
            btn_set_now.setBackground(btn_color_back);
        }
    }
    /*********************************数独表ボタンの関数*******************************/
    public void btn_s_table_11(View v){
        btn_tv_s_table_(1,1,sudoku_input_number_);
    }
    public void btn_s_table_12(View v){
        btn_tv_s_table_(1,2,sudoku_input_number_);
    }
    public void btn_s_table_13(View v){
        btn_tv_s_table_(1,3,sudoku_input_number_);
    }
    public void btn_s_table_14(View v){
        btn_tv_s_table_(1,4,sudoku_input_number_);
    }
    public void btn_s_table_15(View v){
        btn_tv_s_table_(1,5,sudoku_input_number_);
    }
    public void btn_s_table_16(View v){
        btn_tv_s_table_(1,6,sudoku_input_number_);
    }
    public void btn_s_table_17(View v){
        btn_tv_s_table_(1,7,sudoku_input_number_);
    }
    public void btn_s_table_18(View v){
        btn_tv_s_table_(1,8,sudoku_input_number_);
    }
    public void btn_s_table_19(View v){
        btn_tv_s_table_(1,9,sudoku_input_number_);
    }
    public void btn_s_table_21(View v){
        btn_tv_s_table_(2,1,sudoku_input_number_);
    }
    public void btn_s_table_22(View v){
        btn_tv_s_table_(2,2,sudoku_input_number_);
    }
    public void btn_s_table_23(View v){
        btn_tv_s_table_(2,3,sudoku_input_number_);
    }
    public void btn_s_table_24(View v){
        btn_tv_s_table_(2,4,sudoku_input_number_);
    }
    public void btn_s_table_25(View v){
        btn_tv_s_table_(2,5,sudoku_input_number_);
    }
    public void btn_s_table_26(View v){
        btn_tv_s_table_(2,6,sudoku_input_number_);
    }
    public void btn_s_table_27(View v){
        btn_tv_s_table_(2,7,sudoku_input_number_);
    }
    public void btn_s_table_28(View v){
        btn_tv_s_table_(2,8,sudoku_input_number_);
    }
    public void btn_s_table_29(View v){
        btn_tv_s_table_(2,9,sudoku_input_number_);
    }
    public void btn_s_table_31(View v){
        btn_tv_s_table_(3,1,sudoku_input_number_);
    }
    public void btn_s_table_32(View v){
        btn_tv_s_table_(3,2,sudoku_input_number_);
    }
    public void btn_s_table_33(View v){
        btn_tv_s_table_(3,3,sudoku_input_number_);
    }
    public void btn_s_table_34(View v){
        btn_tv_s_table_(3,4,sudoku_input_number_);
    }
    public void btn_s_table_35(View v){
        btn_tv_s_table_(3,5,sudoku_input_number_);
    }
    public void btn_s_table_36(View v){
        btn_tv_s_table_(3,6,sudoku_input_number_);
    }
    public void btn_s_table_37(View v){
        btn_tv_s_table_(3,7,sudoku_input_number_);
    }
    public void btn_s_table_38(View v){
        btn_tv_s_table_(3,8,sudoku_input_number_);
    }
    public void btn_s_table_39(View v){
        btn_tv_s_table_(3,9,sudoku_input_number_);
    }
    public void btn_s_table_41(View v){
        btn_tv_s_table_(4,1,sudoku_input_number_);
    }
    public void btn_s_table_42(View v){
        btn_tv_s_table_(4,2,sudoku_input_number_);
    }
    public void btn_s_table_43(View v){
        btn_tv_s_table_(4,3,sudoku_input_number_);
    }
    public void btn_s_table_44(View v){
        btn_tv_s_table_(4,4,sudoku_input_number_);
    }
    public void btn_s_table_45(View v){
        btn_tv_s_table_(4,5,sudoku_input_number_);
    }
    public void btn_s_table_46(View v){
        btn_tv_s_table_(4,6,sudoku_input_number_);
    }
    public void btn_s_table_47(View v){
        btn_tv_s_table_(4,7,sudoku_input_number_);
    }
    public void btn_s_table_48(View v){
        btn_tv_s_table_(4,8,sudoku_input_number_);
    }
    public void btn_s_table_49(View v){
        btn_tv_s_table_(4,9,sudoku_input_number_);
    }
    public void btn_s_table_51(View v){
        btn_tv_s_table_(5,1,sudoku_input_number_);
    }
    public void btn_s_table_52(View v){
        btn_tv_s_table_(5,2,sudoku_input_number_);
    }
    public void btn_s_table_53(View v){
        btn_tv_s_table_(5,3,sudoku_input_number_);
    }
    public void btn_s_table_54(View v){
        btn_tv_s_table_(5,4,sudoku_input_number_);
    }
    public void btn_s_table_55(View v){
        btn_tv_s_table_(5,5,sudoku_input_number_);
    }
    public void btn_s_table_56(View v){
        btn_tv_s_table_(5,6,sudoku_input_number_);
    }
    public void btn_s_table_57(View v){
        btn_tv_s_table_(5,7,sudoku_input_number_);
    }
    public void btn_s_table_58(View v){
        btn_tv_s_table_(5,8,sudoku_input_number_);
    }
    public void btn_s_table_59(View v){
        btn_tv_s_table_(5,9,sudoku_input_number_);
    }
    public void btn_s_table_61(View v){
        btn_tv_s_table_(6,1,sudoku_input_number_);
    }
    public void btn_s_table_62(View v){
        btn_tv_s_table_(6,2,sudoku_input_number_);
    }
    public void btn_s_table_63(View v){
        btn_tv_s_table_(6,3,sudoku_input_number_);
    }
    public void btn_s_table_64(View v){
        btn_tv_s_table_(6,4,sudoku_input_number_);
    }
    public void btn_s_table_65(View v){
        btn_tv_s_table_(6,5,sudoku_input_number_);
    }
    public void btn_s_table_66(View v){
        btn_tv_s_table_(6,6,sudoku_input_number_);
    }
    public void btn_s_table_67(View v){
        btn_tv_s_table_(6,7,sudoku_input_number_);
    }
    public void btn_s_table_68(View v){
        btn_tv_s_table_(6,8,sudoku_input_number_);
    }
    public void btn_s_table_69(View v){
        btn_tv_s_table_(6,9,sudoku_input_number_);
    }
    public void btn_s_table_71(View v){
        btn_tv_s_table_(7,1,sudoku_input_number_);
    }
    public void btn_s_table_72(View v){
        btn_tv_s_table_(7,2,sudoku_input_number_);
    }
    public void btn_s_table_73(View v){
        btn_tv_s_table_(7,3,sudoku_input_number_);
    }
    public void btn_s_table_74(View v){
        btn_tv_s_table_(7,4,sudoku_input_number_);
    }
    public void btn_s_table_75(View v){
        btn_tv_s_table_(7,5,sudoku_input_number_);
    }
    public void btn_s_table_76(View v){
        btn_tv_s_table_(7,6,sudoku_input_number_);
    }
    public void btn_s_table_77(View v){
        btn_tv_s_table_(7,7,sudoku_input_number_);
    }
    public void btn_s_table_78(View v){
        btn_tv_s_table_(7,8,sudoku_input_number_);
    }
    public void btn_s_table_79(View v){
        btn_tv_s_table_(7,9,sudoku_input_number_);
    }
    public void btn_s_table_81(View v){
        btn_tv_s_table_(8,1,sudoku_input_number_);
    }
    public void btn_s_table_82(View v){
        btn_tv_s_table_(8,2,sudoku_input_number_);
    }
    public void btn_s_table_83(View v){
        btn_tv_s_table_(8,3,sudoku_input_number_);
    }
    public void btn_s_table_84(View v){
        btn_tv_s_table_(8,4,sudoku_input_number_);
    }
    public void btn_s_table_85(View v){
        btn_tv_s_table_(8,5,sudoku_input_number_);
    }
    public void btn_s_table_86(View v){
        btn_tv_s_table_(8,6,sudoku_input_number_);
    }
    public void btn_s_table_87(View v){
        btn_tv_s_table_(8,7,sudoku_input_number_);
    }
    public void btn_s_table_88(View v){
        btn_tv_s_table_(8,8,sudoku_input_number_);
    }
    public void btn_s_table_89(View v){
        btn_tv_s_table_(8,9,sudoku_input_number_);
    }
    public void btn_s_table_91(View v){
        btn_tv_s_table_(9,1,sudoku_input_number_);
    }
    public void btn_s_table_92(View v){
        btn_tv_s_table_(9,2,sudoku_input_number_);
    }
    public void btn_s_table_93(View v){
        btn_tv_s_table_(9,3,sudoku_input_number_);
    }
    public void btn_s_table_94(View v){
        btn_tv_s_table_(9,4,sudoku_input_number_);
    }
    public void btn_s_table_95(View v){
        btn_tv_s_table_(9,5,sudoku_input_number_);
    }
    public void btn_s_table_96(View v){
        btn_tv_s_table_(9,6,sudoku_input_number_);
    }
    public void btn_s_table_97(View v){
        btn_tv_s_table_(9,7,sudoku_input_number_);
    }
    public void btn_s_table_98(View v){
        btn_tv_s_table_(9,8,sudoku_input_number_);
    }
    public void btn_s_table_99(View v){
        btn_tv_s_table_(9,9,sudoku_input_number_);
    }
    /*********************************画面から元に戻るボタン********初期化が必要************/
    public void return_home(View v){//初期化が必要
        setContentView(R.layout._1_sudoku_home);
        SetSudokuDemoTrainOriginal();//数独ホーム画面
        SS.sudoku_initialize();//数独初期化
        change_als_step_color_ = 1;//数独ボタンの初期化(解析ボタン)
        input_for_demo_sudoku = false;
    }
    /*********************************フラグメント****************************************/
    //フラグメント 特徴マップ
    private void fgm_sudoku_view_step_8_perfect_() {//解析ボタンのフラグメントだから、これはいらない
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_8_perfect());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_tv_demo_for_demo_() {//解析ボタンのフラグメントだから、これはいらない
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_button_sudoku_demo, new fgm_sudoku_tv_demo_for_demo());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_analysis_step_demo_for_demo() {//解析ボタンのフラグメントだから、これはいらない
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_btn_als_step_demo_for_demo, new fgm_sudoku_analysis_step_demo_for_demo());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_analysis_step_demo() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_btn_als_step_demo, new fgm_sudoku_analysis_step_demo());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_input_table_3_3_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_sudoku_input_table_3_3, new fgm_sudoku_input_table_3_3());
        transaction.commit();//処理実行
    }
    //解析ステップをクリックと同時に遷移
    private void fgm_sudoku_view_step_1_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_1());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_2_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_2());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_3_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_3());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_4_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_4());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_5_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_5());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_6_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_6());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_7_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_7());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_rlt_map_demo_demo_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_button_sudoku_demo_rlt_map_demo, new fgm_sudoku_rlt_map_demo());
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_table_demo_() {
        Fragment fragment_button_sudoku_demo_demo;//フラグメントのオブジェクト化
        fragment_button_sudoku_demo_demo = new fgm_sudoku_table();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_demo, fragment_button_sudoku_demo_demo);
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_analysis_states_demo_() {
        Fragment fragment_sudoku_analysis_states_demo;//フラグメントのオブジェクト化
        fragment_sudoku_analysis_states_demo = new fgm_sudoku_analysis_states_demo();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_analysis_states_demo, fragment_sudoku_analysis_states_demo);
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_input_number_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_input, new fgm_sudoku_input_number());//割り当てる
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_analysis_states_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_analysis_states, new fgm_sudoku_analysis_states());//割り当てる
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_table_() {
        Fragment fgm_sudoku_table_;//フラグメントのオブジェクト化
        fgm_sudoku_table_ = new fgm_sudoku_table();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku, fgm_sudoku_table_);//割り当てる
        transaction.commit();//処理実行
    }



}
