package az.edu.bhos.l9_di_demo

import retrofit2.http.GET

class GithubRemoteDataSource(
    private val service: GitHubService
) {
    suspend fun getUsers(): List<User> {
        return service.getAllUsers()
    }
}

interface GitHubService {
    @GET("users")
    suspend fun getAllUsers(): List<User>
}