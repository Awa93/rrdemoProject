package com.example.revestretailassignment.presentation.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.revestretailassignment.application.AppConstant
import com.example.revestretailassignment.presentation.screen.product.detail.ui.ProductDetailsScreen
import com.example.revestretailassignment.presentation.screen.product.list.ui.ProductListScreen

@Composable
fun RRNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppDestinations.PRODUCT_NAVIGATION) {
        navigation(
            startDestination = AppDestinations.PRODUCT_LIST_SCREEN,
            route = AppDestinations.PRODUCT_NAVIGATION
        ) {
            productsNavigation(navController = navController, startDestination = AppDestinations.PRODUCT_LIST_SCREEN)
        }

    }

}

fun NavGraphBuilder.productsNavigation(
    navController: NavHostController,
    startDestination: String
) {
    composable(startDestination) {
        ProductListScreen(navController)
    }

    composable(AppDestinations.PRODUCT_DETAIL_SCREEN) {

        val backStackEntry =  navController.previousBackStackEntry
        val bundle = backStackEntry?.savedStateHandle?.get<Bundle>(AppConstant.DATA_KEY)
        val title =  bundle?.getString(AppConstant.PRODUCT_TITLE_KEY) ?: "UnTitled Product"
        val id  = bundle?.getInt(AppConstant.PRODUCT_ID_KEY) ?: -1
            ProductDetailsScreen(navController = navController, title = title, productId =  id)
    }

}