package com.hvk.pasaportpizza.ui.cart


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.hvk.pasaportpizza.model.FoodItem
import com.hvk.pasaportpizza.model.OrderLine
import com.hvk.pasaportpizza.ui.components.FoodImage
import com.hvk.pasaportpizza.ui.components.QuantitySelector
import com.hvk.pasaportpizza.ui.detail.formatPrice

@Composable
fun CartItem(
    orderLine: OrderLine,
    removeFoodItem: (Long) -> Unit,
    decreaseFoodItem: (Long) -> Unit,
    increaseFoodItem: (Long) -> Unit,
    onFoodItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val foodItem = orderLine.foodItem
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onFoodItemClick(foodItem.id) }
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 24.dp)
    ) {
        val (divider, image, name, tag, priceSpacer, price, remove, quantity) = createRefs()
        createVerticalChain(name, tag, priceSpacer, price, chainStyle = ChainStyle.Packed)
        FoodImage(
            imageUrl = foodItem.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = foodItem.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(name) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = remove.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        IconButton(
            onClick = { removeFoodItem(foodItem.id) },
            modifier = Modifier
                .constrainAs(remove) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(top = 12.dp),
        ) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = null)
        }

        Text(
            text = foodItem.tagline,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(tag) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = parent.end,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )

        Spacer(modifier = Modifier
            .height(8.dp)
            .constrainAs(priceSpacer) {
                linkTo(top = tag.bottom, bottom = price.top)
            }
        )
        Text(
            text = formatPrice(foodItem.price),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(price) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = quantity.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        QuantitySelector(
            count = orderLine.count,
            decreaseItemCount = { decreaseFoodItem(foodItem.id) },
            increaseItemCount = { increaseFoodItem(foodItem.id) },
            modifier = Modifier.constrainAs(quantity) {
                baseline.linkTo(price.baseline)
                end.linkTo(parent.end)
            }
        )
        Divider(
            Modifier.constrainAs(divider) {
                linkTo(start = parent.start, end = parent.end)
                top.linkTo(parent.bottom)
            }
        )

    }
}

@Preview
@Composable
private fun Preview() {
    CartItem(
        orderLine = OrderLine(
            foodItem = FoodItem(
                id = 5805,
                name = "Duncan Morrow",
                imageUrl = "https://search.yahoo.com/search?p=solet",
                price = 2267,
                tagline = "tortor",
                tags = setOf()
            ), count = 4519
        ),
        removeFoodItem = {},
        decreaseFoodItem = {},
        increaseFoodItem = {},
        onFoodItemClick = {}

    )
}