package com.test.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.test.imagelistapp.App
import com.test.imagelistapp.databinding.FragmentSignUpBinding
import com.test.imagelistapp.domain.login.SignUpViewModel
import javax.inject.Inject

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    @Inject
    lateinit var viewModel: SignUpViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App)
            .appComponent
            .provideLoginSubComponent()
            .provideFactory()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.signUpViewModel = viewModel
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.navigateToHomeScreenCommand.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                findNavController().navigate(SignUpFragmentDirections.toHomeFragment())
            }
        }
    }
}

