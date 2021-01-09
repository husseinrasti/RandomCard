package ir.husseinrasti.presentation.card

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import ir.husseinrasti.domain.card.entity.Card
import ir.husseinrasti.presentation.R
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.ResultError
import ir.husseinrasti.presentation.base.extensions.observeResult
import ir.husseinrasti.presentation.databinding.FragmentCardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class CardFragment : BaseFragment() {

    private val viewModel: CardViewModel by viewModels()

    private lateinit var binding: FragmentCardBinding

    private var exoPlayer: SimpleExoPlayer? = null

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

    private fun doWork(card: Card?) {
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

    private fun playSound(sound: String?) {
        try {
            exoPlayer = SimpleExoPlayer.Builder(requireContext()).build()
            binding.playerView.player = exoPlayer
            exoPlayer?.addMediaItem(MediaItem.fromUri(sound!!))
            exoPlayer?.prepare()
            exoPlayer?.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopSound() {
        try {
            exoPlayer?.release()
            exoPlayer = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}