package com.mahi.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahi.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  composeImage(heading = getString(R.string.heading), startingParagraph =getString(R.string.starting_paragraph) , endingParagraph =getString(R.string.ending_paragraph) )
                }
            }
        }
    }
}

@Composable
fun paragraphText(heading: String,startingParagraph:String,endingParagraph: String,modifier: Modifier = Modifier) {
        Column{
            Text(
                text = heading,
                fontSize=24.sp,
                modifier = modifier.padding(16.dp)
            )
            Text(
                text = startingParagraph,
                textAlign=TextAlign.Justify,
                modifier=Modifier.padding(16.dp)

            )
            Text(
                text = endingParagraph,
                textAlign=TextAlign.Justify,
                modifier=Modifier.padding(16.dp)

            )
        }
    }

@Composable
fun composeImage(heading: String,startingParagraph: String,endingParagraph: String,modifier: Modifier=Modifier){
  val image= painterResource(R.drawable.bg_compose_background)
    Column {
            Image(
                painter = image,
                contentDescription = null
            )
            paragraphText(
                heading = heading,
                startingParagraph = startingParagraph,
                endingParagraph = endingParagraph
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeAppTheme {
        composeImage(
            heading = stringResource(id = R.string.heading) , 
            startingParagraph = stringResource(id = R.string.starting_paragraph), 
            endingParagraph = stringResource(id = R.string.ending_paragraph))
    }
}