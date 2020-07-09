package ms.zem.filmescoroutineskoin.di

import androidx.navigation.NavController
import ms.zem.filmescoroutineskoin.ui.main.MainRepository
import ms.zem.filmescoroutineskoin.ui.main.MainRepositoryInterface
import ms.zem.filmescoroutineskoin.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val mainModule : Module = module {
    single<MainRepositoryInterface> {
        MainRepository()
    }
    viewModel { (navController: NavController) ->
        MainViewModel(
            repository = get(),
            navController = navController
        )
    }
}