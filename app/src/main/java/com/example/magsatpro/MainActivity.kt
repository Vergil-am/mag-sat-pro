package com.example.magsatpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.magsatpro.ui.navigation.NavGraph
import com.example.magsatpro.ui.presentation.home.HomeViewModel
import com.example.magsatpro.ui.theme.MagSatProTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private val moviesAPI = get<MoviesAPI>()
//    private val seriesAPI = get<SeriesAPI>()
//    private val channelsAPI= get<ChannelsAPI>()
//    private val authAPI = get<AuthAPI>()

    private val viewModel by viewModels<MainViewModel>()
//    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel
//            val homeViewModel = homeViewModel

            val state by viewModel.state.collectAsState()
            val updateIndex: (index: Int) -> Unit = {
                viewModel.updateStartIndex(it)
            }
            MagSatProTheme {
                val homeViewModel = getViewModel<HomeViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        startDestination = state.startDestination,
                        startIndex = state.startIndex,
                        updateIndex = updateIndex,
//                        homeViewModel = homeViewModel
                    )

                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MagSatProTheme {
//        Greeting("Android")
//    }
//}