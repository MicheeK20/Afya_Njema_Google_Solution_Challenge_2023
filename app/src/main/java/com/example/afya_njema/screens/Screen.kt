package com.example.afya_njema

sealed class Screen(val route :String){
    object Home : Screen(route = "welcome_screen")
    object Info : Screen(route = "info_screen")
    object Plan : Screen(route = "plan_screen")
    object PlanList : Screen(route = "plan_list_screen")
    object InfoList : Screen(route = "info_list_screen")
}



