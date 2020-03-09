package samples.opencv.sudoku_3;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import androidx.core.content.res.ResourcesCompat;

public class class_sudoku {
    //数独入力ボタン
    int[] input_number = {0,R.id.btn_set_s_1, R.id.btn_set_s_2,R.id.btn_set_s_3,
            R.id.btn_set_s_4,R.id.btn_set_s_5,R.id.btn_set_s_6,
            R.id.btn_set_s_7,R.id.btn_set_s_8,R.id.btn_set_s_9};
    //数独ボタン用変数 すべて 0 が格納
    int[][] button_s = {{0,0,0,0,0,0,0,0,0,0,0,},
            {0, R.id.btn_s_11, R.id.btn_s_12, R.id.btn_s_13,R.id.btn_s_14, R.id.btn_s_25, R.id.btn_s_16, R.id.btn_s_17, R.id.btn_s_18, R.id.btn_s_19},
            {0, R.id.btn_s_21, R.id.btn_s_22, R.id.btn_s_23,R.id.btn_s_24, R.id.btn_s_35, R.id.btn_s_26, R.id.btn_s_27, R.id.btn_s_28, R.id.btn_s_29},
            {0, R.id.btn_s_31, R.id.btn_s_32, R.id.btn_s_33,R.id.btn_s_34, R.id.btn_s_45, R.id.btn_s_36, R.id.btn_s_37, R.id.btn_s_38, R.id.btn_s_39},
            {0, R.id.btn_s_41, R.id.btn_s_42, R.id.btn_s_43,R.id.btn_s_44, R.id.btn_s_45, R.id.btn_s_46, R.id.btn_s_47, R.id.btn_s_48, R.id.btn_s_49},
            {0, R.id.btn_s_51, R.id.btn_s_52, R.id.btn_s_53,R.id.btn_s_54, R.id.btn_s_55, R.id.btn_s_56, R.id.btn_s_57, R.id.btn_s_58, R.id.btn_s_59},
            {0, R.id.btn_s_61, R.id.btn_s_62, R.id.btn_s_63,R.id.btn_s_64, R.id.btn_s_65, R.id.btn_s_66, R.id.btn_s_67, R.id.btn_s_68, R.id.btn_s_69},
            {0, R.id.btn_s_71, R.id.btn_s_72, R.id.btn_s_73,R.id.btn_s_74, R.id.btn_s_75, R.id.btn_s_76, R.id.btn_s_77, R.id.btn_s_78, R.id.btn_s_79},
            {0, R.id.btn_s_81, R.id.btn_s_82, R.id.btn_s_83,R.id.btn_s_84, R.id.btn_s_85, R.id.btn_s_86, R.id.btn_s_87, R.id.btn_s_88, R.id.btn_s_89},
            {0, R.id.btn_s_91, R.id.btn_s_92, R.id.btn_s_93,R.id.btn_s_94, R.id.btn_s_95, R.id.btn_s_96, R.id.btn_s_97, R.id.btn_s_98, R.id.btn_s_99}};
    //解析マップ用変数
    int[][] tv_rlt_s = {{0,0,0,0,0,0,0,0,0,0,0,},
            {0, R.id.tv_s_rlt_11, R.id.tv_s_rlt_12, R.id.tv_s_rlt_13,R.id.tv_s_rlt_14, R.id.tv_s_rlt_15, R.id.tv_s_rlt_16, R.id.tv_s_rlt_17, R.id.tv_s_rlt_18, R.id.tv_s_rlt_19},
            {0, R.id.tv_s_rlt_21, R.id.tv_s_rlt_22, R.id.tv_s_rlt_23,R.id.tv_s_rlt_24, R.id.tv_s_rlt_25, R.id.tv_s_rlt_26, R.id.tv_s_rlt_27, R.id.tv_s_rlt_28, R.id.tv_s_rlt_29},
            {0, R.id.tv_s_rlt_31, R.id.tv_s_rlt_32, R.id.tv_s_rlt_33,R.id.tv_s_rlt_34, R.id.tv_s_rlt_35, R.id.tv_s_rlt_36, R.id.tv_s_rlt_37, R.id.tv_s_rlt_38, R.id.tv_s_rlt_39},
            {0, R.id.tv_s_rlt_41, R.id.tv_s_rlt_42, R.id.tv_s_rlt_43,R.id.tv_s_rlt_44, R.id.tv_s_rlt_45, R.id.tv_s_rlt_46, R.id.tv_s_rlt_47, R.id.tv_s_rlt_48, R.id.tv_s_rlt_49},
            {0, R.id.tv_s_rlt_51, R.id.tv_s_rlt_52, R.id.tv_s_rlt_53,R.id.tv_s_rlt_54, R.id.tv_s_rlt_55, R.id.tv_s_rlt_56, R.id.tv_s_rlt_57, R.id.tv_s_rlt_58, R.id.tv_s_rlt_59},
            {0, R.id.tv_s_rlt_61, R.id.tv_s_rlt_62, R.id.tv_s_rlt_63,R.id.tv_s_rlt_64, R.id.tv_s_rlt_65, R.id.tv_s_rlt_66, R.id.tv_s_rlt_67, R.id.tv_s_rlt_68, R.id.tv_s_rlt_69},
            {0, R.id.tv_s_rlt_71, R.id.tv_s_rlt_72, R.id.tv_s_rlt_73,R.id.tv_s_rlt_74, R.id.tv_s_rlt_75, R.id.tv_s_rlt_76, R.id.tv_s_rlt_77, R.id.tv_s_rlt_78, R.id.tv_s_rlt_79},
            {0, R.id.tv_s_rlt_81, R.id.tv_s_rlt_82, R.id.tv_s_rlt_83,R.id.tv_s_rlt_84, R.id.tv_s_rlt_85, R.id.tv_s_rlt_86, R.id.tv_s_rlt_87, R.id.tv_s_rlt_88, R.id.tv_s_rlt_89},
            {0, R.id.tv_s_rlt_91, R.id.tv_s_rlt_92, R.id.tv_s_rlt_93,R.id.tv_s_rlt_94, R.id.tv_s_rlt_95, R.id.tv_s_rlt_96, R.id.tv_s_rlt_97, R.id.tv_s_rlt_98, R.id.tv_s_rlt_99}};
    //解析マップ用変数
    int[][] tv_demo_s = {{0,0,0,0,0,0,0,0,0,0,0,},
            {0, R.id.tv_t_s_11, R.id.tv_t_s_12, R.id.tv_t_s_13,R.id.tv_t_s_14, R.id.tv_t_s_15, R.id.tv_t_s_16, R.id.tv_t_s_17, R.id.tv_t_s_18, R.id.tv_t_s_19},
            {0, R.id.tv_t_s_21, R.id.tv_t_s_22, R.id.tv_t_s_23,R.id.tv_t_s_24, R.id.tv_t_s_25, R.id.tv_t_s_26, R.id.tv_t_s_27, R.id.tv_t_s_28, R.id.tv_t_s_29},
            {0, R.id.tv_t_s_31, R.id.tv_t_s_32, R.id.tv_t_s_33,R.id.tv_t_s_34, R.id.tv_t_s_35, R.id.tv_t_s_36, R.id.tv_t_s_37, R.id.tv_t_s_38, R.id.tv_t_s_39},
            {0, R.id.tv_t_s_41, R.id.tv_t_s_42, R.id.tv_t_s_43,R.id.tv_t_s_44, R.id.tv_t_s_45, R.id.tv_t_s_46, R.id.tv_t_s_47, R.id.tv_t_s_48, R.id.tv_t_s_49},
            {0, R.id.tv_t_s_51, R.id.tv_t_s_52, R.id.tv_t_s_53,R.id.tv_t_s_54, R.id.tv_t_s_55, R.id.tv_t_s_56, R.id.tv_t_s_57, R.id.tv_t_s_58, R.id.tv_t_s_59},
            {0, R.id.tv_t_s_61, R.id.tv_t_s_62, R.id.tv_t_s_63,R.id.tv_t_s_64, R.id.tv_t_s_65, R.id.tv_t_s_66, R.id.tv_t_s_67, R.id.tv_t_s_68, R.id.tv_t_s_69},
            {0, R.id.tv_t_s_71, R.id.tv_t_s_72, R.id.tv_t_s_73,R.id.tv_t_s_74, R.id.tv_t_s_75, R.id.tv_t_s_76, R.id.tv_t_s_77, R.id.tv_t_s_78, R.id.tv_t_s_79},
            {0, R.id.tv_t_s_81, R.id.tv_t_s_82, R.id.tv_t_s_83,R.id.tv_t_s_84, R.id.tv_t_s_85, R.id.tv_t_s_86, R.id.tv_t_s_87, R.id.tv_t_s_88, R.id.tv_t_s_89},
            {0, R.id.tv_t_s_91, R.id.tv_t_s_92, R.id.tv_t_s_93,R.id.tv_t_s_94, R.id.tv_t_s_95, R.id.tv_t_s_96, R.id.tv_t_s_97, R.id.tv_t_s_98, R.id.tv_t_s_99}};
    //解析ボタンの状態
    int[] fgm_fgm_btn_als_step_ = {0,R.id.fgm_tv_als_step_1,R.id.fgm_tv_als_step_2,R.id.fgm_tv_als_step_3,
            R.id.fgm_tv_als_step_4,R.id.fgm_tv_als_step_5,R.id.fgm_tv_als_step_6, R.id.fgm_tv_als_step_7};

    //一番目のボタンが実行されたら次のボタンの処理の信号を許可する
    boolean[] booleans_btn_als_step_ = {false,true,false,false,false,false,false};//ボタンが押されたかをチェックする変数

    //数独ボタン用変数　すべて 0 が格納　
    public int[][] s = new int[10][10];

    //数独入力ボタン用の切り替え変数
    int Button_No_now = 1;//今の値
    int Button_No_back = 1;//前の値

    //数独の問題集csv
    int[][] S_csv = {{1,4,5,1,6,7,2,3,2,2,4,4,2,6,6,2,7,3,3,2,9,3,5,1,3,8,2,4,1,2,4,2,7,4,8,6,4,9,8,5,3,3,5,7,1,6,1,1,6,2,4,6,8,9,6,9,3,7,2,6,7,5,4,7,8,5,8,3,9,8,4,2,8,6,5,8,7,6,9,4,9,9,6,3},
            {1,4,8,1,6,9,2,3,5,2,7,7,3,2,2,3,3,9,3,5,1,3,7,6,3,8,4,4,1,7,4,5,6,4,9,2,5,3,6,5,4,2,5,6,4,5,7,3,6,1,8,6,5,7,6,9,6,7,2,3,7,3,7,7,5,2,7,7,8,7,8,1,8,3,1,8,7,5,9,4,1,9,6,3},
            {}};

    //数独のデモ入力変数 デモの数独初期化
    public void set_demo_input(){
        //数独表はcsvから生成
        sudoku_table_from_csv(S_csv[0]);
    }
    //数独のデモ入力変数 デモの数独初期化
    public void set_demo_input_1(){
        s[1][1]=7;
        s[1][2]=8;
        s[1][5]=5;

        s[2][3]=6;
        s[2][6]=1;
        s[2][7]=7;

        s[3][4]=8;
        s[3][8]=1;

        s[4][1]=6;
        s[4][2]=9;
        s[4][6]=7;
        s[4][9]=5;

        s[6][1]=1;
        s[6][4]=6;
        s[6][8]=4;
        s[6][9]=2;

        s[7][2]=2;
        s[7][6]=3;

        s[8][3]=4;
        s[8][4]=5;
        s[8][7]=9;

        s[9][5]=4;
        s[9][8]=8;
        s[9][9]=6;


    }

    //数独のデモ入力変数 デモの数独初期化
    public void set_demo_input_2(){
        s[1][4]=5;
        s[1][6]=7;

        s[2][3]=2;
        s[2][4]=4;
        s[2][6]=6;
        s[2][7]=3;

        s[3][2]=9;
        s[3][5]=1;
        s[3][8]=2;

        s[4][1]=2;
        s[4][2]=7;
        s[4][8]=6;
        s[4][9]=8;

        s[5][3]=3;
        s[5][7]=1;

        s[6][1]=1;
        s[6][2]=4;
        s[6][8]=9;
        s[6][9]=3;

        s[7][2]=6;
        s[7][5]=4;
        s[7][8]=5;

        s[8][3]=9;
        s[8][4]=2;
        s[8][6]=5;
        s[8][7]=6;

        s[9][4]=9;
        s[9][6]=3;
    }

    //CSVファイルから数独表を作成
    public void sudoku_table_from_csv(int[] problem_number_){

        for(int i =0;i<problem_number_.length;i+=3){

            s[problem_number_[i]][problem_number_[i+1]] = problem_number_[i+2];
        }


    }



    //数独の値を
    public void sudoku_initialize(){
        Button_No_now = 1;//今の値
        Button_No_back = 1;//前の値
        for(int number_ = 1;number_<=9;number_++){
            delete_btn_number[number_] = false;
        }
        booleans_btn_als_step_[1] = true;//ボタンが押されたかをチェックする変数
        booleans_btn_als_step_[2] = false;//ボタンが押されたかをチェックする変数
        booleans_btn_als_step_[3] = false;//ボタンが押されたかをチェックする変数
        booleans_btn_als_step_[4] = false;//ボタンが押されたかをチェックする変数
        booleans_btn_als_step_[5] = false;//ボタンが押されたかをチェックする変数

        save_tate_ = 0;
        save_yoko_ = 0;
        start_1_tate = 0;//初期化プール用のスタート位置
        start_2_tate = 0;//初期化プール用のスタート位置
        start_1_yoko = 0;//初期化プール用のスタート位置
        start_2_yoko = 0;//初期化プール用のスタート位置
        comment_result_num = 0;//解析コメント//消してはダメ Main処理に組み込まれている
        f_map_sum = 0;

        for(int tate_ = 1;tate_<=9;tate_++){
            for(int yoko_ = 1;yoko_ <=9;yoko_++){
                for(int number_ = 1;number_ <=9;number_++){
                    bool_num_[tate_][yoko_][number_] = true;
                    num_working[tate_][yoko_][number_] = "";
                }
                s[tate_][yoko_] = 0;
                f_map[tate_][yoko_] = 0;
            }
        }
    }

    //数独の解析ボタンにおいて解析終了ボタン用変数
    boolean[] delete_btn_number ={false,false,false,false,false,false,false,false,false,false,false};

    //特徴マップの変数
    boolean[][][] bool_num_ = new boolean[10][10][10];
    //特徴マップにおいて解析候補変数
    String [][][] num_working = new String[10][10][10];

    //ステップ1 数独表の数字を塗りつぶす
    public void _2_1_Nth_0_1_checker_1_TEISU(int number_){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //0 以外かつ特定番号1以外のとき
                /*******************修正**************************/
                //数独初期値で数独値が0かつ数独値がその数値以外の時
                //つまり指定した数値
                if ((s[tate_][yoko_] != 0) && (s[tate_][yoko_] != number_)) {
                    bool_num_[tate_][yoko_][number_] = false;
                    num_working[tate_][yoko_][number_] = "@";//候補を消す
                }

                //数独の値と対象の値が一致したとき
                if (s[tate_][yoko_] == number_){
                    //行　横
                    for (int row = 1; row <= 9; row++) {
                        bool_num_[tate_][row][number_] = false;
                    }
                    //列　縦
                    for (int col = 1; col <= 9; col++) {
                        bool_num_[col][yoko_][number_] = false;
                    }
                    //数字を代入
                    num_working[tate_][yoko_][number_] = String.valueOf(number_);
                }
            }
        }
    }
    //ステップ2 3*3エリアにその数字がある場合に塗りつぶす
    public void _2_2_Nth_0_1_checker_2_area_3_3(int number_){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //特定の3*3エリアに特定の数値があった場合
                if (s[tate_][yoko_] == number_) {
                    //スタート範囲
                    int start_tate;
                    int start_yoko;
                    //縦のエリアを探索
                    if (1 <= tate_ && tate_ <= 3) start_tate = 1;
                    else if (4 <= tate_ && tate_ <= 6) start_tate = 4;
                    else start_tate = 7;
                    //横のエリアを探索
                    if (1 <= yoko_ && yoko_ <= 3) start_yoko = 1;
                    else if (4 <= yoko_ && yoko_ <= 6) start_yoko = 4;
                    else start_yoko = 7;
                    //エリアに加算する
                    for (int i_ = start_tate; i_ < start_tate + 3; i_++) {
                        for (int j_ = start_yoko; j_ < start_yoko + 3; j_++) {
                            bool_num_[i_][j_][number_] = false;//0にする
                            //特定の3*3エリアに特定の数値があった場合、候補を消す
                            num_working[i_][j_][number_] = "◇";
                        }
                    }
                }
            }
        }
    }
    //ステップ3 数字がある列と行は0にする
    public void _2_3_Nth_0_1_checker_3_row_col_3_3(int number_){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {

                //特定の値の列、行
                if (s[tate_][yoko_] == number_) {
                    //行　横
                    for (int row = 1; row <= 9; row++) {
                        bool_num_[tate_][row][number_] = false;
                        //横の候補を消す
                        num_working[tate_][row][number_] = "☆";
                    }
                    //列　縦
                    for (int col = 1; col <= 9; col++) {
                        bool_num_[col][yoko_][number_] = false;
                        //縦の候補を消す
                        num_working[col][yoko_][number_] = "☆";
                    }
                }

            }
        }
    }
    //ステップ4 3*3エリア内に縦・横のみに1がある場合に他の縦・横を消去
    //3 3*3エリア内に縦・横のみに1がある場合に他の縦・横を消去    // special_delete 用の変数
    int one_counter_in_3_3 = 0;
    int row_or_col_counter = 0;
    int _2_3_Nth_0_1_checker_3_row_col_3_3_counter = 0;
    int save_tate_ = 0;
    int save_yoko_ = 0;
    int start_1_tate = 0;//初期化プール用のスタート位置
    int start_2_tate = 0;//初期化プール用のスタート位置
    int start_1_yoko = 0;//初期化プール用のスタート位置
    int start_2_yoko = 0;//初期化プール用のスタート位置
    public void _2_4_special_delete_ver2(int number_) {
        for (int tate_move = 0; tate_move < 3; tate_move++) {
            for (int yoko_move = 0; yoko_move < 3; yoko_move++) {
                one_counter_in_3_3 = 0;
                // tate=4-6 yoko=4-6 のtrueをカウント
                for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {//int tate_ = 4; tate_ <= 6; tate_++
                    for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                        if (bool_num_[tate_][yoko_][number_]) {
                            one_counter_in_3_3++;
                        }
                    }
                }

                row_or_col_counter = 0;

                if (one_counter_in_3_3 == 3 || one_counter_in_3_3 == 2) {
                    // tate固定
                    for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {
                        row_or_col_counter = 0;//この初期化が組まれていないかもしてない
                        for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                            if (bool_num_[tate_][yoko_][number_]) {
                                row_or_col_counter++;
                            }
                            save_yoko_ = yoko_;
                        }

                        if (save_yoko_ == 3) {
                            start_1_yoko = 4;
                            start_2_yoko = 7;
                        }
                        if (save_yoko_ == 6) {
                            start_1_yoko = 1;
                            start_2_yoko = 7;
                        }
                        if (save_yoko_ == 9) {
                            start_1_yoko = 1;
                            start_2_yoko = 4;
                        }

                        if (one_counter_in_3_3 == row_or_col_counter) {

                            for (int yoko1 = start_1_yoko; yoko1 <= start_1_yoko + 2; yoko1++) {
                                bool_num_[tate_][yoko1][number_] = false;
                                num_working[tate_][yoko1][number_] = "⇄";//縦の候補を消す
                            }

                            for (int yoko1 = start_2_yoko; yoko1 <= start_2_yoko + 2; yoko1++) {
                                bool_num_[tate_][yoko1][number_] = false;
                                num_working[tate_][yoko1][number_] = "⇄";//縦の候補を消す
                            }
                        }
                    }

                    // yoko固定
                    for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                        row_or_col_counter = 0;//この初期化が組まれていないかもしてない
                        for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {
                            if (bool_num_[tate_][yoko_][number_]) {
                                row_or_col_counter++;
                            }
                            save_tate_ = tate_;
                        }

                        if (one_counter_in_3_3 == row_or_col_counter) {

                            if (save_tate_ == 3) {
                                start_1_tate = 4;
                                start_2_yoko = 7;
                            }
                            if (save_tate_ == 6) {
                                start_1_tate = 1;
                                start_2_yoko = 7;
                            }
                            if (save_tate_ == 9) {
                                start_1_tate = 1;
                                start_2_yoko = 4;
                            }

                            for (int tate1 = start_1_tate; tate1 <= start_1_tate + 2; tate1++) {
                                bool_num_[tate1][yoko_][number_] = false;
                                num_working[tate1][yoko_][number_] = "⇅";//縦の候補を消す
                            }

                            for (int tate1 = start_2_yoko; tate1 <= start_2_yoko + 2; tate1++) {
                                bool_num_[tate1][yoko_][number_] = false;
                                num_working[tate1][yoko_][number_] = "⇅";//縦の候補を消す
                            }
                        }
                    }
                }
            }
        }
    }
    //ステップ5 解析した値を数独表に書き込む
    int comment_result_num = 0;//解析コメント//消してはダメ Main処理に組み込まれている
    int incrementer_3_3 = 0;//3*3 のインクリメンター
    public void _2_5_change_1_to_number_in_3_3_blocks(int number_){
        //確定数値の個数
        comment_result_num = 0;//解析コメント
        for (int tate_tate = 0; tate_tate < 3; tate_tate++) {
            for (int yoko_yoko = 0; yoko_yoko < 3; yoko_yoko++) {
                //左ブロック目 3*3 を走査
                incrementer_3_3 = 0;//3*3 のインクリメンター
                for (int tate_ = tate_tate * 3 + 1; tate_ <= tate_tate * 3 + 3; tate_++) {
                    for (int yoko_ = yoko_yoko * 3 + 1; yoko_ <= yoko_yoko * 3 + 3; yoko_++) {
                        if (bool_num_[tate_][yoko_][number_]) {
                            ++incrementer_3_3;
                            save_tate_ = tate_;
                            save_yoko_ = yoko_;
                        }
                    }
                }
                //3*3ブロックでインクリメント1のときに確定　座標を確保
                if (incrementer_3_3 == 1) {
                    //数独の数値が確定
                    s[save_tate_][save_yoko_] = number_;
                    //確定した数値を表記　number_を代入
                    num_working[save_tate_][save_yoko_][number_] = "M";//確定した数字は123と代入しておく
                    //解析できたどうかの変数
                    comment_result_num++;
                }
            }
        }
    }

    /**実装まだ　これをどこに配置するのか**/
    //全体の特徴マップの中で値が1だったら定数に変換
    public void find_1_in_each_f_map() {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //特徴マップで1のときにその値しか入らない
                if (f_map[tate_][yoko_] == 1) {
                    //その1はどこの数値かを調べる
                    for (int number_ = 1; number_ <= 9; number_++) {
                        //みつけたら、それを定数化する
                        if (bool_num_[tate_][yoko_][number_]) {
                            //値を置き換えた。
                            s[tate_][yoko_] = number_;
                            //bool_num_[tate_][yoko_][number_] = false;
                            //候補を消す
                            num_working[tate_][yoko_][number_] = "@";
                        }
                    }
                }
            }
        }
    }

    //f_mapは他の関数に組み込まれているかどうかを確認

    /**実装まだ　これをどこに配置するのか**/
    public void decrement_3N_to_2N() {//1~9までの特徴マップを全て足す
        f_map_sum = 0;
        for (int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //trueはチェックを潜り抜けた生き残り
                    if (bool_num_[tate_][yoko_][number_]) {
                        f_map[tate_][yoko_]++;
                        //全体の特徴マップの和が0だとブレイク
                        f_map_sum++;
                    }
                }
            }
        }
    }



    //特徴量マップ用変数
    int[][] f_map = new int[10][10];
    int f_map_sum = 0;



    //カウンター
    int counter_special =0;
    //全てfalseに変わったら数字が特定
    boolean[] bool_num_special = {false,true,true,true,true,true,true,true,true,true};

    //そのマスに数字が1,2,3,4,5,6,7,8,9だっらた
    public void special_special_(){
        for (int number_ = 1; number_ <= 9; number_++) {//1~9
            for (int tate_ = 1; tate_ <= 9; tate_++) {//s[tate_][]
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {//s[][yoko_] s[tate_][yoko_] = number_
                    //数独表の値が0の時しか処理しない
                    if(s[tate_][yoko_] == 0){
                        //横スライド
                        for(int yoko_1 = 1;yoko_1<=9;yoko_1++){
                            //走査中の値が配列をfalseに変換させる
                            bool_num_special[s[tate_][yoko_1]] = false;
                        }
                        //縦スライド
                        for(int tate_1 = 1;tate_1<=9;tate_1++){
                            //走査中の値が配列をfalseに変換させる
                            bool_num_special[s[tate_1][yoko_]] = false;
                        }
                        //falseカウンター
                        for(int false_cnt = 1;false_cnt<=9;false_cnt++){
                            if(!bool_num_special[false_cnt]){ //falseで
                                counter_special++;//カウンター
                            }
                        }
                        //falseカウンターが9だったら数字を確定 8個にして、一個足りない状態にする
                        if(counter_special == 8){
                            s[tate_][yoko_] = number_;//数字を確定
                            num_working[tate_][yoko_][number_] = "M";
                        }
                        //初期化
                        counter_special =0;
                        for(int i=1;i<=9;i++){
                            bool_num_special[i] = true;
                        }
                    }
                }
            }
       }
    }




    //数独表に数独入力値を代入
    void _btn_sudoku_table_(int tate_,int yoko_,int sudoku_input_number__){
        s[tate_][yoko_] = sudoku_input_number__;
    }


    //特徴マップを初期化 数独を初期化
    void _1_initialize(){
        //同時に初期化
        for (int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //各数字の特徴マップを1にする
                    bool_num_[tate_][yoko_][number_] = true;
                    //特徴特徴マップを初期化　
                    f_map[tate_][yoko_] = 0;
                    //各数字の特徴マップをその数字にする
                    num_working[tate_][yoko_][number_] = String.valueOf(number_);
                }
            }
        }
    }





}
