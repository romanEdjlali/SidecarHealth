package com.sidecarhealth.sidecarhealth.services;

import android.util.Log;

import com.sidecarhealth.sidecarhealth.model.Address;
import com.sidecarhealth.sidecarhealth.model.Cost;
import com.sidecarhealth.sidecarhealth.model.DoctorInfo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by romanedjlali on 7/15/18.
 */

public class SidecarHealthServiceProvider {

    public static final String TAG = SidecarHealthServiceProvider.class.getSimpleName();

    private Retrofit retrofit;
    private SideCarHealthServices sidecarHealthServices;
    // Trailing slash is needed
    public static final String BASE_URL = "https://c8e4ece5-082f-4c43-aac1-b0215c1f36a4.mock.pstmn.io/doctors/";
    /**
     * Method to build and return an OkHttpClient so we can set/get
     * headers quickly and efficiently.
     * @return OkHttpClient
     */
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // Add the interceptor to OkHttpClient
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit getRetrofit() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public void getDoctorInfo(int id) {
        if (sidecarHealthServices == null)
            sidecarHealthServices = getRetrofit().create(SideCarHealthServices.class);

        Call<DoctorInfo> doctorInfoData = sidecarHealthServices.getDoctorInfo(id);
        doctorInfoData.enqueue(new Callback<DoctorInfo>() {

            @Override
            public void onResponse(Call<DoctorInfo> call, Response<DoctorInfo> response) {
                Address address = response.body().getAddress();
                Log.d(TAG, "**** Address is: " + address.getStreet() + " "
                        + address.getStreet2() + "\n" + address.getCity() + ", " + address.getState() + " " + address.getZipCode());
            }

            @Override
            public void onFailure(Call<DoctorInfo> call, Throwable t) {
                Log.d(TAG, "**** onFailure: Unable to receive DoctorInfo!");
            }

        });
    }


    public void getVisitationCost(int id) {
        if (sidecarHealthServices == null)
            sidecarHealthServices = getRetrofit().create(SideCarHealthServices.class);

        Call<List<Cost>> visitationCostData = sidecarHealthServices.getVisitationCost(id);
        visitationCostData.enqueue(new Callback<List<Cost>>() {

            @Override
            public void onResponse(Call<List<Cost>> call, Response<List<Cost>> response) {
                List<Cost> costList = response.body();
                for(Cost cost: costList) {
                    Log.d(TAG, "**** Cost info is: " + cost.getCode() + " "
                            + cost.getStatus() + "\n" + cost.getItems() + ", " + cost.getProviderRate() + " " + cost.getSidecarRate());
                }
            }

            @Override
            public void onFailure(Call<List<Cost>> call, Throwable t) {
                Log.d(TAG, "**** onFailure: Unable to receive Cost Info!");

            }

        });
    }

}

