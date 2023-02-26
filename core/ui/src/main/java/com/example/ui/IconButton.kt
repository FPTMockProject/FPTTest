package com.example.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.theme.LightColorScheme

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = IconButtonDefaults.Size.Default,
    iconSize: Dp = IconButtonDefaults.IconSize.Default,
    backgroundColor: Color = Color.Unspecified,
    enabled: Boolean = true,
    strokeWidth: Dp = Dp.Unspecified,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    iconColor: Color = Color.Unspecified,
    shape: Shape = CircleShape,
    icon: @Composable () -> Unit,
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .border(BorderStroke(strokeWidth, IconButtonDefaults.StrokeColor), shape)
            .clip(shape)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = rememberRipple()
            )
            .background(backgroundColor, shape),
    ) {
        CompositionLocalProvider(
            LocalIconSize provides iconSize,
            LocalIconTintColor provides iconColor,
        ) {
            icon()
        }
    }
}

object IconButtonDefaults {
    val StrokeColor
        @Composable
        get() = LightColorScheme.primary

    object Size {
        val Default = 36.dp
    }

    object IconSize {
        val Default = 24.dp
    }
}