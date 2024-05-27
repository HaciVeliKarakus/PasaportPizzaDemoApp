package com.hvk.pasaportpizza.ui.onboarding


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hvk.pasaportpizza.model.OnBoardingItem
import com.hvk.pasaportpizza.ui.Graph
import com.hvk.pasaportpizza.ui.theme.pacificoFont
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingDetail(
    modifier: Modifier = Modifier,
    onBoardingItem: OnBoardingItem,
    pagerState: PagerState,
    onBtnClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OnBoardingImageView(imageRes = onBoardingItem.imageRes)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = onBoardingItem.titleRes),
            fontWeight = FontWeight.Bold,
            fontFamily = pacificoFont,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = onBoardingItem.textRes),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iterations ->
                val color = if (pagerState.currentPage == iterations)
                    MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.primary.copy(.5f)
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )

            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(visible = pagerState.currentPage == pagerState.pageCount - 1) {
            Button(
                onClick = {
                    onBtnClick()
                    scope.launch {
                        Graph.dataStoreManager.saveOnBoardingState(true)
                    }
                }
            ) {
                Text(text = "Get Started")
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }

    }
}

