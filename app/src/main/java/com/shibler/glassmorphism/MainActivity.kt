package com.shibler.glassmorphism

import android.graphics.BlurMaskFilter
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asComposePaint
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.shibler.glassmorphism.ui.theme.GlassmorphismTheme
import com.shibler.glassmorphism.ui.theme.Pink40
import com.shibler.glassmorphism.ui.theme.Pink80
import com.shibler.glassmorphism.ui.theme.orange
import com.shibler.glassmorphism.ui.theme.pink
import com.shibler.glassmorphism.ui.theme.purple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlassmorphismTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GlassmorphismCard() {

    val height = LocalConfiguration.current.screenHeightDp.dp
    val width = LocalConfiguration.current.screenWidthDp.dp

    val widthInPx = with(LocalDensity.current) { width.toPx() }
    val heightInPx = with(LocalDensity.current) { height.toPx() }


    val dpToPx = with(LocalDensity.current) {350.dp.toPx()}
    val dpToPx2 = with(LocalDensity.current) {200.dp.toPx()}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {



        Circle(Offset(widthInPx/2 + dpToPx/2, heightInPx/2 - dpToPx2 * 0.4f), color = purple)
        Circle(Offset(widthInPx/2 - dpToPx/2, heightInPx/2 + dpToPx2/2), radius = 200f, color = pink)
        Circle(Offset(widthInPx/2 - dpToPx * 0.1f, heightInPx/2 - dpToPx2 *0.45f), radius = 100f, color = orange)

        Box(
            modifier = Modifier
                .border(2.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.Black)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.2f),
                            Color.White.copy(alpha = 0.05f)
                        )
                    )
                )
                .blur(30.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .graphicsLayer {

                }
                .size(350.dp, 200.dp)
        ) {
            Circle(Offset(dpToPx, dpToPx2 * 0.1f), color = purple)
            Circle(circleOffset =  Offset(0f, dpToPx2), radius = 200f, color = pink)
            Circle(circleOffset = Offset(dpToPx * 0.4f, 0f), radius = 100f, color = orange)

        }
    }


}




