package ir.husseinrasti.presentation.card

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ir.husseinrasti.presentation.R
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.extensions.*
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : BaseFragment() {

    private val viewModel: CardViewModel by viewModels()

    override fun getLayout(): Int = R.layout.fragment_card

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getRandomCard()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()

        btnTry.setOnClickListener {
            viewModel.getRandomCard()
        }
    }

    private fun setupViewModel() {
        viewModel.randomCard.observeResult(this) {
            txtCard.text = "$it"
        }
    }

}