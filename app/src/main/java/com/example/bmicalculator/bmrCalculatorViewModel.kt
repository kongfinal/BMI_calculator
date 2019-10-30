package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class bmrCalculatorViewModel : ViewModel() {

    var bmrCost = MutableLiveData<String>()

    var weightDouble = MutableLiveData<Double>()
    var heightDouble = MutableLiveData<Double>()
    var ageInt = MutableLiveData<Int>()
    var bmrDouble = MutableLiveData<Double>()

    var heightString = MutableLiveData<String>()
    var weightString = MutableLiveData<String>()
    var ageString = MutableLiveData<String>()

    var statusHeight = false
    var statusWeight = false
    var statusAge = false

    init {
        Log.i("bmrCalculatorViewModel", "bmrCalculatorViewModel created!")
         bmrCost.value = ""

         weightDouble.value = 0.0;
         heightDouble.value = 0.0;
         ageInt.value = 0;
         bmrDouble.value = 0.0;

         heightString.value = ""
         weightString.value = ""
         ageString.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("bmrCalculatorViewModel", "bmrCalculatorViewModel destroyed!")
    }

    fun setHeightString(height: String): String? {
        heightString.value = height
        if(heightString.value.toString().length != 0){
            heightDouble.value = heightString.value.toString().toDouble()
            statusHeight = true
        }else{
            statusHeight = false
        }
        return heightString.value
    }

    fun setWeightString(weight: String): String? {
        weightString.value = weight
        if(weightString.value.toString().length != 0){
            weightDouble.value = weightString.value.toString().toDouble()
            statusWeight = true
        }else{
            statusWeight = false
        }
        return weightString.value
    }

    fun setAgeString(age: String): String? {
        ageString.value = age
        if(ageString.value.toString().length != 0){
            ageInt.value = ageString.value.toString().toInt()
            statusAge = true
        }else{
            statusAge = false
        }
        return ageString.value
    }

    fun calcutator(gender: String): Double? {
        if(statusHeight == true && statusWeight == true && statusAge == true){
            if(gender.equals("Female")){
                bmrDouble.value = 665 + (9.6 * weightDouble.value.toString().toDouble()) +
                        (1.8 * heightDouble.value.toString().toDouble()) - (4.7 * ageInt.value.toString().toInt())
            }else{
                bmrDouble.value = 66 + (13.7 * weightDouble.value.toString().toDouble()) +
                        (5 * heightDouble.value.toString().toDouble()) - (6.8 * ageInt.value.toString().toInt())
            }
        }
        bmrCost.value = String.format("%.1f", bmrDouble.value)
        return bmrDouble.value
    }
}