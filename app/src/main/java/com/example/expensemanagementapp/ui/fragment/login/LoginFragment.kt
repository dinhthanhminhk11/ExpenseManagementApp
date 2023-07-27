package com.example.expensemanagementapp.ui.fragment.login

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentLoginBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel


class LoginFragment : BaseViewModelFragment<FragmentLoginBinding, MainViewModel>() {
    private var isInitialized = false
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(editable: Editable?) {
            if (!isInitialized) {
                return
            }
            val input = editable.toString()
            val isValid = isPhoneNumberOrGmail(input)

            if (input.isNullOrEmpty()) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorUsername),
                    binding.username,
                    binding.textErrorUsername
                )
            } else if (isValid) {
                isValidate(
                    true, "", binding.username, binding.textErrorUsername
                )
            } else {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorUsernameCheckEmailOrPhone),
                    binding.username,
                    binding.textErrorUsername
                )
            }
        }
    }
    private val textWatcherPassword = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(editable: Editable?) {

            if (!isInitialized) {
                return
            }

            val input = editable.toString()
            val isValid = isPasswordValid(input)

            if (input.isNullOrEmpty()) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorPassword),
                    binding.password,
                    binding.textErrorPassword
                )
            } else if (isValid) {
                isValidate(
                    true, "", binding.password, binding.textErrorPassword
                )
            } else {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorPasswordValidate),
                    binding.password,
                    binding.textErrorPassword
                )
            }
        }
    }

    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {

        binding.username.addTextChangedListener(textWatcher)
        binding.password.addTextChangedListener(textWatcherPassword)
    }

    override fun initOnClickListener() {
        binding.btnLogin.setOnClickListener {
            if (binding.username.text.toString().isEmpty()) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorUsername),
                    binding.username,
                    binding.textErrorUsername
                )
            } else if (!isPhoneNumberOrGmail(binding.username.text.toString())) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorUsernameCheckEmailOrPhone),
                    binding.username,
                    binding.textErrorUsername
                )
            } else if (binding.password.text.toString().isEmpty()) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorPassword),
                    binding.password,
                    binding.textErrorPassword
                )
            } else if (!isPasswordValid(binding.password.text.toString())) {
                isValidate(
                    false,
                    resources.getString(R.string.textErrorPasswordValidate),
                    binding.password,
                    binding.textErrorPassword
                )
            } else {
                findNavController().navigate(
                    R.id.action_loginFragment2_to_kingMainFragment
                )
            }
        }

        binding.register.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment2_to_registerFragment
            )
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment2_to_forgotPasswordFragment
            )
        }

        binding.btnPin.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment2_to_loginPINFragment
            )
        }

        binding.btnFace.setOnClickListener {

        }
    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun onResume() {
        super.onResume()
        isInitialized = true
    }

    override fun onPause() {
        super.onPause()
        isInitialized = false
    }

    private fun isValidate(
        check: Boolean, textError: String, editText: EditText, textViewError: TextView
    ) {
        textViewError.text = textError
        if (check) {
            editText.background = resources.getDrawable(R.drawable.background_edit_text_true)
        } else {
            editText.background = resources.getDrawable(R.drawable.background_edit_text_false)
        }
    }

    private fun isPhoneNumberOrGmail(input: String): Boolean {
        val phoneRegex = "^(03|05|07|08|09)+([0-9]{8})\\b".toRegex()
        val gmailRegex = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$".toRegex()
        return input.matches(phoneRegex) || input.matches(gmailRegex)
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,15}\$".toRegex()
        return password.matches(passwordRegex)
    }
}