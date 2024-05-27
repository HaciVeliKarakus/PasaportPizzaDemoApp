package com.hvk.pasaportpizza.ui.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hvk.pasaportpizza.model.Filter
import com.hvk.pasaportpizza.model.FoodCollection
import com.hvk.pasaportpizza.ui.components.DestinationBar


@Composable
fun FeedContent(
    foodCollection: List<FoodCollection>,
    filters: List<Filter>,
    onFoodClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Box {
            FoodCollectionList(
                foodCollection = foodCollection,
                filters = filters,
                onFoodClick = onFoodClick
            )
            DestinationBar()
        }
    }
}


