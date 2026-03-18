package com.example.logcatbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logcatbutton.ui.theme.LogCatButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogCatButtonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(Modifier.padding(innerPadding)){
                    MainScreen({ Log.d("Debug", "msg de debug")}, {Log.i("Info", "msg de info")}, {Log.w("Warning", "msg de warning")}, {Log.w("Error", "msg de erro")})


                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_5", showSystemUi = true)
@Composable
fun GreetingPreview() {
    LogCatButtonTheme {
        MainScreen()

    }
}

@Composable
fun MainScreen(
    onClickButtonDebug : () -> Unit = {},
    onClickButtonInfo : () -> Unit = {},
    onClickButtonWarning : () -> Unit = {},
    onClickButtonError : () -> Unit = {},
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(modifier = Modifier.fillMaxWidth(0.95f), Arrangement.SpaceEvenly) {
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = onClickButtonDebug,  colors = ButtonDefaults.buttonColors(containerColor =  colorScheme.primary)) { Text("Debug") }
        }
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = onClickButtonInfo,  colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary)) { Text("Info") }
        }
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = onClickButtonWarning,  colors = ButtonDefaults.buttonColors(containerColor = colorScheme.tertiary)) { Text("Warning") }
        }
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = onClickButtonError,  colors = ButtonDefaults.buttonColors(containerColor = colorScheme.error)) { Text("Error") }
        }
    }
    }

}