package az.edu.bhos.l9_di_demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface GithubLocalDataSource {
    fun getUsersLiveData(): LiveData<List<User>>
    fun updateUsers(list: List<User>)

}

class GithubLocalDataSourceImpl: GithubLocalDataSource {
    private val _usersData: MutableLiveData<List<User>> = MutableLiveData()

    override fun getUsersLiveData(): LiveData<List<User>> {
        return _usersData
    }

    override fun updateUsers(list: List<User>) {
        _usersData.postValue(list)
    }
}