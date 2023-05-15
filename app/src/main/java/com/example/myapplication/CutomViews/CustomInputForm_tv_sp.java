package com.example.myapplication.CutomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class CustomInputForm_tv_sp extends LinearLayout {

    private TextView textView;
    private Spinner spinner;

    public CustomInputForm_tv_sp(Context context) {
        super(context);
        init(context);
    }

    public CustomInputForm_tv_sp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomInputForm_tv_sp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomInputForm_tv_sp(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        // Inflate the view
        LayoutInflater.from(context).inflate(R.layout.custom_form_tv_sp, this, true);

        // Get references to the views in the layout
        textView = findViewById(R.id.custom_tv);
        spinner = findViewById(R.id.custom_sp);
    }

    public void setText(String text) {
        textView.setText(text);
    }
    public void setAdapter(String[] strings){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, strings);


        spinner.setAdapter(adapter2);
    }

    public String getText() {
        return spinner.getSelectedItem().toString();
    }
}