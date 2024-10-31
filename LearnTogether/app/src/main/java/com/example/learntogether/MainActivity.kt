package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tutorial(
                        banner = painterResource(R.drawable.bg_compose_background),
                        title = stringResource(R.string.jetpack_compose_tutorial_title),
                        description = stringResource(R.string.jetpack_compose_tutorial_description),
                        notes = stringResource(R.string.jetpack_compose_tutorial_notes),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Tutorial(
    banner: Painter,
    title: String,
    description: String,
    notes: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TutorialBanner(banner, modifier)
        Column(modifier = modifier.verticalScroll(state = rememberScrollState())) {
            TutorialTitle(title, modifier)
            TutorialDescription(description, modifier)
            TutorialNotes(notes, modifier)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TutorialPreview() {
    val banner = painterResource(R.drawable.bg_compose_background)
    val title = stringResource(R.string.jetpack_compose_tutorial_title)
    val description = stringResource(R.string.jetpack_compose_tutorial_description)
    val notes = stringResource(R.string.jetpack_compose_tutorial_notes)

    LearnTogetherTheme {
        Tutorial(
            banner = banner, title = title, description = description, notes = notes
        )
    }
}

@Composable
fun TutorialBanner(banner: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = banner, contentDescription = null, modifier = modifier.fillMaxWidth()
    )
}

@Composable
@Preview(showBackground = true)
fun TutorialBannerPreview() {
    LearnTogetherTheme {
        TutorialBanner(banner = painterResource(R.drawable.bg_compose_background))
    }
}

@Composable
fun TutorialTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title, fontSize = 24.sp, modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TutorialTitlePreview() {
    LearnTogetherTheme {
        TutorialTitle(stringResource(R.string.jetpack_compose_tutorial_title))
    }
}

@Composable
fun TutorialDescription(description: String, modifier: Modifier = Modifier) {
    Text(text = description, textAlign = TextAlign.Justify, modifier = modifier.padding(16.dp))
}

@Composable
@Preview(showBackground = true)
fun TutorialDescriptionPreview() {
    LearnTogetherTheme {
        TutorialDescription(description = stringResource(R.string.jetpack_compose_tutorial_description))
    }
}

@Composable
fun TutorialNotes(notes: String, modifier: Modifier = Modifier) {
    Text(
        text = notes, textAlign = TextAlign.Justify, modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TutorialNotesPreview() {
    LearnTogetherTheme { TutorialNotes(notes = stringResource(R.string.jetpack_compose_tutorial_notes)) }
}