package com.example.expensemanagementapp.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensemanagementapp.base.BaseViewModel
import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import com.example.expensemanagementapp.usercase.LoginUserCase
import com.example.expensemanagementapp.usercase.RegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val app: Application,
    private val loginUserCase: LoginUserCase,
    private val registerUseCase: RegisterUseCase
) :
    BaseViewModel(app) {

    val mutableLiveDataRegisterResponse: MutableLiveData<Resource<UserRegisterResponse>> =
        MutableLiveData()

    val mutableLiveDataMessage: MutableLiveData<Resource<Message>> = MutableLiveData()

    fun register(bodyRegister: BodyRegister) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = registerUseCase.execute(bodyRegister)
                mutableLiveDataRegisterResponse.postValue(apiResult)
            }
        } catch (e: Exception) {
            mutableLiveDataRegisterResponse.postValue(Resource.Error(e.message.toString()))
        }
    }

    fun generateOTP(emailBody: EmailBody) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (isNetworkAvailable(app)) {
                registerUseCase.executeGenerateOTP(emailBody)
            }
        } catch (e: Exception) {

        }
    }

    fun verifyAccount(bodyVerifyOTP: BodyVerifyOTP) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = registerUseCase.executeVerifyAccount(bodyVerifyOTP)
                mutableLiveDataMessage.postValue(apiResult)
            }
        } catch (e: Exception) {
            mutableLiveDataMessage.postValue(Resource.Error(e.message.toString()))
        }
    }


    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}