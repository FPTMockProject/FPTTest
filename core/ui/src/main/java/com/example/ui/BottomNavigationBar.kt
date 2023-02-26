package com.example.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.theme.LightColorScheme
import com.example.ui.BottomNavigationBarDefaults.BottomLabelConstrainBottomIconButton

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = 4.dp,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .shadow(elevation = elevation, shape = shape)
            .background(color = LightColorScheme.primary, shape = shape)
            .fillMaxWidth()
            .windowInsetsPadding(NavigationBarDefaults.windowInsets)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        content = content,
    )
}

@Composable
fun RowScope.BottomNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
            .weight(1f),
        contentAlignment = Alignment.Center,
    ) {
        val matchParentSize = Modifier
            .matchParentSize()
        ConstraintLayout {
            val (iconBtnRef, labelRef) = createRefs()

            Box(
                modifier = Modifier.constrainAs(iconBtnRef) {
                    top.linkTo(parent.top)
                    centerHorizontallyTo(parent)
                },
            ) {
                if (selected) selectedIcon() else icon()
                Spacer(modifier = Modifier.matchParentSize())
            }

            Box(
                modifier = Modifier.constrainAs(labelRef) {
                    centerHorizontallyTo(parent)
                    bottom.linkTo(iconBtnRef.bottom, BottomLabelConstrainBottomIconButton)
                }
            ) {
                if ((alwaysShowLabel || selected) && label != null) {
                    label()
                }
            }
        }
        Spacer(
            modifier = matchParentSize
                .clickable(
                    enabled = enabled,
                    interactionSource = interactionSource,
                    indication = rememberRipple(),
                    role = Role.Tab,
                    onClick = onClick,
                )
        )
    }
}

@Composable
fun RowScope.BottomNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    @DrawableRes
    iconRes: Int,
    modifier: Modifier = Modifier,
    @DrawableRes
    selectedIconRes: Int = iconRes,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BottomNavigationBarItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        alwaysShowLabel = alwaysShowLabel,
        interactionSource = interactionSource,
        icon = {
            IconButton(
                onClick = {},
                enabled = false,
            ) {
                Icon(
                    modifier = Modifier
                        .size(12.dp)
                        .padding(vertical = 10.dp),
                    painter = painterResource(id = if (selected) selectedIconRes else iconRes),
                    contentDescription = contentDescription,
                )
            }
        },
        label = label,
    )
}

object BottomNavigationBarDefaults {
    val BottomLabelConstrainBottomIconButton = (-8).dp
}
