package com.github.ulyanovskk.kittycodes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.github.ulyanovskk.kittycodes.viewmodels.InternetCodesViewModel
import com.github.ulyanovskk.kittycodes.R

class InternetCodesFragment : Fragment() {

    companion object {
        fun newInstance() = InternetCodesFragment()
    }

    private lateinit var viewModel: InternetCodesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.internet_codes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = requireView().findViewById<ImageView>(R.id.catImage)
        imageView.load(
            "https://http.cat/404.jpg"
        ) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
        }
    }

}