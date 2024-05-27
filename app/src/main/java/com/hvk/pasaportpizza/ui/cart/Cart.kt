package com.hvk.pasaportpizza.ui.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hvk.pasaportpizza.model.FoodCollection
import com.hvk.pasaportpizza.model.FoodRepo
import com.hvk.pasaportpizza.model.OrderLine
import com.hvk.pasaportpizza.ui.components.DestinationBar

@Composable
fun Cart(
    onFoodItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = viewModel()
) {
    val orderLines by viewModel.orderLines.collectAsStateWithLifecycle()
    val inspiredByCart = remember {
        FoodRepo.getInspiredByCart()
    }
    Scaffold(modifier) { paddingValues ->
        Cart(
            orderLine = orderLines,
            removeFoodItem = viewModel::removeFoodItem,
            decreaseFoodItem = viewModel::decreaseFoodCount,
            increaseFoodItem = viewModel::increaseFoodCount,
            inspiredByCart = inspiredByCart,
            onFoodItemClick = onFoodItemClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun Cart(
    orderLine: List<OrderLine>,
    removeFoodItem: (Long) -> Unit,
    decreaseFoodItem: (Long) -> Unit,
    increaseFoodItem: (Long) -> Unit,
    inspiredByCart: FoodCollection,
    onFoodItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Box {
            CartContent(
                orderLines = orderLine,
                removeFoodItem = removeFoodItem,
                decreaseFoodItem = decreaseFoodItem,
                increaseFoodItem = increaseFoodItem,
                inspiredByCart = inspiredByCart,
                onFoodItemClick = onFoodItemClick,
                modifier = Modifier.align(Alignment.TopCenter)
            )
            DestinationBar(
                modifier = Modifier.align(Alignment.TopCenter)
            )
            CheckOutBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Preview
@Composable
private fun Card1() {
    Cart(onFoodItemClick = {})
}


@Preview
@Composable
private fun Card2() {
    Cart(orderLine = listOf(), removeFoodItem = {}, decreaseFoodItem = {},
        increaseFoodItem = {},
        inspiredByCart = FoodCollection(123L, "preview", listOf()),
        onFoodItemClick = {}
    )
}













