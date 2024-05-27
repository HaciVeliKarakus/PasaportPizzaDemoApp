package com.hvk.pasaportpizza.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingImageView(
    modifier: Modifier = Modifier,
    imageRes: Int
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .heightIn(max = 300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .graphicsLayer { alpha = 0.6f }
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            Pair(0.8f, Color.Transparent), Pair(1f, Color.White)
                        )
                    )
                )
        )
    }
}
