package az.edu.bhos.l9_di_demo

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val appModule = module {
    single<GithubLocalDataSource> { GithubLocalDataSourceImpl() }

    single<Retrofit> {
        val base_url = "https://62961db375c34f1f3b299286.mockapi.io/"
        val contentType = MediaType.parse("application/json")!!

        val client: OkHttpClient

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .client(client)
            .baseUrl(base_url)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    factory<GitHubService> {
        get<Retrofit>().create()
    }

    factory { GithubRemoteDataSource(
        service = get()
    ) }

    factory {
        GithubRepository(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(get())
    }
}