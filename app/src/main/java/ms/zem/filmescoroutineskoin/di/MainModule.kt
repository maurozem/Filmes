package ms.zem.filmescoroutineskoin.di

import ms.zem.filmescoroutineskoin.ui.main.MainRepository
import ms.zem.filmescoroutineskoin.ui.main.MainRepositoryInterface
import ms.zem.filmescoroutineskoin.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val mainModule : Module = module {
    single<MainRepositoryInterface> { MainRepository() }
    viewModel { MainViewModel(repository = get()) }
}