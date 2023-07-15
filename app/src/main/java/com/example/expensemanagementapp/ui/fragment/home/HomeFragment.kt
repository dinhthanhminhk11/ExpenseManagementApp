package com.example.expensemanagementapp.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentHomeBinding
import com.example.expensemanagementapp.model.Transaction
import com.example.expensemanagementapp.ui.adapter.TransactionAdapter
import com.example.expensemanagementapp.viewmodel.MainViewModel

class HomeFragment : BaseViewModelFragment<FragmentHomeBinding, MainViewModel>() {
    private lateinit var transactionAdapter: TransactionAdapter
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {
        var list = listOf<Transaction>(
            Transaction("234234", 234.3, "MInh", "sdfsfdsfs", 234.23),
            Transaction("234234", 234.3, "MInh", "sdfsfdsfs", 234.23),
            Transaction("234234", 234.3, "MInh", "sdfsfdsfs", 234.23),
            Transaction("234234", 234.3, "MInh", "sdfsfdsfs", 234.23),
            Transaction("234234", 234.3, "MInh", "sdfsfdsfs", 234.23),

            )
        transactionAdapter = TransactionAdapter()
        binding.listTransactions.apply {
            adapter = transactionAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }

        transactionAdapter.differ.submitList(list)


        binding.barChart.animation.duration = animationDuration
        binding.barChart.animate(barSet)
        binding.barChart.onDataPointTouchListener = { index, _, _ ->
//                tvChartName.text =
//                    barSet.toList()[index]
//                        .second
//                        .toString()
        }
    }

    override fun initOnClickListener() {
    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    companion object {

        private val barSet = listOf(
            "JAN" to 4F,
            "FEB" to 7F,
            "MAR" to 2F,
            "MAY" to 2.3F,
            "APR" to 5F,
            "JUN" to 4F,
            "ád" to 4F,
            "ád" to 4F,
        )

        private const val animationDuration = 1000L
    }
}