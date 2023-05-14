package com.test.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.test.imagelistapp.databinding.FragmentImageDetailsBinding

class ImageDetailsFragment : Fragment() {

    private lateinit var binding: FragmentImageDetailsBinding

    private val arguments by navArgs<ImageDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageDetailsBinding.inflate(inflater, container, false)
        binding.imageData = arguments.imageDetails
        return binding.root
    }
}
