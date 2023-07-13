package com.example.expensemanagementapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.constant.AppConstant
import com.example.expensemanagementapp.databinding.FragmentKingMainBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class KingMainFragment : BaseViewModelFragment<FragmentKingMainBinding, MainViewModel>(),
    NavController.OnDestinationChangedListener {
    private var backPressedTime: Long = 0
    private val BACK_PRESS_INTERVAL: Long = 2000

    private lateinit var navController: NavController
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {
        duplicationBack()
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setStatusBarStyle(AppConstant.TYPE_LIGHT, Color.WHITE)
        binding.navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    binding.nameTag.text = getString(R.string.title_home)
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.navigation_wallet -> {
                    binding.nameTag.text = getString(R.string.title_wallet)
                    navController.navigate(R.id.walletFragment)
                    true
                }

                R.id.navigation_add -> {
//                    navController.navigate(R.id.walletFragment)
                    true
                }

                R.id.navigation_chart -> {
                    binding.nameTag.text = getString(R.string.title_chart)
                    navController.navigate(R.id.chartFragment)
                    true
                }

                R.id.navigation_me -> {
                    binding.nameTag.text = getString(R.string.title_me)
                    navController.navigate(R.id.personFragment)
                    true
                }

                else -> false
            }
        }
    }

    override fun initOnClickListener() {

    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentKingMainBinding {
        return FragmentKingMainBinding.inflate(inflater, container, false)
    }

    private fun duplicationBack() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val currentTime = System.currentTimeMillis()
                if (currentTime - backPressedTime > BACK_PRESS_INTERVAL) {
                    Toast.makeText(
                        requireContext(), "Nhấn back lần nữa để thoát", Toast.LENGTH_SHORT
                    ).show()
                    backPressedTime = currentTime
                } else {
                    isEnabled = false
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, onBackPressedCallback
        )
    }

    override fun onDestinationChanged(
        controller: NavController, destination: NavDestination, arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.homeFragment -> {

            }

            R.id.walletFragment -> {

            }
        }
    }

}