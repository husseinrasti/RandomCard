package ir.husseinrasti.presentation.card

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ir.husseinrasti.presentation.R
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.ResultError
import ir.husseinrasti.presentation.base.extensions.*
import ir.husseinrasti.presentation.databinding.FragmentCardBinding
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : BaseFragment() {

    private val viewModel: CardViewModel by viewModels()

    private lateinit var binding: FragmentCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCard()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.randomCard.observeResult(this, onSuccess = {
            binding.card = it
        }, onError = {
            binding.error = ResultError(
                message = it?.message ?: getString(R.string.error_an_error_occur_try_again),
                code = it?.code,
                show = it?.show ?: true
            )
        })
    }

}