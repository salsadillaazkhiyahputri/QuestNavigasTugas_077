package com.example.questnavigastugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi{
    Home,
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController  = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,

            modifier = Modifier.padding(isiRuang)){
            composable (Navigasi.Formulirku.name){
                FormIsian(
                    OnSubmitBtnClick ={
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable (Navigasi.Detail.name){
                TampilData(
                    OnBackClick = {
                        cancelAndBackToFormulirku(navController)
                    },
                )
            }
            composable(Navigasi.Home.name){
                Home(
                    OnNavigateToPendaftaran = {
                        navController.navigate(route = Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirku(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}


