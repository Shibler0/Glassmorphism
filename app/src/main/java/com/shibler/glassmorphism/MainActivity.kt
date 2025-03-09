package com.shibler.glassmorphism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shibler.glassmorphism.ui.theme.GlassmorphismTheme
import com.shibler.glassmorphism.ui.theme.backgroundBottom
import com.shibler.glassmorphism.ui.theme.backgroundTop
import com.shibler.glassmorphism.ui.theme.circleGradient
import com.shibler.glassmorphism.ui.theme.orange
import com.shibler.glassmorphism.ui.theme.pink
import com.shibler.glassmorphism.ui.theme.purple

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlassmorphismTheme {

                val windowSizeClass = calculateWindowSizeClass(this)

                when(windowSizeClass.widthSizeClass) {
                    androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Compact -> GLassmorphism2(text = "Compact")
                    androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Medium -> GLassmorphism2(text = "Medium")
                    androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Expanded -> GLassmorphism2(text = "Expanded")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Glassmorphism1() {

    val fontBold= FontFamily(Font(R.font.montserratsemibold))
    val fontMedium = FontFamily(Font(R.font.montserratmedium))

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



        Circle(Offset(widthInPx/2 + dpToPx/2, heightInPx/2 - dpToPx2 * 0.4f + 100f), color = purple)
        Circle(Offset(widthInPx/2 - dpToPx/2, heightInPx/2 + dpToPx2/2 + 100f), radius = 200f, color = pink)
        Circle(Offset(widthInPx/2 - dpToPx * 0.1f, heightInPx/2 - dpToPx2/2 + 100f), radius = 100f, color = orange)

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

        Column(
            modifier = Modifier
                .size(350.dp, 200.dp)
                .padding(top = 30.dp, start = 20.dp, bottom = 50.dp, end = 30.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "MEMBERSHIP", color = Color.White, fontFamily = fontBold, modifier = Modifier.alpha(0.5f), fontSize = 15.sp)

                Image(painter = painterResource(id = R.drawable.mastercard), contentDescription = "mastercard", modifier = Modifier.alpha(0.4f).size(50.dp))
            }


            Text(text = "Jimmy Conroy", color = Color.White, fontFamily = fontMedium, modifier = Modifier.alpha(0.3f), fontSize = 26.sp)
        }


    }

}

@Preview
@Composable
fun GLassmorphism2(text : String = "Hey") {

    val width = LocalConfiguration.current.screenWidthDp.dp
    val density = LocalDensity.current
    val widthInPx = with(density) { width.toPx() }
    val height = LocalConfiguration.current.screenHeightDp.dp
    val heightInPx = with(density) { height.toPx() }

    var position by remember { mutableStateOf(Offset.Zero) }

    var boxSize = IntSize.Zero

    val borderGradient = Brush.linearGradient(
        listOf(Color.Black,Color.White.copy(alpha = 1f), circleGradient),
    )

    val rotationAngle = 10f

    val backgroundGradient = Brush.linearGradient(
        colors = listOf(backgroundBottom, backgroundTop),
    )
    
    val cardGradient = Brush.linearGradient(
        colors = listOf(Color.White.copy(alpha = 0.1f), Color.White.copy(alpha = 0.2f)),
        start = Offset(position.x, position.y),
        end = Offset(position.x + boxSize.width, position.y + boxSize.height)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient),
        contentAlignment = Alignment.Center
    ) {
        Circle2(Offset(widthInPx * 0.3f, heightInPx * 0.8f), 200f, modifier = Modifier.blur(10.dp))

        Circle2(Offset(widthInPx * 0.8f, heightInPx * 0.7f), 600f)

        Donut(Offset(widthInPx * 0.8f, heightInPx * 0.7f))

            /*Box(
                modifier = Modifier
                    .rotate(rotationAngle)
                    .size(300.dp, 200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, borderGradient, RoundedCornerShape(16.dp))
                    .blur(16.dp)
                    .onGloballyPositioned { it ->
                        position = it.positionInWindow()
                        boxSize = it.size
                    }
                    .background(backgroundGradient)
            ) {
                Circle2(Offset((widthInPx * 0.8f) - position.x + 130f, (heightInPx * 0.7f) - position.y - 130f), 600f)
            }*/

        bankCard(
            modifier = Modifier
                .rotate(rotationAngle)
                .size(300.dp, 200.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, borderGradient, RoundedCornerShape(16.dp))
                .blur(0.dp)
                .onGloballyPositioned { it ->
                    position = it.positionInWindow()
                    boxSize = it.size
                }
                .background(backgroundGradient)
                .background(Brush.linearGradient(listOf(Color.White.copy(0.01f), Color.White.copy(0.5f))))
        ) {
            Circle2(Offset((widthInPx * 0.8f) - position.x + 130f, (heightInPx * 0.7f) - position.y - 130f), 600f, modifier = Modifier.blur(16.dp))
        }

        /*bankCard(
            modifier = Modifier
                .offset(x = -20.dp, y = 200.dp)
                .rotate(-10f)
                .size(200.dp, 120.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, borderGradient, RoundedCornerShape(16.dp))
                .blur(0.dp)
                .onGloballyPositioned { it ->
                    position = it.positionInWindow()
                    boxSize = it.size
                }
                .background(backgroundGradient)
                .background(Brush.linearGradient(listOf(Color.White.copy(0.01f), Color.White.copy(0.5f))))
        ) {

        }*/

    }


    Circle2(Offset.Zero, 500f, modifier = Modifier.blur(100.dp))


    Donut(Offset(widthInPx * 0.1f, heightInPx * 0.1f), radius = 50f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 50.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Column(
            modifier = Modifier
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("\uD83D\uDCB0 START SAVING YOUR MONEY", color = Color.Green, fontSize = 10.sp)

            Text("Payments \nhave never \nbeen easier", color = Color.White, fontSize = 40.sp, fontFamily = FontFamily(Font(R.font.montserratsemibold)), lineHeight = 40.sp)
        }

    }

    Text(text, modifier = Modifier.offset(x = 50.dp, y = 50.dp))

}

@Composable
fun bankCard(modifier: Modifier, composable: @Composable () -> Unit) {

    Box(
        modifier = modifier
    ) {

        composable()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.cardlogo), contentDescription = "mastercard", modifier = Modifier.size(30.dp))
            Image(painter = painterResource(id = R.drawable.visalogo), contentDescription = "mastercard", modifier = Modifier.size(50.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("3845 **** **** 1234", color = Color.White, fontSize = 20.sp, fontFamily = FontFamily(Font(R.font.montserratmedium)))
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp, start = 30.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {

            Column {
                Text("Cardholder :", color = Color.White, fontSize = 10.sp, fontFamily = FontFamily(Font(R.font.montserratmedium)))
                Text("Juliette Nichols", color = Color.White, fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.montserratmedium)))
            }


        }

    }


}




