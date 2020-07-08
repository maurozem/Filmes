package ms.zem.filmescoroutineskoin.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit){
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listFilmes()
            )
        }).start()
    }

    private fun listFilmes(): List<Filme> {
        return listOf(
            Filme(1, "titulo 01"),
            Filme(2, "titulo 02"),
            Filme(3, "titulo 03")
        )
    }


    suspend fun getFilmesCoroutines(): List<Filme>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listFilmes()
        }
    }
}