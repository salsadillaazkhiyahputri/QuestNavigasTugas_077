package com.example.questnavigastugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onNavigateToPendaftaran: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFFFF3E0))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Selamat Datang",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5D4037),
                modifier = Modifier.padding(bottom = 32.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.senja),
                contentDescription = "Logo Aplikasi",
                modifier = Modifier
                    .size(450.dp)
                    .padding(bottom = 24.dp)
            )


            Text(
                text = "Salsa Dilla Azkhiyah Putri",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4E342E),
                modifier = Modifier.padding(top = 8.dp)
            )


            Text(
                text = "20230140077",
                fontSize = 20.sp,
                color = Color(0xFF6D4C41),
                modifier = Modifier.padding(bottom = 40.dp)
            )


            Button(
                onClick = onNavigateToPendaftaran,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7043)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text(
                    text = "Submit",
                    fontSize = 21.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MaterialTheme {
        Home(onNavigateToPendaftaran = {})
    }
}
