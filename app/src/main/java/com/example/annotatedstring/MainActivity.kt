package com.example.annotatedstring

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.annotatedstring.ui.theme.AnnotatedStringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(Modifier.padding(top = 45.dp)) {
                val annotatedString = buildAnnotatedString {
                    append("Нажимать ")
                    withLink(
                        link = LinkAnnotation.Clickable(
                            tag = "Second",
                            linkInteractionListener = {
                                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                            },
                            styles = TextLinkStyles(SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline))
                        )
                    ) {
                        append("Сюда")
                    }
                }
                Text(text = annotatedString)
            }

        }
    }
}