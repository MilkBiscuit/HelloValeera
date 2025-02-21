package com.cheng.valeera.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cheng.valeera.resources.Res
import com.cheng.valeera.resources.content_desc_back
import com.cheng.valeera.resources.content_desc_close
import org.jetbrains.compose.resources.stringResource


/**
 * Scaffold used by screens that need app bar, with back and close buttons.
 */
@Composable
fun ScreenScaffold(
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    fab: @Composable () -> Unit = {},
    padding: Boolean = true,
    onPop: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = if (onPop == null) {
                    null
                } else {
                    {
                        IconButton(onClick = onPop) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, stringResource(Res.string.content_desc_back))
                        }
                    }
                },
                actions = {
                    actions()

                    // Close icon on the right side
                    if (onClose != null) {
                        IconButton(onClick = onClose) {
                            Icon(
                                Icons.Filled.Close, stringResource(Res.string.content_desc_close),
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = fab,
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .padding(all = if (padding) 20.dp else 0.dp)
                .fillMaxSize(),
        ) {
            content()
        }
    }
}

/**
 * Scaffold used by screens that has a transparent background Top Bar
 */
@Composable
fun TransparentTopBarScaffold(
    actions: @Composable RowScope.() -> Unit = {},
    padding: Boolean = false,
    yOffset: Dp = 0.dp,
    onPop: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(color = MaterialTheme.colors.surface) {
        Column {
            TopAppBar(
                title = {},
                navigationIcon = {
                    if (onPop != null) {
                        IconButton(onClick = onPop) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, stringResource(Res.string.content_desc_back))
                        }
                    }
                },
                actions = actions,
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
            Box(
                modifier = Modifier
                    .offset(y = yOffset)
                    .padding(all = if (padding) 20.dp else 0.dp)
                    .fillMaxSize(),
            ) {
                content()
            }
        }
    }
}
