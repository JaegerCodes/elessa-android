package com.llamasoft.elessa.ui.corrousel

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.llamasoft.elessa.ui.lifecycle.ComposableLifeCycle
import com.llamasoft.elessa.ui.theme.ElessaTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ElCarousel(
    pageContent: @Composable (Int) -> Unit,
    showPager: Boolean = false,
    spacing: Int = 16,
    carouselState: PagerState,
    isAutoScroll: Boolean = true
) {
    var isCarouselVisible by remember { mutableStateOf(false) }
    val interactionSource = remember { carouselState.interactionSource }
    var isManualSwipe by remember { mutableStateOf(false) }

    HandleInteractions(
        interactionSource = interactionSource,
        onManualSwipeChanged = { isManualSwipe = it }
    )
    HandleAutoScroll(
        isCarouselVisible = isCarouselVisible,
        isAutoScroll = isAutoScroll,
        carouselState = carouselState,
        onManualSwipeChanged = { isManualSwipe = it }
    )

    Column {
        ElCarouselPager(
            spacing = spacing,
            carouselState = carouselState,
            onCarouselVisibilityChanged = { isCarouselVisible = it },
            pageContent = pageContent
        )
        if ((carouselState.pageCount) > 1 && showPager) {
            PagerIndexIndicator(
                absoluteValue = carouselState.currentPage,
                pagerSize = carouselState.pageCount,
                modifier = Modifier
                    .testTag("PagerIndexIndicatorTestTag")
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

}

@Composable
private fun HandleAutoScroll(
    isCarouselVisible: Boolean,
    isAutoScroll: Boolean = true,
    manualSwipeDelay: Long? = 10000L,
    autoSwipeDelay: Long? = 5000L,
    carouselState: PagerState,
    onManualSwipeChanged: (Boolean) -> Unit
) {
    val scope = rememberCoroutineScope()

    HandleLifecycleEvents(scope, carouselState)
    LaunchedEffect(isCarouselVisible, isAutoScroll, carouselState.currentPage) {
        if (isCarouselVisible) {
            if (!isAutoScroll) {
                delay(manualSwipeDelay?.times(1000L) ?: 10000L)
            } else {
                delay(autoSwipeDelay?.times(1000L) ?: 5000L)
            }
            scope.launch {
                if (carouselState.currentPage + 1 == carouselState.pageCount) {
                    carouselState.animateScrollToPage(0)
                } else {
                    carouselState.animateScrollToPage(
                        (carouselState.currentPage + 1).mod(carouselState.pageCount)
                    )
                }
                if (!isAutoScroll) {
                    onManualSwipeChanged(false)
                }
            }
        }
    }
}

@Composable
fun ElCarouselPager(
    pageContent: @Composable (Int) -> Unit,
    spacing: Int = 16,
    carouselState: PagerState,
    onCarouselVisibilityChanged: (Boolean) -> Unit
) {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val screenHeight = with(density) { configuration.screenHeightDp.dp.toPx() }

    HorizontalPager(
        contentPadding = PaddingValues(end = spacing.times(2).dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .onGloballyPositioned { coordinates ->
                val position = coordinates.localToWindow(Offset.Zero)
                onCarouselVisibilityChanged(position.y in 0f..screenHeight)
            }
            .testTag("AutoScrollableCarouselTestTag"),
        state = carouselState,
        pageContent = { index ->
            val startPadding = if (index == 0) 0.dp else 10.dp
            val endPadding = if (index == carouselState.pageCount - 1) 1.dp else 6.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = startPadding, end = endPadding)
                    .offset(
                        x = if (carouselState.currentPage == carouselState.pageCount - 1) {
                            spacing.dp
                        } else {
                            spacing.times(-1).dp
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                pageContent(index)
            }
        }
    )
}

@Composable
private fun HandleLifecycleEvents(scope: CoroutineScope, carouselState: PagerState) {
    ComposableLifeCycle { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                scope.launch {
                    carouselState.scrollToPage(0)
                }
            }
            else -> {}
        }
    }
}

@Composable
private fun HandleInteractions(
    interactionSource: InteractionSource,
    onManualSwipeChanged: (Boolean) -> Unit
) {
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is DragInteraction.Start -> {
                    onManualSwipeChanged(true)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ElCarouselPagerPreview() {
    val children = listOf("Child 1", "Child 2", "Child 3")
    val carouselState = rememberPagerState { children.size }

    ElessaTheme {
        Column {
            ElCarousel(
                showPager = true,
                pageContent = { index ->
                    Box(
                        Modifier
                            .background(Color.LightGray)
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {
                        Text(
                            text = children[index],
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .background(Color.LightGray)
                        )
                    }
                },
                spacing = 16,
                carouselState = carouselState
            )
            Text("Current page: ${carouselState.currentPage}", modifier = Modifier.padding(8.dp))
        }
    }
}
