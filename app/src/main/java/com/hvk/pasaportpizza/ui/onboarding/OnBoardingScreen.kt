package com.hvk.pasaportpizza.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hvk.pasaportpizza.R
import com.hvk.pasaportpizza.model.OnBoardingItem
import com.hvk.pasaportpizza.model.onBoardingItemList
import com.hvk.pasaportpizza.ui.Graph
import com.hvk.pasaportpizza.ui.theme.pacificoFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onBtnClick: () -> Unit) {
    val onboardPages = onBoardingItemList
    val pagerState = rememberPagerState(pageCount = { onboardPages.size })
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .animateContentSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.decorator_1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(37.dp, 300.dp),
                        alignment = Alignment.TopStart
                    )
                    OnBoardingDetail(
                        onBoardingItem = onboardPages[pagerState.currentPage],
                        pagerState = pagerState,
                        onBtnClick = onBtnClick,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.decorator_2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(37.dp, 300.dp),
                        alignment = Alignment.BottomEnd
                    )
                }
            }
        }
    }

}
















