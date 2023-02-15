package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinItemDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinItemDetail
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinItemDetail
import com.plcoding.cryptocurrencyappyt.domain.repositary.CoinRepositary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getCoinUseCase @Inject constructor(
    private val repository: CoinRepositary
){
    operator fun invoke(coinId : String) : Flow<Resource<CoinItemDetail>> = flow {
        try{
            emit(Resource.Loading<CoinItemDetail>())
            val coin = repository.getCoinItemById(coinId).toCoinItemDetail()
             emit(Resource.Success<CoinItemDetail>(coin))
        }
        catch ( e : HttpException){
            emit(Resource.Error<CoinItemDetail>(e.localizedMessage ?: " An unexpected error occurred"))
        }
        catch (e : IOException){
            emit(Resource.Error<CoinItemDetail>("Check the internet"))
        }
    }


}