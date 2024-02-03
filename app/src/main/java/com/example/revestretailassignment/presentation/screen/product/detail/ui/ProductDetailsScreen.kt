package com.example.revestretailassignment.presentation.screen.product.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.presentation.custom_view.AppToolBar
import com.example.revestretailassignment.presentation.custom_view.KeyValuePair
import com.example.revestretailassignment.presentation.custom_view.RRTextView
import com.example.revestretailassignment.presentation.custom_view.RRViewPager
import com.example.revestretailassignment.presentation.custom_view.ShowLoaderIndicator
import com.example.revestretailassignment.presentation.custom_view.getRatingColor
import com.example.revestretailassignment.presentation.custom_view.getStockColor
import com.example.revestretailassignment.presentation.screen.product.detail.ProductDetailViewState
import com.example.revestretailassignment.presentation.screen.product.detail.viewmodel.ProductDetailsViewModel
import com.example.revestretailassignment.presentation.screen.product.list.ui.ShowErrorMessage
import com.example.revestretailassignment.ui.theme.PurpleGrey80
import com.example.revestretailassignment.ui.theme.primary
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    navController: NavHostController,
    title: String,
    productId: Int,
    viewModel: ProductDetailsViewModel = koinViewModel()
) {
    val viewState = viewModel.viewState
    LaunchedEffect(true) {
        viewModel.callProductDetailApi(productId)
    }

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(PurpleGrey80)) {
        Scaffold(
            topBar = {
                AppToolBar(title = title, onBackIconClick = {
                    navController.popBackStack()
                })
            },
            content = {
                Column(
                    modifier = Modifier.padding(
                        top = it.calculateTopPadding(),
                        bottom = 16.dp
                    )
                ) {
                    if (viewState.showLoadingIndicator.value) {
                        ShowLoaderIndicator()
                    } else {
                        if (viewState.isApiSuccess.value)
                            ProductDetailPage(viewState)
                        else
                            ShowErrorMessage()
                    }

                }
            }
        )
    }
}

@Composable
fun ProductDetailPage(viewState: ProductDetailViewState) {
    BannerSection(viewState.product)
    Divider(modifier = Modifier.heightIn(1.dp))
    Spacer(modifier = Modifier.height(8.dp))
    DescriptionSection(viewState.product)
}

@Composable
fun DescriptionSection(product: Product) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val stock = getStockColor(product.stock)

            KeyValuePair(
                key = product.brand.titleCase(),
                value = product.title,
                keyColor = primary,
                valueColor = primary
            )
            RRTextView(
                text = stock.second,
                color = stock.first
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        RRTextView(text = product.category.titleCase())
        Spacer(modifier = Modifier.height(8.dp))
        RRTextView(text = product.description.titleCase())
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            KeyValuePair(key = "Price", value = "Rs. ${product.price}")
            KeyValuePair(
                key = "Rating",
                keyColor = Color.Black,
                value = "${product.rating}",
                valueColor = getRatingColor(product.rating)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        RRTextView(text = "Offer ${product.discountPercentage}% Off")
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun BannerSection(product: Product) {
    RRViewPager(images = product.images)
}


fun String.titleCase(): String {
    return this.replaceFirstChar { char ->
        char.titlecase()
    }
}

