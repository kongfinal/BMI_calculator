package com.example.bmicalculator

import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bmicalculator.database.BMI
import kotlinx.coroutines.launch

class bmiCalculatoViewModel : ViewModel() {
    var bmiCost = MutableLiveData<String>()
    var bmiCriterion = MutableLiveData<String>()

//    private val _bmiCost = MutableLiveData<String>()
//    val bmiCost: LiveData<String>
//        get() = _bmiCost


    var weightDouble = MutableLiveData<Double>()
    var heightDouble = MutableLiveData<Double>()
    var heightString = MutableLiveData<String>()
    var weightString = MutableLiveData<String>()
    var bmiDouble = MutableLiveData<Double>()

    var statusHeight = false
    var statusWeight = false

    private var _showSnackbarHeight = MutableLiveData<Boolean>()

    val showSnackBarHeight: LiveData<Boolean>
        get() = _showSnackbarHeight

    private var _showSnackbarWeight = MutableLiveData<Boolean>()

    val showSnackBarWeight: LiveData<Boolean>
        get() = _showSnackbarWeight

    init {

        Log.i("bmiCalculatoViewModel", "bmiCalculatoViewModel created!")
        bmiCost.value = ""
        bmiCriterion.value = ""

        weightDouble.value = 0.0
        heightDouble.value = 0.0
        heightString.value = ""
        weightString.value = ""
        bmiDouble.value = 0.0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("bmiCalculatoViewModel", "bmiCalculatoViewModel destroyed!")
    }

    fun doneShowingSnackbarHeight() {
        _showSnackbarHeight.value = false
    }

    fun doneShowingSnackbarWeight() {
        _showSnackbarWeight.value = false
    }

    fun setBmiCost(cost: String): String? {
        bmiCost.value = cost
        return bmiCost.value
    }

    fun setBmiCriterion(calculate: String): String? {
        bmiCriterion.value = calculate
        return bmiCriterion.value
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

    fun calcutator() {
        if(statusHeight == true && statusWeight == true){
            bmiDouble.value = weightDouble.value.toString().toDouble() / Math.pow(((heightDouble.value.toString().toDouble())/100),2.0);
            setBmiCost(String.format("%.2f", bmiDouble.value))
            setBmiCriterion()
        }else if(statusHeight == false){
            _showSnackbarHeight.value = true
        }else if(statusWeight == false){
            _showSnackbarWeight.value = true
        }
    }

    fun setBmiCriterion() {
        if(bmiDouble.value.toString().toDouble() < 18.6){
            setBmiCriterion("ผอม")
        }else if(bmiDouble.value.toString().toDouble() >= 18.6 && bmiDouble.value.toString().toDouble() <= 22.9){
            setBmiCriterion("ปกติ")
        }else if(bmiDouble.value.toString().toDouble() >= 23.0 && bmiDouble.value.toString().toDouble() <= 24.9){
            setBmiCriterion("ท้วม")
        }else if(bmiDouble.value.toString().toDouble() >= 25.0 && bmiDouble.value.toString().toDouble() <= 29.9){
            setBmiCriterion("อ้วน")
        }else{
            setBmiCriterion("อ้วนมาก")
        }
    }

}