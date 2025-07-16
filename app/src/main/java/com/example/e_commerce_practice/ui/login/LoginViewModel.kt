package com.example.e_commerce_practice.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_practice.data.model.login.RequestLogin
import com.example.e_commerce_practice.data.model.login.ResponseLogin
import com.example.e_commerce_practice.data.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseLogin>>()

    val loginResponse: LiveData<Response<ResponseLogin>> = _response

    fun login(requestLogin: RequestLogin) {
        viewModelScope.launch {

            _response.postValue(repo.login(requestLogin))

        }
    }
}
