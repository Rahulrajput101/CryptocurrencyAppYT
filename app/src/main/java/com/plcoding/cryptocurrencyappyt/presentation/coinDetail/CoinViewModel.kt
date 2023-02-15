package com.plcoding.cryptocurrencyappyt.presentation.coinDetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin.getCoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel  @Inject constructor(
   val getCoinUseCase : getCoinUseCase,
   private val savedStateHandle  : SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
      val state : State<CoinDetailState> = _state

    init {

        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {coinID->
            getCoinDetail(coinID)

        }
    }


       private  fun getCoinDetail(coinId : String){

           getCoinUseCase(coinId).onEach {result ->
                 when(result){
                     is Resource.Success ->{

                         _state.value = CoinDetailState(coin = result.data
                         )


                     }

                     is Resource.Error -> {

                         _state.value = CoinDetailState()

                     }

                     is Resource.Loading -> {

                         _state.value = CoinDetailState(isLoading = true)


                     }




                 }





           }.launchIn(viewModelScope)




       }




}