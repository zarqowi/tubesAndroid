package com.example.yoggy.myoggu_latihan_gabungan1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xeoh.android.texthighlighter.TextHighlighter;

public class SearchFragment extends Fragment {
    Button b_search ;
    EditText et_search ;
    TextView  tv_output ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_search, container, false);
   Button b_search = (Button)rootView.findViewById(R.id.b_search);
   final EditText et_search = (EditText)rootView.findViewById(R.id.et_search);
   final TextView  tv_output = (TextView)rootView.findViewById(R.id.tv_output);

        b_search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new TextHighlighter()
                    .setBackgroundColor(Color.parseColor("#FFFF00"))
                    .setBackgroundColor(Color.RED)
                    .setBold(true)
                    .addTarget(tv_output)
                    .highlight(et_search.getText().toString(), TextHighlighter.BASE_MATCHER);

        }
    });







        return rootView;
    }
}
