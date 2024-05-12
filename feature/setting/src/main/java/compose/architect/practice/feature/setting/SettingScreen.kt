package compose.architect.practice.feature.setting

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingScreen() {
    Text(text = "Setting")
}

@Preview(showBackground = true)
@Composable
private fun SettingScreenPreview() {
    MaterialTheme {
        SettingScreen()
    }
}