package samples.opencv.sudoku_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class fgm_sudoku_tv_demo_for_demo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //fragment_sudoku_grid_table 割り当てられた数独のフラグメントを代入
        return inflater.inflate(R.layout.fgm_1_1_sudoku_sudoku_table_for_demo_tv, container, false);
    }
}