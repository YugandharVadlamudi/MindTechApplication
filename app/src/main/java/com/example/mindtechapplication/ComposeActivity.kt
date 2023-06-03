package com.example.mindtechapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.mindtechapplication.ui.theme.MindTechApplicationTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindTechApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting("Android", context = applicationContext)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context) {
    Column() {
        Text(
            text = "Hello $name!",
            modifier = modifier,
        )
        Button(onClick = {
            showToast(context)
        }, modifier = Modifier.width(100.dp).height(30.dp)) {
            Text(text = context.getString(R.string.app_name))
        }
    }
}

private fun showToast(context: Context) {
    Toast.makeText(context, "a", Toast.LENGTH_SHORT).show()
    createNotificationChannel(context)
    val oneTimeWorkRequestBuilder = OneTimeWorkRequestBuilder<ExampleWorkerClass>().setConstraints(
        workManager(),
    )/*.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)*/.build()
    WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuilder)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MindTechApplicationTheme {
//        Greeting("Android")
    }
}
private fun workManager(): androidx.work.Constraints {
    return androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
}
private fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Name"
        val descriptionText = "Channel Description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("1", name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}