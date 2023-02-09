package com.plcoding.cryptocurrencyappyt.domain.repositary

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinItemDetailDto
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinItemDetail

interface CoinRepositary  {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinItemById(coinId : String) : CoinItemDetailDto

}