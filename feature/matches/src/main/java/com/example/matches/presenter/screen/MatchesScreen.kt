package com.example.matches.presenter.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matches.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import com.example.common.toDateTimeString
import com.example.matches.domain.models.Match
import com.example.ui.VideoView

@Composable
fun MatchesScreenRoute(
    viewModel: MatchesViewModel,
    modifier: Modifier = Modifier,
) {
    MatchesScreen(
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
fun MatchesScreen(
    viewModel: MatchesViewModel,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    val uiState by viewModel.uiState.observeAsState()
    val matches = uiState?.matches ?: return
    val upcoming = matches.upcoming
    val previous = matches.previous
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        state = lazyListState,
    ) {
        item(
            key = R.string.matches,
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = stringResource(id = R.string.matches),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
            )
        }
        item(
            key = R.string.upcoming,
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = stringResource(id = R.string.upcoming),
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
            )
        }
        if (upcoming.isEmpty()) {
            item(key = R.string.no_data) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text = stringResource(id = R.string.no_data),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(
            count = upcoming.size,
            key = { index -> upcoming[index].hashCode() }
        ) { index ->
            val match = upcoming[index]
            MatchItem(match = match)
            Spacer(modifier = Modifier.height(10.dp))
        }
        item(
            key = R.string.previous,
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = stringResource(id = R.string.previous),
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
            )
        }
        if (previous.isEmpty()) {
            item(key = R.string.no_data + 1) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text = stringResource(id = R.string.no_data),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(
            count = previous.size,
            key = { index -> previous[index].hashCode() }
        ) { index ->
            val match = previous[index]
            MatchItem(match = match)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun MatchItem(match: Match) {
    val winnerText = stringResource(id = R.string.winner)
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = match.date.toDateTimeString(),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = match.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
            )
            if (match.winner != null) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = "${winnerText}: ${match.winner}",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }
            if (match.highlights != null) {
                VideoView(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                        .height(300.dp),
                    videoUri = match.highlights
                )
            }
        }
    }

}