package com.example.afya_njema.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.afya_njema.*





@Composable
fun scrollingRow(category: String, numbers: MutableList<String>, route: String) {
    Column() {
        Row() {
            Text(
                text = category
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())

        ) {
            for (i in numbers.indices)

                Column(modifier = Modifier
                    .height(200.dp)
                    .width(150.dp)
                    .padding(5.dp)
                    .clickable {
                        navController.navigate(route)
                        clickedItemSoundURL = itemSoundURLList[i]
                        clickedItemImageUrl = itemImageURLList[i]
                        clickedItemTitle = itemTitleList[i]
                        clickedItemContent = itemContentList[i]



                    }
            ) {
            val image = loadImage(url = itemImageURLList[i], defaultImage = DEFAULT_IMAGE_MIC).value
            image?.let { img ->
                Image(
                    bitmap =img.asImageBitmap(),
                    contentDescription =" image",
                    modifier = Modifier
                        .width(130.dp),

                    contentScale = ContentScale.Crop,)
                Text(
                    text = itemTitleList[i]

                )
            }
        }

            }
        }
    }

@Composable
fun scrollingColumn(categories:MutableList<String>, route: String){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())

    ) {
        for (i in categories.indices)
            scrollingRow(categories[i],numbers, route)

    }


}


