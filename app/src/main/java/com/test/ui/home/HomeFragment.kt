package com.test.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.imagelistapp.App
import com.test.imagelistapp.R
import com.test.imagelistapp.databinding.FragmentHomeBinding
import com.test.imagelistapp.domain.ImageViewData
import com.test.imagelistapp.domain.home.HomeViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    lateinit var binding: FragmentHomeBinding

    private val imageListAdapter by lazy {
        ImageListAdapter {
            findNavController().navigate(HomeFragmentDirections.toImageDetailsFragment(it))
        }.apply {
            stateRestorationPolicy =
                RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App)
            .appComponent
            .provideImageListSubComponent()
            .provideFactory()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        if (binding.imgRecyclerView.adapter != null)
            return
        val divider = DividerItemDecoration(
            requireContext(), DividerItemDecoration.VERTICAL
        ).apply {
            this.setDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.line_divider)!!
            )
        }
        with(binding.imgRecyclerView) {
            this.adapter = imageListAdapter
            this.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            this.addItemDecoration(divider)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getImageList().observe(viewLifecycleOwner) {
                imageListAdapter.submitData(
                    viewLifecycleOwner.lifecycle,
                    it
                )
            }
        }
    }
}
