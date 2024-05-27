package com.hvk.pasaportpizza.ui.detail

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.hvk.pasaportpizza.ui.components.FoodImage

@Composable
fun Image(
    imageUrl: String,
    scrollProvider: () -> Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }
    CollapsingImageLayout(
        collapseFractionProvider = collapseFractionProvider,
        modifier = Hzpadding.then(Modifier.statusBarsPadding())
    ) {
        FoodImage(imageUrl = imageUrl, contentDescription = null)
    }
}