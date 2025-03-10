package com.shibler.glassmorphism

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.shibler.glassmorphism.ui.theme.circleGradient
import com.shibler.glassmorphism.ui.theme.circleGradient2
import com.shibler.glassmorphism.ui.theme.donutHoleBottom
import com.shibler.glassmorphism.ui.theme.donutHoleTop

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

@Composable
fun Circle2(center : Offset, radius: Float, modifier: Modifier = Modifier) {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .then(modifier)
    ) {
        drawGradientCircle(center, radius)
    }

}

fun DrawScope.drawGradientCircle(center : Offset, radius: Float) {

    val gradientCenterColor1 = Offset(center.x, center.y + radius)
    val gradientCenterColor2 = Offset(center.x, center.y - radius * 0.6f)

    drawCircle(
        brush = Brush.linearGradient(colors = listOf(circleGradient, circleGradient2),
            start = gradientCenterColor1,
            end = gradientCenterColor2
        ),
        radius = radius,
        center = center,
    )
}

@Composable
fun Donut(center : Offset, radius : Float = 100f) {

    Canvas(modifier = Modifier.fillMaxSize()) {

        drawDonut(center, radius)
    }
}

fun DrawScope.drawDonut(center : Offset, radius: Float) {

    val width = radius *0.7f

    drawCircle(
        brush = Brush.linearGradient(
            colors = listOf(donutHoleTop, donutHoleBottom),
            start = Offset(center.x, center.y + radius),
            end = Offset(center.x, center.y - radius)
        ),
        radius = radius,
        center = center,
        style = Stroke(
            width = width
        )
    )
}

@Composable
fun Point(center : Offset) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color.Red,
            radius = 10f,
            center = center
        )
    }
}