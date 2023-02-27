package com.example.matches.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.matches.presenter.screen.MatchesScreenRoute
import com.example.matches.presenter.screen.MatchesViewModel

const val MATCHES_GRAPH = "matches_graph"
const val MATCHES_ROUTE = "matches"

fun NavController.navigateToMatchesScreen(navOptions: NavOptions? = null) {
    navigate(MATCHES_ROUTE, navOptions)
}

fun NavGraphBuilder.matchesGraph() {
    navigation(
        route = MATCHES_GRAPH,
        startDestination = MATCHES_ROUTE
    ) {
        composable(route = MATCHES_ROUTE) {
            val viewModel = hiltViewModel<MatchesViewModel>()
            MatchesScreenRoute(viewModel = viewModel)
        }
    }
}