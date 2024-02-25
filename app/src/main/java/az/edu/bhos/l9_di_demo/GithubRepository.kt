package az.edu.bhos.l9_di_demo

import androidx.lifecycle.LiveData

class GithubRepository(
    private val localDataSource: GithubLocalDataSource,
    private val remoteDataSource: GithubRemoteDataSource
) {

    suspend fun syncUsers() {
        val users = remoteDataSource.getUsers()
        localDataSource.updateUsers(users)
    }

    fun getUsers(): LiveData<List<User>> {
        return localDataSource.getUsersLiveData()
    }
}