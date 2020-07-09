package ms.zem.filmescoroutineskoin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.*
import ms.zem.filmescoroutineskoin.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer {filmes ->
            filmes[0]?.let { tv1.text = it.titulo }
            filmes[1]?.let { tv2.text = it.titulo }
            filmes[2]?.let { tv3.text = it.titulo }
        })
        // usando  callBack / Thread
        // viewModel.getFilmes()

        // usando coroutine
        viewModel.getFilmesCoroutines()

    }

}

