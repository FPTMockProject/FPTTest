package com.example.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.search.screen.SearchScreenRoute

const val SEARCH_GRAPH = "search_graph"
const val SEARCH_ROUTE = "search"

fun NavController.navigateToSearchScreen() {
    navigate(SEARCH_ROUTE)
}

fun NavGraphBuilder.searchGraph() {
    navigation(
        route = SEARCH_GRAPH,
        startDestination = SEARCH_ROUTE
    ) {
        composable(route = SEARCH_ROUTE) {
            SearchScreenRoute()
        }
    }
}