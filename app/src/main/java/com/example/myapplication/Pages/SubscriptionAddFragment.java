package com.example.myapplication.Pages;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddAppBinding;
import com.example.myapplication.databinding.FragmentSubscriptionAddBinding;

import org.jetbrains.annotations.NotNull;

import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.api.PersianPickerDate;
import ir.hamsaa.persiandatepicker.api.PersianPickerListener;


public class SubscriptionAddFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentSubscriptionAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSubscriptionAddBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("اشتراک جدید");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);


        binding.subAddIfApp.setText("محصول");
        binding.subAddIfPlan.setText("نوع اشتراک");

        binding.subAddIfApp.setAdapter(new String[]{"Option 1", "Option 2", "Option 3"});
        binding.subAddIfPlan.setAdapter(new String[]{"Option 1", "Option 2", "Option 3"});
binding.subAddIfMaxVersion.setText("آخرین ورژن قابل دریافت");
binding.subAddIfEndDate.setText("تاریخ پایان");
        binding.subAddIfStartDate.setText("تاریخ شروع");

        PersianDatePickerDialog picker = new PersianDatePickerDialog(getActivity())
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1300)

                .setInitDate(PersianDatePickerDialog.THIS_YEAR, PersianDatePickerDialog.THIS_MONTH, PersianDatePickerDialog.THIS_DAY)
                .setActionTextColor(Color.GRAY)
                // .setTypeFace(typeface)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new PersianPickerListener() {
                    @Override
                    public void onDateSelected(@NotNull PersianPickerDate persianPickerDate) {
//                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getTimestamp());//675930448000
//                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getGregorianDate());//Mon Jun 03 10:57:28 GMT+04:30 1991
//                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianLongDate());// دوشنبه  13  خرداد  1370
//                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianMonthName());//خرداد
//                        Log.d(TAG, "onDateSelected: " + PersianCalendarUtils.isPersianLeapYear(persianPickerDate.getPersianYear()));//true
                        binding.subAddIfStartDate.editText.setText(persianPickerDate.getPersianYear() + "/" + persianPickerDate.getPersianMonth() + "/" + persianPickerDate.getPersianDay());
                        Toast.makeText(getActivity(), persianPickerDate.getPersianYear() + "/" + persianPickerDate.getPersianMonth() + "/" + persianPickerDate.getPersianDay(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        binding.subAddIfStartDate.editText.setFocusable(false);
        binding.subAddIfStartDate.editText.setClickable(true);
        binding.subAddIfStartDate.editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.show();
            }
        });



        return binding.getRoot();
    }
}