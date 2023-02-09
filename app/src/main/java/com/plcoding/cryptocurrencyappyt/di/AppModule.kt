package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.CoinApi
import com.plcoding.cryptocurrencyappyt.data.repositary.CoinRepositoryImp
import com.plcoding.cryptocurrencyappyt.domain.repositary.CoinRepositary
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   fun provideApi() : CoinApi{
       return Retrofit.Builder()
           .baseUrl(Constants.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(CoinApi::class.java)
   }

    @Provides
    @Singleton
    fun provideRepository(api: CoinApi) : CoinRepositary {
        return CoinRepositoryImp(api)
    }


}