package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

@Composable
fun Icon(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
) {
    val iconSize = LocalIconSize.current
    val contentColor = LocalIconTintColor.current
    Box(
        modifier = Modifier
            .requiredHeightIn(iconSize)
            .requiredWidthIn(iconSize)
            .then(modifier),
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            // To respect icon scaled to iconSize at minimum but not painter's size at scale 1f.
            modifier = Modifier.matchParentSize(),
            colorFilter = colorFilter
                ?: contentColor
                    .takeIf {
                        it.isSpecified
                    }
                    ?.let {
                        ColorFilter.tint(it)
                    },
            contentScale = ContentScale.FillBounds,
        )
    }
}

internal val LocalIconSize = compositionLocalOf {
    Dp.Unspecified
}

internal val LocalIconTintColor = compositionLocalOf {
    Color.Unspecified
}