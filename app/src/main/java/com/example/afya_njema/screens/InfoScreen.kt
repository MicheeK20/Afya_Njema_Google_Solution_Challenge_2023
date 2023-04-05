package com.example.afya_njema.screens

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afya_njema.*
import java.io.IOException

var mediaPlayer : MediaPlayer? = null

@Composable
fun displayInfo(
    infoTitle: String,
    infoContent : String,
    infoImageUrl : String,
    navController: NavController
){


    Column(
        modifier = Modifier
            .padding(15.dp)
    ){



        Text(
            text = clickedItemTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        val image = loadImage(url = clickedItemImageUrl, defaultImage = DEFAULT_IMAGE_MIC).value
        image?.let { img ->
            Image(
                bitmap =img.asImageBitmap(),
                contentDescription =" image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),

                contentScale = ContentScale.Crop,)

        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = clickedItemContent,
            textAlign = TextAlign.Justify,


            )
    }




}

@Composable
fun displayPlan(
    infoTitle: String,
    infoContent : String,
    infoImageUrl : String,
    navController: NavController
){


    Column(
        modifier = Modifier
            .padding(15.dp)
    ){



        Text(
            text = infoTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        val image = loadImage(url = infoImageUrl, defaultImage = DEFAULT_IMAGE_MIC).value
        image?.let { img ->
            Image(
                bitmap =img.asImageBitmap(),
                contentDescription =" image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),

                contentScale = ContentScale.Crop,)

        }
        Row(modifier = Modifier.fillMaxSize()) {

            Button(
                onClick = { playAudio() },
                modifier = Modifier.height(2.dp)
            ) {
                Text(text = "Play")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = { pauseAudio() },
            ) {
                Text(text = "Pause")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = infoContent,
            textAlign = TextAlign.Justify,


            )
    }




}


fun pauseAudio() {
    if (mediaPlayer!!.isPlaying){
        mediaPlayer!!.stop()
        mediaPlayer!!.reset()
        mediaPlayer!!.release()
    }

    //Toast.makeText(this,"Audio started playing", Toast.LENGTH_LONG).show()

}

private fun playAudio() {
    val audioURL =clickedItemSoundURL
    mediaPlayer = MediaPlayer()
    mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

    try {
        mediaPlayer!!.setDataSource(audioURL)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()

    }catch (e : IOException){
        e.printStackTrace()

    }
}
