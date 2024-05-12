package compose.architect.practice.core.designsystem.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.architect.practice.core.designsystem.theme.ArchitectPracticeTheme

@Composable
fun PracticeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: String,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(text = content)
    }
}

@Preview
@Composable
fun PracticeButtonPreview() {
    ArchitectPracticeTheme {
        PracticeButton(
            onClick = {},
            content = "Hello Button",
        )
    }
}