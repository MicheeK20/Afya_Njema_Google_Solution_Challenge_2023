package com.example.afya_njema.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afya_njema.Screen

val welcomeTitle ="Welcome to Afya Njema !"
val welcomeSubtitle ="Getting reliable info about health and well-being and building health-friendly habits."

@Composable
fun WelcomeScreen(navController : NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        contentAlignment = Alignment.Center
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)

        ) {
            Box() {
                Text(
                    text = welcomeTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box() {
                Text(
                    text = welcomeSubtitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }


            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.fillMaxSize()) {
                Button(
                    modifier = Modifier
                        .padding(5.dp),
                    onClick = {
                        navController.navigate(route = Screen.InfoList.route)
                    },
                ) {
                    Text(
                        text = "Infos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }

                Button(
                    modifier = Modifier
                        .padding(5.dp),
                    onClick = {
                        navController.navigate(route = Screen.PlanList.route )


                    },
                ) {
                    Text(
                        text = "Plans",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }

        }
    }
}