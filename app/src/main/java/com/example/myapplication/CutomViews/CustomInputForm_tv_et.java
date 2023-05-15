package com.example.myapplication.CutomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class CustomInputForm_tv_et extends LinearLayout {

    private TextView textView;
    private EditText editText;

    public CustomInputForm_tv_et(Context context) {
        super(context);
        init(context);
    }

    public CustomInputForm_tv_et(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomInputForm_tv_et(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomInputForm_tv_et(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        // Inflate the view
        LayoutInflater.from(context).inflate(R.layout.custom_form, this, true);

        // Get references to the views in the layout
        textView = findViewById(R.id.custom_tv);
        editText = findViewById(R.id.custom_et);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public String getText() {
        return editText.getText().toString();
    }
}