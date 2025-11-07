package com.example.questnavigastugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas.view.FormIsian
import com.example.questnavigastugas.view.Home

enum class Navigasi {

    Home,
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                FormIsian (
                    //pilihanJK = JenisK.map { id -> konteks.resources.getString}
                    onSubmitBtnClick ={
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData(
                    onBackClick = {
                        cancelAndBackToFormulirku(navController)
                    },
                    onHomeClick = {
                        navController.navigate(Navigasi.Home.name)
                    }
                    //}
                )
            }
            composable(route = Navigasi.Home.name) {
                Home(
                    onNavigateToPendaftaran = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}

@Composable
fun TampilData(onBackClick: () -> Unit, onHomeClick: () -> Unit) {
    TODO("Not yet implemented")
}


private fun cancelAndBackToFormulirku(
    navController:NavHostController
){
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}