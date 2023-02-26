package com.example.apptest.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ui.R as CoreUiR
import com.example.matches.R as MatchesR
import com.example.team.R as ParticipationTeamR
import com.example.search.R as SearchR


enum class TopLevelDestination(
    @DrawableRes
    val selectedIconRes: Int,
    @DrawableRes
    val unselectedIconRes: Int,
    @StringRes
    val titleTextRes: Int
) {
    PARTICIPATION_TEAM(
        CoreUiR.drawable.ic_participation_team_selected,
        CoreUiR.drawable.ic_participation_team_unselected,
        ParticipationTeamR.string.participation_team,
    ),
    MATCHES(
        CoreUiR.drawable.ic_matches_selected,
        CoreUiR.drawable.ic_matches_unseleted,
        MatchesR.string.matches,
    ),
    SEARCH(
        CoreUiR.drawable.ic_search_selected,
        CoreUiR.drawable.ic_search_unselected,
        SearchR.string.search,
    ),
}