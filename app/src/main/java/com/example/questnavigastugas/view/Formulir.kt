package com.example.questnavigastugas.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    OnSubmitBtnClick: () -> Unit,
    modifier: Modifier = Modifier){

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var selectedJK by remember { mutableStateOf("") }
    var selectedStatusKawin by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")
    val statusKawinOptions = listOf("Janda", "Lajang", "Duda")

    val OrangeHeader = Color(0xFFFF8A65)
    val OrangeSubmit = Color(0xFFFF7043)
}
