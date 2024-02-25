package az.edu.bhos.l9_di_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.observeUser().observe(this) {
            println(it)
        }
    }
}


@Serializable
data class User(
    val id: Int,
    val name: String,
    val avatar: String,
    val createdAt: String
)