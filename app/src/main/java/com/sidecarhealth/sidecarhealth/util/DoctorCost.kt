package com.sidecarhealth.sidecarhealth.util

import com.sidecarhealth.sidecarhealth.R

/**
 * Created by romanedjlali on 7/15/18.
 */

// data class which stores all the doctors info & cost
data class DoctorCost(val title: String, val description: String, val image: Int)

fun getSampleDoctorCosts(): List<DoctorCost> {
    return listOf(
            DoctorCost("Dr. Peterson", "urologist", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Anderson", "General Dr.", R.drawable.ic_doctor_48),
            DoctorCost("Dr. French", "Family Dr.", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Davis", "Dermatologist", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Davis", "Neurologist", R.drawable.ic_doctor_48),

            DoctorCost("Dr. Kelly", "Ortopedist", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Kumar", "Optometrist", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Hatchison", "Dentist", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Bernard", "Cosmotic", R.drawable.ic_doctor_48),
            DoctorCost("Dr. Jose Jackson", "Chiropractor", R.drawable.ic_doctor_48)
    )
}