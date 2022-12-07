package com.example.calculator_for_agg.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Application
import android.app.Dialog
import android.content.DialogInterface
import android.location.GnssAntennaInfo
import android.media.Image
import android.net.sip.SipSession
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.calculator_for_agg.R
import com.example.calculator_for_agg.adapter.AggAdapter
import com.example.calculator_for_agg.databinding.EditDialogBinding
import com.example.calculator_for_agg.databinding.FragmentBlankBinding
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.viewModel.AggViewModel


class AggDeleteAlertDialog(
    private var tital:String, private var mess:String, private var icon:Int, private var
txtone:String, private var txttwo:String, val callback :()-> Unit):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder= AlertDialog.Builder(requireContext())

        builder.setTitle(tital)
        builder.setMessage(mess)
        builder.setIcon(icon)
        builder.setPositiveButton(txtone,DialogInterface.OnClickListener { dialog, which ->
            callback() })
        builder.setNegativeButton(txttwo,null)
        return builder.create()
    }
}




class AggEditDialog(var aggData: AggData):DialogFragment() {

        lateinit var binding :EditDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

     binding = EditDialogBinding.inflate(layoutInflater)
        var builder= AlertDialog.Builder(requireContext())

       builder.setView(binding.root)
        binding.lifecycleOwner=this

        builder.setPositiveButton("Save") { dialog, which ->
//            binding.editName.setText(aggData.namesw)
//            binding.editQuantity.setText(aggData.quantity)
//            binding.editRate.setText(aggData.rate.toString())

           aggData.namesw = binding.editName.toString()
            aggData.quantity = binding.editQuantity.toString().toInt()
            aggData.rate = binding.editRate.toString().toDouble()
            dialog.dismiss()

        }
        builder.setNegativeButton("Cancel",null)

        return builder.create()

    }

}




