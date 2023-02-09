package com.plcoding.cryptocurrencyappyt.data.repositary

import com.plcoding.cryptocurrencyappyt.data.remote.CoinApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinItemDetailDto
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinItemDetail
import com.plcoding.cryptocurrencyappyt.domain.repositary.CoinRepositary
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    val api: CoinApi
) : CoinRepositary{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinItemById(coinId : String): CoinItemDetailDto {
        return api.getCoinItemByIdl(coinId)
    }
}