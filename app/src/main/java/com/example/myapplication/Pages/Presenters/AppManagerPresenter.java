package com.example.myapplication.Pages.Presenters;

import android.widget.Toast;

import com.example.myapplication.Core.Retrofit.IRetrofitResponse;
import com.example.myapplication.Core.Retrofit.RetrofitClient;
import com.example.myapplication.Models.ApiModel.ApiGetAppListModel;
import com.example.myapplication.Models.ApiModel.ApiGetToken;
import com.example.myapplication.Pages.AppManagerFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppManagerPresenter {
    public AppManagerPresenter(AppManagerFragment appManagerFragment) {
        this.appManagerFragment = appManagerFragment;
    }

    AppManagerFragment appManagerFragment;

    public void retrofitGetAllApps(IRetrofitResponse iRetrofitResponse) {
        Call<List<ApiGetAppListModel>> call = RetrofitClient.getInstance().getMyApi().GetAllApps();
        call.enqueue(new Callback<List<ApiGetAppListModel>>() {
            @Override
            public void onResponse(Call<List<ApiGetAppListModel>> call, Response<List<ApiGetAppListModel>> response) {
                //  List<Results> myheroList = response.body();
                appManagerFragment.updateList(response.body());
               // String i = response.body().Name;
                // String j=response.body().Data.UserId;
            }

            @Override
            public void onFailure(Call<List<ApiGetAppListModel>> call, Throwable t) {
                Toast.makeText(appManagerFragment.getActivity(), "not ok", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void getAllApps() {
        retrofitGetAllApps(new IRetrofitResponse() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFail(Object response) {

            }
        });
    }
}
