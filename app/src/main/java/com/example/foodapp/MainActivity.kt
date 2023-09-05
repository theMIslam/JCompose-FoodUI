package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    TopAppBar(title = {
                        Text(text = "FoodApp")
                    })

                    showFoodList(foodList)
                }
            }
        }
    }
}

@Composable
fun showFoodList(foodList: List<Food>) {
    LazyColumn {
        items(foodList) {
            FoodCard(it, Modifier.padding(16.dp))
        }
    }
}

@Composable
fun FoodCard(food: Food, modifier: Modifier) {
    Surface(shape = RoundedCornerShape(8.dp), shadowElevation = 8.dp, modifier = Modifier) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = food.imageResource), contentDescription = "food",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = food.title, style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 1.dp))

                Text(text = food.title, style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 1.dp))
            }
        }
    }
}