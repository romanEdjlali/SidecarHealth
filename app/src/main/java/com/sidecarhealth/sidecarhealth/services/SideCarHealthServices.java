package com.sidecarhealth.sidecarhealth.services;

import android.support.annotation.NonNull;

import com.sidecarhealth.sidecarhealth.model.Cost;
import com.sidecarhealth.sidecarhealth.model.DoctorInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by romanedjlali on 7/15/18.
 */

public interface SideCarHealthServices {

    @GET("{id}")
    Call<DoctorInfo> getDoctorInfo(@Path("id") @NonNull int doctorId);
    //Observable<DoctorInfo> getDoctorInfo(@Path("id") @NonNull int doctorId);

    @GET("{id}/costs")
    Call<List<Cost>> getVisitationCost(@Path("id") @NonNull int doctorId);
    //Call<List<Cost>> getVisitationCost(@Path("id") @NonNull int doctorId, @Query("sort") String sort);
    //Observable<List<Cost>> getVisitationCost(@Path("id") int doctorId);
}
