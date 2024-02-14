package com.example.highschoolinfo

import androidx.lifecycle.ViewModelProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.highschoolinfo.mvvm.SchoolListViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.highschoolinfo", appContext.packageName)
    }/*


    @Test
    fun isDataRetrieved(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        var viewmodel : SchoolListViewModel = ViewModelProvider(this.useAppContext()).get(SchoolListViewModel::class.java)
        if(viewmodel.schoolListInfo.isInitialized){
            println("school info list is initialized")
        }
    }
*/
}