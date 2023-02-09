package com.plcoding.cryptocurrencyappyt.presentation.coinList

import androidx.lifecycle.ViewModel
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    val getCoinsUseCase: GetCoinsUseCase
)  : ViewModel() {
}