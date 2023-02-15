package com.plcoding.cryptocurrencyappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.coinDetail.component.CoinDetailScreen
import com.plcoding.cryptocurrencyappyt.presentation.coinList.component.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {

                   val navController = rememberNavController()

                    NavHost(navController = navController,
                          startDestination = Screen.CoinListScree.route){

                        composable(
                            route = Screen.CoinListScree.route
                        ){
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()



                        }

                    }

                }
            }
        }
    }
}