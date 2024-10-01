package com.example.markup_layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.markup_layouts.ui.theme.Markup_layoutsTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Markup_layoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithTextScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImageWithTextScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        // Верхняя часть с изображением, занимает 80% высоты экрана
        Image(
            painter = painterResource(id = R.drawable.fish), // Замените на ваш ресурс изображения
            contentDescription = "Описание изображения",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f) // 80% высоты
        )

        // Нижняя часть с текстом, занимает 20% высоты экрана
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f) // 20% высоты
                .padding(16.dp), // Отступы от краев
            contentAlignment = Alignment.Center // Центрирование текста
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color(0xFFADD8E6)) // Устанавливаем светло-голубой фон
                    .padding(16.dp) // Отступы внутри колонки для текста
            ) {
                Text(
                    text = "Я аксолотль!",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontSize = 23.sp,
                )
                Text(
                    text = "Я отращу себе любую часть тела!",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontSize = 23.sp,
                    lineHeight = 30.sp
                )
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun ImageWithTextScreenPreview() {
    Markup_layoutsTheme {
        ImageWithTextScreen()
    }
}
