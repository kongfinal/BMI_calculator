package com.example.bmicalculator

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.bmicalculator.database.BMI
import com.example.bmicalculator.database.BMIDao
import com.example.bmicalculator.database.BMIDatabase
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {
    private lateinit var bmiDao: BMIDao
    private lateinit var db: BMIDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, BMIDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        bmiDao = db.BMIDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val bmi = BMI()
        bmiDao.insert(bmi)
        val BmiData = bmiDao.getBmi()
        assertEquals(BmiData?.bmiQuality, -1)
    }
}
