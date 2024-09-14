package com.example.loginform.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val BoldContrastColorScheme = lightColorScheme(
    primary = Color(0xFF1B1F3B), // Dark Navy Blue
    onPrimary = Color.White,
    secondary = Color(0xFFEF233C), // Bright Red
    onSecondary = Color.White,
    background = Color(0xFFFFF1E6), // Soft Cream
    surface = Color(0xFF1B1F3B), // Matches primary color for unified look
    onBackground = Color(0xFF1B1F3B),
    onSurface = Color.White
)

private val VividNeonColorScheme = darkColorScheme(
    primary = Color(0xFF0AFF99), // Neon Green
    onPrimary = Color.Black,
    secondary = Color(0xFFFF0054), // Neon Pink
    onSecondary = Color.White,
    background = Color(0xFF121212), // Dark Background
    surface = Color(0xFF1E1E1E), // Slightly lighter for surfaces
    onBackground = Color.White,
    onSurface = Color(0xFF0AFF99)
)


private val EarthyTonesColorScheme = lightColorScheme(
    primary = Color(0xFF6D4C41), // Rich Brown
    onPrimary = Color.White,
    secondary = Color(0xFF8D6E63), // Warm Taupe
    onSecondary = Color.Black,
    background = Color(0xFFEFEFEF), // Light Beige
    surface = Color(0xFFE0E0E0), // Light Gray
    onBackground = Color.Black,
    onSurface = Color(0xFF6D4C41)
)


@Composable
fun LoginFormTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}