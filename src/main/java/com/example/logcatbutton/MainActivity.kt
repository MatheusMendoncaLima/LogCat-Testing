package com.example.logcatbutton

import com.example.logcatbutton.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                    Surface(Modifier.padding(innerPadding)) {
                        var text by remember { mutableStateOf("") }
                        MainScreen(
                            { Log.d("Debug", "Aluno "+text+" tirou MB") },
                            { Log.i("Info", "Aluno "+text+" tirou B") },
                            { Log.w("Warning", "Aluno "+text+" tirou R") },
                            { Log.w("Error", "Aluno "+text+" tirou I") },
                            text,
                            { li -> text=li })


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
    onClickButtonDebug: () -> Unit = {},
    onClickButtonInfo: () -> Unit = {},
    onClickButtonWarning: () -> Unit = {},
    onClickButtonError: () -> Unit = {},
    textFieldText: String = "",
    textFieldOnValueChange: (String) -> Unit = {}
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth(0.95f), Arrangement.SpaceEvenly) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(R.drawable.icon), contentDescription = "" )
            }
            Spacer(Modifier.padding(bottom = 50.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text("Banco de dados de notas")
            }
            Spacer(Modifier.padding(bottom = 50.dp))
            Row {
                OutlinedTextField(
                    value = textFieldText,
                    onValueChange = textFieldOnValueChange,
                    label = { Text("Insira Aluno") },
                    modifier = Modifier.fillMaxWidth())
            }
            Spacer(Modifier.padding(bottom = 50.dp))
            Row {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClickButtonDebug,
                    colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary)
                ) { Text("MB") }
            }
            Row {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClickButtonInfo,
                    colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary)
                ) { Text("B") }
            }
            Row {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClickButtonWarning,
                    colors = ButtonDefaults.buttonColors(containerColor = colorScheme.tertiary)
                ) { Text("R") }
            }
            Row {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClickButtonError,
                    colors = ButtonDefaults.buttonColors(containerColor = colorScheme.error)
                ) { Text("I") }
            }
        }
    }

}