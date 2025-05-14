package com.llamasoft.elessa.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ElessaTheme(
    content: @Composable () -> Unit
) {
    ProvideElTheme {
        content()
    }
}

@Composable
private fun ProvideElTheme(
    colorScheme: ElColorScheme = elLightColorScheme,
    typographyTokens: ElTypographyTokens = defaultElTypographyTokens(elLightColorScheme),
    shapeTokens: ElShapeTokens = defaultElShapeTokens,
    dimenTokens: ElDimenTokens = defaultDimenTokens,
    strokeTokens: ElStrokeTokens = defaultElStrokes(elLightColorScheme),
    content: @Composable () -> Unit
) {
    val rememberedElColorScheme = remember { colorScheme }
    val rememberedElTypographyTokens = remember { typographyTokens }
    val rememberedElShapeTokens = remember { shapeTokens }
    val rememberedElDimenTokens = remember { dimenTokens }
    val rememberedElStrokeTokens = remember { strokeTokens }

    CompositionLocalProvider(
        value = LocalElColors provides rememberedElColorScheme
    ) {
        CompositionLocalProvider(
            value = LocalElTypography provides rememberedElTypographyTokens
        ) {
            CompositionLocalProvider(
                value = LocalElShapes provides rememberedElShapeTokens
            ) {
                CompositionLocalProvider(
                    value = LocalElDimens provides rememberedElDimenTokens
                ) {
                    CompositionLocalProvider(
                        value = LocalElStroke provides rememberedElStrokeTokens
                    ) {
                        MaterialTheme(
                            colorScheme = customColorScheme(
                                elColorScheme = rememberedElColorScheme
                            ),
                            typography = customTypography(
                                elColorPalette = rememberedElColorScheme
                            ),
                            shapes = customShapes(
                                elShapeTokens = rememberedElShapeTokens
                            ),
                            content = content
                        )
                    }
                }
            }
        }
    }
}

val LocalElColors = staticCompositionLocalOf<ElColorScheme> {
    error("No ElUiColorScheme provided")
}

val LocalElTypography = staticCompositionLocalOf<ElTypographyTokens> {
    error("No ElTypographyTokens provided")
}

private val LocalElShapes = staticCompositionLocalOf<ElShapeTokens> {
    error("No ElShapeTokens provided")
}

val LocalElDimens = staticCompositionLocalOf<ElDimenTokens> {
    error("No ElDimenTokens provided")
}

private val LocalElStroke = staticCompositionLocalOf<ElStrokeTokens> {
    error("No ElStrokeTokens provided")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ElessaTheme {
        Scaffold { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Button(
                    onClick = {}
                ) {
                    Text(
                        text = "Hello World!",
                    )
                }
            }
        }
    }
}
