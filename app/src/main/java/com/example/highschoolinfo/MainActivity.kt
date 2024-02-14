package com.example.highschoolinfo

import android.app.Application
import android.content.ContentValues
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.highschoolinfo.dao.DummyData
import com.example.highschoolinfo.dao.SchoolInfo
import com.example.highschoolinfo.dao.SchoolInfoDetailsList
import com.example.highschoolinfo.mvvm.SchoolListViewModel
import com.example.highschoolinfo.ui.theme.HighSchoolInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Get viewmodel instance
            var schoolListViewModel = ViewModelProvider(this).get<SchoolListViewModel>()

            HighSchoolInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    schoolNameListComposable(schoolListViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SchoolListPreview() {

    HighSchoolInfoTheme {
        //Greeting("Android")
        schoolNameListComposable(schoolListViewModel = SchoolListViewModel(Application()))
    }
}


// School name list composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun schoolNameListComposable(schoolListViewModel: SchoolListViewModel){
    val context = rememberCompositionContext()
    var schoolList: LiveData<SchoolInfoDetailsList> = schoolListViewModel.schoolListInfo
    var school = schoolList.value?.schoolInfoList
    LazyColumn{
        school?.forEach {
            this.item {
                Card(onClick = { /*TODO*/
                    //Show overview paragraph while clicking the card
                    println("{${it.overview_paragraph}")
                   // Toast.makeText(context, "{${it.overview_paragraph}", Toast.LENGTH_LONG).show()
                }) {
                    Text(text= "${it.schoolName}")
                    Text(text= "${it.dbn}")
                }
            }
        }
    }
}


@Preview
@Composable
fun SchoolDetailsScreenPreview(){
SchoolDetailsScreen(schoolInfo = DummyData.dummyInfo)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolDetailsScreen(schoolInfo: SchoolInfo) {
/*
    Scaffold(
        topBar = { TopAppBar(title = {Text(text = schoolInfo.schoolName) }) }
    ){

    }
*/
    SchoolDetailContent(schoolInfo = schoolInfo)

}

@Composable
fun SchoolDetailContent(schoolInfo: SchoolInfo){
    Column {
        Text(schoolInfo.schoolName)
        Text(schoolInfo.dbn)
        Text(schoolInfo.phone_number)
        Text(schoolInfo.overview_paragraph)
    }
}

