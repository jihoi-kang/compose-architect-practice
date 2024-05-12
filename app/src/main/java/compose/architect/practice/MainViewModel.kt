package compose.architect.practice

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel : ViewModel()


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val text: String) : MainActivityUiState
}