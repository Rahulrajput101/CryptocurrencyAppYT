package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repositary.CoinRepositary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepositary
){

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }
        catch ( e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: " An unexpected error occurred"))
        }
        catch (e : IOException){
          emit(Resource.Error("Check the internet"))
        }
    }
}