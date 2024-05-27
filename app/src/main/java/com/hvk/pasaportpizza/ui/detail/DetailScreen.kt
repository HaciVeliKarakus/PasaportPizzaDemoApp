package com.hvk.pasaportpizza.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hvk.pasaportpizza.model.FoodRepo

val BottomBarHeight = 56.dp
val TitleHeight = 128.dp
val GradientScroll = 180.dp
val ImageOverlap = 115.dp
val MinTitleOffset = 56.dp
val MinImageOffset = 12.dp
val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
val ExpandedImageSize = 300.dp
val CollapsedImageSize = 150.dp
val Hzpadding = Modifier.padding(horizontal = 24.dp)


@Composable
fun FoodDetail(
    foodId: Long,
    upPress: () -> Unit
) {
    val food = remember(key1 = foodId) {
        FoodRepo.getFoodById(foodId)
    }
    val related = remember(key1 = foodId) {
        FoodRepo.getRelated(foodId)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(related = related, scroll = scroll)
        Title(foodItem = food) {
            scroll.value
        }
        Image(food.imageUrl) { scroll.value }
        Up(upPress)
        DetailBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    FoodDetail(1L) { }
}











