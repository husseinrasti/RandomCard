package ir.husseinrasti.presentation.card

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import ir.husseinrasti.domain.card.entity.Card
import ir.husseinrasti.presentation.R
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.ResultError
import ir.husseinrasti.presentation.base.extensions.observeResult
import ir.husseinrasti.presentation.databinding.FragmentCardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CardFragment : BaseFragment() {

    private val viewModel: CardViewModel by viewModels()

    private lateinit var binding: FragmentCardBinding

    private var mediaPlayer: MediaPlayer? = null

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
            doWork(it)
        }, onError = {
            binding.error = ResultError(
                message = it?.message ?: getString(R.string.error_an_error_occur_try_again),
                code = it?.code,
                show = it?.show ?: true
            )
        })
    }

    private fun doWork(card: Card?) = runBlocking(Dispatchers.IO) {
        stopSound()
        when (card?.code) {
            1 -> {//vibrate
                val vibrate = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrate.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrate.vibrate(500)
                }
            }
            2 -> {//sound
                playSound(card.sound)
            }
            else -> { //Nothing
            }
        }
    }

    private fun playSound(sound: String?) = runBlocking(Dispatchers.IO) {
        try {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(sound)
                prepare() // might take long! (for buffering, etc)
                start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopSound() {
        try {
            mediaPlayer?.release()
            mediaPlayer = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}