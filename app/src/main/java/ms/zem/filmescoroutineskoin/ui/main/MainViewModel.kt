package ms.zem.filmescoroutineskoin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepositoryInterface,
    private val navController: NavController
) : ViewModel() {

    private val filmesMutable = MutableLiveData<List<Filme>>()
    val filmesLiveData: LiveData<List<Filme>> = filmesMutable

    fun getFilmes(){
        repository.getFilmes {filmes ->
            filmesMutable.postValue(filmes)
        }
    }

    fun getFilmesCoroutines(){
        CoroutineScope(Dispatchers.Main).launch {
            val filmes = withContext(Dispatchers.Default) {
                repository.getFilmesCoroutines()
            }
            filmesMutable.value = filmes
        }
    }

    // não precisa mais por causa co koin
//    class MainViewModelFactory(private val repository: MainRepositoryInterface): ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return MainViewModel(repository) as T
//        }
//    }

}