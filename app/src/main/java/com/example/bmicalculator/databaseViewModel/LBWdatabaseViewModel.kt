package com.example.bmicalculator.databaseViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculator.database.LBW
import com.example.bmicalculator.database.LBWDao
import kotlinx.coroutines.*

class LBWdatabaseViewModel(
    val database: LBWDao,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var toLBW = MutableLiveData<LBW?>()

    val Lbws = database.getAllLbw()

    private suspend fun getToBMIFromDatabase(name: String): LBW? {
        return withContext(Dispatchers.IO) {
            var bmr = database.getLbwByName(name)
            bmr
        }
    }

    private suspend fun insert(lbw: LBW) {
        withContext(Dispatchers.IO) {
            database.insert(lbw)
        }
    }

    fun onStartCalculator(name : String, gender : String, weight : Double , height : Double , sbwCost : Double, fatWCost : Double, lbwCriterion : String) {
        uiScope.launch {
            val newLBW = LBW()
            newLBW.name = name
            newLBW.gender = gender
            newLBW.weight = weight
            newLBW.height = height
            newLBW.sbwCost = sbwCost
            newLBW.fatWCost = fatWCost
            newLBW.lbwCriterion = lbwCriterion
            insert(newLBW)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}