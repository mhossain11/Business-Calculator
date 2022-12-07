package com.example.calculator_for_agg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator_for_agg.adapter.AggAdapter
import com.example.calculator_for_agg.databinding.FragmentHomeBinding
import com.example.calculator_for_agg.dialog.AggDeleteAlertDialog
import com.example.calculator_for_agg.dialog.AggEditDialog
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.viewModel.AggViewModel


class HomeFragment : Fragment(), listenerClick {
    lateinit var binding: FragmentHomeBinding
    private lateinit var aggViewModel: AggViewModel
    var oldData = arrayListOf<AggData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)
        aggViewModel =
            ViewModelProvider(requireActivity())[AggViewModel::class.java]  //not used get

        val adapter = AggAdapter(this)

        //observe data
        aggViewModel.getAll().observe(viewLifecycleOwner) { DataList ->
            oldData = DataList as ArrayList<AggData>
            adapter.submitList(DataList)
        }

        binding.rcView.layoutManager = LinearLayoutManager(activity)
        binding.rcView.adapter = adapter

        binding.fabBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_blankFragment)

        }

        return binding.root

    }

    //Row Button click

    override fun onDeleteListener(aggData: AggData) {
        AggDeleteAlertDialog(
            "Delete",
            "Are you sure to Delete",
            R.drawable.ic_baseline_delete_forever_24,
            "Yes",
            "Cancel"
        ) {
            aggViewModel.remove(aggData)
        }.show(childFragmentManager, "dialog")

    }

    override fun onEditListener(aggData: AggData) {
        AggEditDialog(aggData) .show(childFragmentManager, "dialog")
    }



}