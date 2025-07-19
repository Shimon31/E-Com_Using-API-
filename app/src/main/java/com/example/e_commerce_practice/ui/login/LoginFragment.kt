package com.example.e_commerce_practice.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_practice.R
import com.example.e_commerce_practice.data.model.login.RequestLogin
import com.example.e_commerce_practice.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        viewModel.loginResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }


        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBTN.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            val email = binding.emailET.text.toString()
            val password = binding.emailET.text.toString()

            handleLogin("john@mail.com", "changeme")

            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }

    }

    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)
        //fire and forget
        viewModel.login(requestLogin)

    }


}