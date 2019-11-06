package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class lmrCalculatorViewModel : ViewModel() {

    var lbwCost = MutableLiveData<String>()
    var FatWCost = MutableLiveData<String>()
    var lbwCriterion = MutableLiveData<String>()

    var weightDouble = MutableLiveData<Double>()
    var heightDouble = MutableLiveData<Double>()
    var lbwDouble = MutableLiveData<Double>()
    var FatCost = MutableLiveData<Double>()

    var heightString = MutableLiveData<String>()
    var weightString = MutableLiveData<String>()

    var statusHeight = false
    var statusWeight = false

    private var _showSnackbarHeight = MutableLiveData<Boolean>()

    val showSnackBarHeight: LiveData<Boolean>
        get() = _showSnackbarHeight

    private var _showSnackbarWeight = MutableLiveData<Boolean>()

    val showSnackBarWeight: LiveData<Boolean>
        get() = _showSnackbarWeight

    init {
        Log.i("lmrCalculatorViewModel", "lmrCalculatorViewModel created!")
         lbwCost.value = ""
         FatWCost.value = ""
         lbwCriterion.value = ""

         weightDouble.value = 0.0;
         heightDouble.value = 0.0;
         lbwDouble.value = 0.0;
         FatCost.value = 0.0;

         heightString.value = ""
         weightString.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("lmrCalculatorViewModel", "lmrCalculatorViewModel destroyed!")
    }

    fun doneShowingSnackbarHeight() {
        _showSnackbarHeight.value = false
    }

    fun doneShowingSnackbarWeight() {
        _showSnackbarWeight.value = false
    }

    fun setHeightString(height: String){
        heightString.value = height
        if(heightString.value.toString().length != 0){
            heightDouble.value = heightString.value.toString().toDouble()
            statusHeight = true
        }else{
            statusHeight = false
        }
    }

    fun setWeightString(weight: String) {
        weightString.value = weight
        if(weightString.value.toString().length != 0){
            weightDouble.value = weightString.value.toString().toDouble()
            statusWeight = true
        }else{
            statusWeight = false
        }
    }

    fun calcutator(gender: String) {
        if(statusHeight == true && statusWeight == true){
            if(gender.equals("Female")){
                lbwDouble.value = (1.07 * weightDouble.value.toString().toDouble()) -
                        (148 * ( (weightDouble.value.toString().toDouble() * weightDouble.value.toString().toDouble()) / Math.pow((heightDouble.value.toString().toDouble()),2.0)));
                FatCost.value = ((weightDouble.value.toString().toDouble() - lbwDouble.value.toString().toDouble())/weightDouble.value.toString().toDouble())*100
                lbwCost.value = String.format("%.1f", lbwDouble.value)
                FatWCost.value = String.format("%.1f", FatCost.value)
            }else{
                lbwDouble.value = (1.10 * weightDouble.value.toString().toDouble()) -
                        (128 * ( (weightDouble.value.toString().toDouble() * weightDouble.value.toString().toDouble()) /Math.pow((heightDouble.value.toString().toDouble()),2.0)));
                FatCost.value = ((weightDouble.value.toString().toDouble() - lbwDouble.value.toString().toDouble())/weightDouble.value.toString().toDouble())*100
                lbwCost.value = String.format("%.1f", lbwDouble.value)
                FatWCost.value = String.format("%.1f", FatCost.value)
            }
        }else if(statusHeight == false){
            _showSnackbarHeight.value = true
        }else if(statusWeight == false) {
            _showSnackbarWeight.value = true
        }
            setBmiCriterion(gender)
    }

    fun setBmiCriterion(gender: String) {
        if(gender.equals("Female")){
            if (FatCost.value.toString().toDouble() < 15) {
                lbwCriterion.value = "ขาดสารอาหาร"
            } else if (FatCost.value.toString().toDouble() >= 15 && FatCost.value.toString().toDouble() < 19) {
                lbwCriterion.value = "ผอมมาก"
            } else if (FatCost.value.toString().toDouble() >= 19 && FatCost.value.toString().toDouble() < 23) {
                lbwCriterion.value = "ผอม"
            } else if (FatCost.value.toString().toDouble() >= 23 && FatCost.value.toString().toDouble() < 31) {
                lbwCriterion.value = "ปกติ"
            } else if (FatCost.value.toString().toDouble() >= 31 && FatCost.value.toString().toDouble() <= 40) {
                lbwCriterion.value = "อ้วน"
            } else {
                lbwCriterion.value = "อ้วนมาก"
            }
        }else{
            if(FatCost.value.toString().toDouble() < 5){
                lbwCriterion.value = "ขาดสารอาหาร"
            }else if(FatCost.value.toString().toDouble() >= 5 &&  FatCost.value.toString().toDouble() < 9){
                lbwCriterion.value = "ผอมมาก"
            }else if(FatCost.value.toString().toDouble() >= 9 && FatCost.value.toString().toDouble() < 13){
                lbwCriterion.value = "ผอม"
            }else if(FatCost.value.toString().toDouble() >= 13 && FatCost.value.toString().toDouble() < 21){
                lbwCriterion.value = "ปกติ"
            }else if(FatCost.value.toString().toDouble() >= 21 && FatCost.value.toString().toDouble() <= 30){
                lbwCriterion.value = "อ้วน"
            }else{
                lbwCriterion.value = "อ้วนมาก"
            }
        }
    }
}