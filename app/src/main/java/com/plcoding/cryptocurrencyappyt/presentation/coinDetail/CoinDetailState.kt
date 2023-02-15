package com.plcoding.cryptocurrencyappyt.presentation.coinDetail

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinItemDetail

data class CoinDetailState(
   val isLoading : Boolean = false,
   val coin : CoinItemDetail? = null,
   val error : String = ""

)
