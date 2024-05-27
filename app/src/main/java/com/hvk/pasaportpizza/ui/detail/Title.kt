package com.hvk.pasaportpizza.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hvk.pasaportpizza.model.FoodItem

@Composable
fun Title(
    foodItem: FoodItem,
    scrollProvider: () -> Int
) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = foodItem.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Hzpadding
        )
        Text(
            text = foodItem.tagline,
            style = MaterialTheme.typography.displayMedium,
            modifier = Hzpadding,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = formatPrice(foodItem.price),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Hzpadding
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

}
