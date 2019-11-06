package com.example.bmicalculator.databaseViewModel

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.bmicalculator.database.BMI
import com.example.bmicalculator.database.BMIDao
import kotlinx.coroutines.*

class BMIdatabaseViewModel(
    val database: BMIDao,
    application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var toBMI = MutableLiveData<BMI?>()

    private val Bmis = database.getAllBmi()
    val BmisString = Transformations.map(Bmis) { bmis ->
        //formatNights(bmis, application.resources)
    }

    init {
        initializeToBmi()
    }

    private fun initializeToBmi() {
        uiScope.launch {
            toBMI.value = getToBMIFromDatabase()
        }
    }

    private suspend fun getToBMIFromDatabase(): BMI? {
        return withContext(Dispatchers.IO) {
            var bmi = database.getBmi()
            if (bmi?.bmiCost != 0.0) {
            bmi = null
            }
            bmi
        }
    }

    fun onStartResult(name : String) {
        uiScope.launch {
            val newBMI = BMI()
            newBMI.name = name
            insert(newBMI)
            toBMI.value = getToBMIFromDatabase()
        }
    }

    private suspend fun insert(bmi: BMI) {
        withContext(Dispatchers.IO) {
            database.insert(bmi)
        }
    }

    fun onStartCalculator(name : String, weight : Double , height : Double , bmiCost : Double, bmiCriterion : String) {
        uiScope.launch {
            val newBMI = BMI()
            newBMI.name = name
            newBMI.weight = weight
            newBMI.height = height
            newBMI.bmiCost = bmiCost
            newBMI.bmiCriterion = bmiCriterion
            insert(newBMI)
        }
    }

    private suspend fun update(bmi: BMI) {
        withContext(Dispatchers.IO) {
            database.update(bmi)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}