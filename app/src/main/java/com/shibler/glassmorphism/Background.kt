package com.shibler.glassmorphism

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

@Composable
fun Circle(circleOffset: Offset = Offset(0f, 0f), startColorOffset: Offset = Offset(0f, 0f), endColorOffset: Offset = Offset(100f, 100f), radius : Float = 400f, color: Color = Color.Blue) {

    Canvas(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)) {

        drawCircle(circleOffset, startColorOffset, endColorOffset, radius, color)
    }
}

fun DrawScope.drawCircle(circleOffset: Offset, startColorOffset: Offset, endColorOffset: Offset, radius : Float, color: Color) {




    drawCircle(
        color = color,
        /*brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue),
            start = startColorOffset,
            end = endColorOffset
        ),*/
        radius = radius,
        center = circleOffset
    )

    /*drawCircle(
        brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue)),
        radius = 100f,
        center = center
    )*/
}