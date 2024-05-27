package com.hvk.pasaportpizza.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.hvk.pasaportpizza.model.FoodRepo

@Composable
fun Feed(
    onFoodClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val foodCollection = remember {
        FoodRepo.getFoods()
    }
    val filters = remember {
        FoodRepo.getFilters()
    }
    FeedContent(
        foodCollection = foodCollection,
        filters = filters,
        onFoodClick = onFoodClick,
        modifier = modifier,
    )

}







