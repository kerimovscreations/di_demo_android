package az.edu.bhos.l9_di_demo

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                appModule
            )
        }
    }
}