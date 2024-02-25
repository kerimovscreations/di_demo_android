package az.edu.bhos.l9_di_demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: GithubRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            repo.syncUsers()
        }
    }

    fun observeUser(): LiveData<List<User>> {
        return repo.getUsers()
    }
}