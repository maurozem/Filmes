package ms.zem.filmescoroutineskoin.ui.main

interface MainRepositoryInterface {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit)
    suspend fun getFilmesCoroutines(): List<Filme>

}