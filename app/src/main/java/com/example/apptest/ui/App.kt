package com.example.apptest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.apptest.navigation.TopLevelDestination
import com.example.matches.navigation.matchesGraph
import com.example.matches.navigation.navigateToMatchesScreen
import com.example.participationteam.navigation.PARTICIPATING_TEAM_GRAPH
import com.example.participationteam.navigation.navigateToParticipatingTeamScreen
import com.example.participationteam.navigation.participatingTeamGraph
import com.example.search.navigateToSearchScreen
import com.example.search.searchGraph
import com.example.theme.LightColorScheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    var currentDestination by remember {
        mutableStateOf(TopLevelDestination.PARTICIPATION_TEAM)
    }
    LaunchedEffect(currentDestination) {
        when (currentDestination) {
            TopLevelDestination.PARTICIPATION_TEAM -> navController.navigateToParticipatingTeamScreen()
            TopLevelDestination.MATCHES -> navController.navigateToMatchesScreen()
            TopLevelDestination.SEARCH -> navController.navigateToSearchScreen()
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = LightColorScheme.primary,
                    contentColor = Color.White,
                    tonalElevation = 6.dp,
                ) {
                    TopLevelDestination.values().forEach { destination ->
                        val selected = destination == currentDestination
                        NavigationBarItem(
                            selected = selected,
                            onClick = { currentDestination = destination },
                            icon = {
                                Icon(
                                    painter = painterResource(id = if (selected) destination.selectedIconRes else destination.unselectedIconRes),
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(id = destination.titleTextRes),
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp,
                                    color = if (selected) Color.White else Color.Black
                                )
                            }
                        )
                    }
                }
            }
        ) { contentPadding ->
            NavHost(
                modifier = Modifier
                    .consumeWindowInsets(contentPadding),
                navController = navController,
                startDestination = PARTICIPATING_TEAM_GRAPH
            ) {
                matchesGraph()
                participatingTeamGraph()
                searchGraph()
            }
        }
    }
}