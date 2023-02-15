package com.plcoding.cryptocurrencyappyt.presentation.coinDetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

@Composable
fun TeamListMember(
    team: TeamMember,
    modifier: Modifier = Modifier
){
   Column (
       modifier = modifier,
       verticalArrangement = Arrangement.Center
           ){
       Text(
           text = team.name,
           style = MaterialTheme.typography.h4
       )
       Spacer(modifier = Modifier.height(4.dp))
       Text(
           text = team.position,
           style = MaterialTheme.typography.body2,
           fontStyle = FontStyle.Italic
       )
   }








}
