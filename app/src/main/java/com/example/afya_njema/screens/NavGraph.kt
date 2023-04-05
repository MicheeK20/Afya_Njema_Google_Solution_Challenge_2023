package com.example.afya_njema

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afya_njema.screens.*
import com.google.accompanist.pager.ExperimentalPagerApi



@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            WelcomeScreen(navController)
        }

        composable(
            route = Screen.PlanList.route
        ){
            scrollingColumn(categories,route = Screen.PlanList.route)
        }

        composable(
            route = Screen.InfoList.route
        ){
            scrollingColumn(categories, route = Screen.InfoList.route)
        }

        composable(
            route = Screen.Plan.route
        ){
            displayPlan(clickedItemTitle,
                clickedItemContent ,
                clickedItemImageUrl,
                navController
            )
        }
        composable(
            route = Screen.Info.route
        ){
            displayInfo(clickedItemTitle,
                clickedItemContent ,
                clickedItemImageUrl,
                navController)
        }

    }
}

