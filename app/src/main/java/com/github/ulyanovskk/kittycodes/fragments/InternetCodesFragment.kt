package com.github.ulyanovskk.kittycodes.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.github.ulyanovskk.kittycodes.viewmodels.InternetCodesViewModel
import com.github.ulyanovskk.kittycodes.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class InternetCodesFragment : Fragment() {

    companion object {
        fun newInstance() = InternetCodesFragment()
    }

    private val viewModel: InternetCodesViewModel by viewModels()
    private lateinit var imageView: ImageView
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.internet_codes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = requireView().findViewById(R.id.catImage)
        editText = requireView().findViewById(R.id.editText)
        changeCat(viewModel.catUrl.value)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(
                Lifecycle.State.STARTED
            ) {
                viewModel.catUrl
                    .onEach { url ->
                        changeCat(url)
                    }
            }
        }

        editText.doOnTextChanged { text, _, _, count ->
            viewModel.setCatUrl(text?.toString().orEmpty())
            Log.d("PROCESSED", "CHANGE: " + viewModel.catUrl.value)
        }
    }

    private fun changeCat(url: String) {
        Log.d("PROCESSED", "LOADING")
        imageView.load(
                    url
                ) {
                    crossfade(true)
                }
    }

}