package com.example.participationteam.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.participationteam.presenter.screen.ParticipatingTeamScreenRoute
import com.example.participationteam.presenter.screen.ParticipatingTeamViewModel

const val PARTICIPATING_TEAM_GRAPH = "participating_team_graph"
const val PARTICIPATING_TEAM_ROUTE = "participating_team"

fun NavController.navigateToParticipatingTeamScreen(navOptions: NavOptions? = null) {
    navigate(PARTICIPATING_TEAM_ROUTE, navOptions)
}

fun NavGraphBuilder.participatingTeamGraph() {
    navigation(
        route = PARTICIPATING_TEAM_GRAPH,
        startDestination = PARTICIPATING_TEAM_ROUTE
    ) {
        composable(route = PARTICIPATING_TEAM_ROUTE) {
            val viewModel = hiltViewModel<ParticipatingTeamViewModel>()
            ParticipatingTeamScreenRoute(viewModel = viewModel)
        }
    }
}