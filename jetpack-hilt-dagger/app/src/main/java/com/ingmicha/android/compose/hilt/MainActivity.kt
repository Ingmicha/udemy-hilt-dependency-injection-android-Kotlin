package com.ingmicha.android.compose.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ingmicha.android.compose.hilt.db.DatabaseAdapter
import com.ingmicha.android.compose.hilt.db.DatabaseService
import com.ingmicha.android.compose.hilt.hilt.CallInterceptor
import com.ingmicha.android.compose.hilt.hilt.ResponseInterceptor
import com.ingmicha.android.compose.hilt.network.NetworkAdapter
import com.ingmicha.android.compose.hilt.network.NetworkService
import com.ingmicha.android.compose.hilt.ui.theme.HiltAndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var databaseAdapter: DatabaseAdapter

    //Binds
    //    @Inject
//    lateinit var networkAdapter: NetworkAdapter
    //@CallInterceptor
    @ResponseInterceptor
    @Inject
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    databaseAdapter.log("Android Greeting")

                    //Binds
                    //networkAdapter.log("Interface binding")

                    networkService.performNetworkCall()
                }
            }
        }
    }

    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method injection")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltAndroidTheme {
        Greeting("Android")
    }
}