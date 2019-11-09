package com.example.bmicalculator.databaseViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.bmicalculator.database.BMI
import com.example.bmicalculator.database.BMR
import com.example.bmicalculator.database.BMRDao
import kotlinx.coroutines.*

class BMRdatabaseViewModel(
    val database: BMRDao,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var toBMR = MutableLiveData<BMR?>()

    val Bmrs = database.getAllBmr()

    private suspend fun getToBMIFromDatabase(name: String): BMR? {
        return withContext(Dispatchers.IO) {
            var bmr = database.getBmrByName(name)
            bmr
        }
    }

    private suspend fun insert(bmr: BMR) {
        withContext(Dispatchers.IO) {
            database.insert(bmr)
        }
    }

    fun onStartCalculator(name : String, gender : String, age : Int , weight : Double , height : Double , bmrCost : Double) {
        uiScope.launch {
            val newBMR = BMR()
            newBMR.name = name
            newBMR.gender = gender
            newBMR.age = age
            newBMR.weight = weight
            newBMR.height = height
            newBMR.bmrCost = bmrCost
            insert(newBMR)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}