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
import com.github.ulyanovskk.kittycodes.network.CatsRepository
import com.github.ulyanovskk.kittycodes.network.CatsService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

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
        val json =
        val retrofit = Retrofit.Builder()
            .baseUrl("https://http.cat")
            .client(OkHttpClient().newBuilder().build())
            .build()
        val catsService = retrofit.create(CatsService::class.java)


        view.findViewById<ImageView>(R.id.catImage).load(
            catsService.getCat("1").image
        )
    }

}