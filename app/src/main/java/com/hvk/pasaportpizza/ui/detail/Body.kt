package com.hvk.pasaportpizza.ui.detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hvk.pasaportpizza.R
import com.hvk.pasaportpizza.model.FoodCollection
import com.hvk.pasaportpizza.ui.components.FoodCollectionComp

@Composable
fun Body(
    related: List<FoodCollection>,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(modifier = Modifier.height(GradientScroll))
            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(modifier = Modifier.height(ImageOverlap))
                    Spacer(modifier = Modifier.height(TitleHeight))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Details",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Hzpadding
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    var seeMore by remember {
                        mutableStateOf(true)
                    }
                    Text(
                        text = stringResource(id = R.string.detail_placeholder),
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = if (seeMore) 5 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Hzpadding
                    )
                    val textBtn = if (seeMore) "See More" else "See less"
                    Text(
                        text = textBtn,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .heightIn(20.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .clickable {
                                seeMore = !seeMore
                            }
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Hzpadding
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(id = R.string.ingredients_list),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Hzpadding
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    related.forEach { foodCollection ->
                        key(foodCollection.id) {
                            FoodCollectionComp(
                                foodCollection = foodCollection,
                                onFoodClick = {},
                                highlight = false
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding()
                            .height(8.dp)
                    )
                }
            }
        }
    }

}
