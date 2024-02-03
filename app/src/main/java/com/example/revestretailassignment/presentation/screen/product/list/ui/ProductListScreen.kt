package com.example.revestretailassignment.presentation.screen.product.list.ui

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.revestretailassignment.application.AppConstant
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.getEmptyProduct
import com.example.revestretailassignment.presentation.custom_view.AppToolBar
import com.example.revestretailassignment.presentation.custom_view.KeyValuePair
import com.example.revestretailassignment.presentation.custom_view.RRImageView
import com.example.revestretailassignment.presentation.custom_view.RRTextView
import com.example.revestretailassignment.presentation.custom_view.ShowLoaderIndicator
import com.example.revestretailassignment.presentation.custom_view.getStockColor
import com.example.revestretailassignment.presentation.navigation.AppDestinations
import com.example.revestretailassignment.presentation.screen.product.detail.ui.titleCase
import com.example.revestretailassignment.presentation.screen.product.list.ProductListViewState
import com.example.revestretailassignment.presentation.screen.product.list.viewmodel.ProductListViewModel
import com.example.revestretailassignment.ui.theme.PurpleGrey80
import com.example.revestretailassignment.ui.theme.primary
import org.koin.androidx.compose.koinViewModel

/*
*Author : Awadhesh Singh
*Product list screen
* To show the List of Products getting from Api Dummy Api
* */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductListViewModel = koinViewModel()
) {
    val viewState = viewModel.viewState
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey80)
    ) {
        Scaffold(topBar = {
            AppToolBar(
                title = "Products",
                showNavigationIcon = false
            )
        }, content = {
            Column(
                modifier = Modifier.padding(
                    top = it.calculateTopPadding()
                )
            ) {
                if (viewState.showLoadingIndicator.value) {
                    ShowLoaderIndicator()
                } else {
                    if (viewState.isApiSuccess.value) {
                        ProductListPage(
                            viewState = viewState,
                            onItemClick = { product ->
                                navigation(product, navController)
                            })
                    } else {
                        ShowErrorMessage()
                    }
                }
            }
        })
    }

}

@Composable
fun ShowErrorMessage() {
//TODO : Implement the Ui for Error
}

@Composable
fun ProductListPage(
    viewState: ProductListViewState,
    onItemClick: (item: Product) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(viewState.products) { _, item ->
            ProductItem(item) {
                onItemClick(item)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    product: Product, onItemClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        onClick = onItemClick
    ) {
        RRImageView(
            url = product.images[0],
            contentDescription = "Product Image"
        )
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Divider(
                modifier = Modifier
                    .height(2.dp)
                    .background(primary)
            ) //Here Divider to indicate the height of Image
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
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

            KeyValuePair(
                key = "Price",
                value = "Rs. ${product.price}"
            )
            RRTextView(text = product.description)
        }
    }
}

private fun navigation(it: Product, navController: NavHostController) {
    val bundle = Bundle()
    navController.currentBackStackEntry?.let { current ->
        bundle.putInt(AppConstant.PRODUCT_ID_KEY, it.id)
        bundle.putString(AppConstant.PRODUCT_TITLE_KEY, it.title)
        val args = current.savedStateHandle
        args[AppConstant.DATA_KEY] = bundle
    }

    navController.navigate(route = AppDestinations.PRODUCT_DETAIL_SCREEN)
}


@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        getEmptyProduct()
    )
}