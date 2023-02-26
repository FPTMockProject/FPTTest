package com.example.participationteam.presenter.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.team.R

@Composable
fun ParticipatingTeamScreenRoute(
    viewModel: ParticipatingTeamViewModel,
) {
    ParticipatingTeamScreen(viewModel = viewModel)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ParticipatingTeamScreen(
    viewModel: ParticipatingTeamViewModel,
) {
    val uiState by viewModel.uiState.observeAsState()
    val teams = uiState?.teams ?: return
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = stringResource(id = R.string.participation_team),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
            )
        }
        items(teams.size) { index ->
            val team = teams[index]
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                GlideImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .padding(1.dp)
                        .size(32.dp),
                    model = team.logo,
                    contentDescription = teams[index].name,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(teams[index].name)
            }

        }
    }
}