package com.example.questnavigastugas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 50.dp),
                title = {
                    Text(
                        text = "Formulir Pendaftaran",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeHeader
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ){
        paddingValues ->
        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "NAMA LENGKAP",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Isian nama lengkap") },
                    onValueChange = { textNama = it }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                Column(modifier = Modifier.fillMaxWidth()) {
                    genderOptions.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = selectedJK == item,
                                    onClick = { selectedJK = item })
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedJK == item,
                                onClick = { selectedJK = item })
                            Text(item, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                Column(modifier = Modifier.fillMaxWidth()) {
                    statusKawinOptions.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = selectedStatusKawin == item,
                                    onClick = { selectedStatusKawin = item })
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedStatusKawin == item,
                                onClick = { selectedStatusKawin = item })
                            Text(item, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "ALAMAT", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Alamat") },
                    onValueChange = { textAlamat = it }
                )
                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    modifier = Modifier.fillMaxWidth().height(45.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSubmit),
                    enabled = textNama.isNotEmpty() && selectedJK.isNotEmpty() && selectedStatusKawin.isNotEmpty() && textAlamat.isNotEmpty(),
                    onClick = OnSubmitBtnClick
                ) {
                    Text("Submit")
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }

}
