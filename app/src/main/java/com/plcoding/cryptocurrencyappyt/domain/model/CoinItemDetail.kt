package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.Tag
import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember
import java.text.DateFormatSymbols

data class CoinItemDetail(
    val coinId : String,
    val name : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>
)
