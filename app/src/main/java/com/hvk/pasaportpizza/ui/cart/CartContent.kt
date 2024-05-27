package com.hvk.pasaportpizza.ui.cart


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hvk.pasaportpizza.R
import com.hvk.pasaportpizza.model.CollectionType
import com.hvk.pasaportpizza.model.FoodCollection
import com.hvk.pasaportpizza.model.OrderLine
import com.hvk.pasaportpizza.ui.components.FoodCollectionComp
import com.hvk.pasaportpizza.ui.components.SwipeToDisMissItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartContent(
    orderLines: List<OrderLine>,
    removeFoodItem: (Long) -> Unit,
    decreaseFoodItem: (Long) -> Unit,
    increaseFoodItem: (Long) -> Unit,
    inspiredByCart: FoodCollection,
    onFoodItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val resource = LocalContext.current.resources

    val foodCountFormattedString = remember(orderLines.size, resource) {
        resource.getQuantityString(
            R.plurals.cart_order_count,
            orderLines.size,
            orderLines.size
        )
    }
    LazyColumn(
        modifier
    ) {
        item {
            Spacer(
                modifier = Modifier.windowInsetsTopHeight(
                    WindowInsets.statusBars.add(WindowInsets(top = 56.dp))
                )
            )
            Text(
                text = stringResource(id = R.string.cart_order_header, foodCountFormattedString),
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .heightIn(min = 56.dp)
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .wrapContentHeight()
            )
        }
        items(orderLines) { orderLine ->
            SwipeToDisMissItem(
                background = { offsetX ->
                    val backgroundColor = if (offsetX < (-160).dp) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(backgroundColor)
                    )
                }
            ) {
                CartItem(
                    orderLine = orderLine,
                    removeFoodItem = removeFoodItem,
                    decreaseFoodItem = decreaseFoodItem,
                    increaseFoodItem = increaseFoodItem,
                    onFoodItemClick = onFoodItemClick
                )
            }
        }
        item {
            SummaryItem(
                subTotal = orderLines.sumOf { it.foodItem.price * it.count },
                shippingCosts = 369
            )
        }
        item {
            FoodCollectionComp(
                foodCollection = inspiredByCart,
                onFoodClick = onFoodItemClick,
                highlight = false
            )
            Spacer(modifier = Modifier.height(56.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CartContent(
        orderLines = listOf(),
        removeFoodItem = {},
        decreaseFoodItem = {},
        increaseFoodItem = {},
        inspiredByCart = FoodCollection(
            id = 8660,
            name = "Rosetta Montoya",
            snacks = listOf(),
            type = CollectionType.Normal
        ),
        onFoodItemClick = {}
    )
}