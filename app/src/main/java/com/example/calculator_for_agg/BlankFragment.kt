package com.example.calculator_for_agg
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.databinding.FragmentBlankBinding
import com.example.calculator_for_agg.dialog.CalculatorDatePicker
import com.example.calculator_for_agg.dialog.CalculatorTimePicker
import com.example.calculator_for_agg.viewModel.AggViewModel


class BlankFragment : Fragment() {
    private lateinit var binding : FragmentBlankBinding
    private var defultDate = System.currentTimeMillis()
    private var defultTime =  System.currentTimeMillis()
    private lateinit var aggViewModel: AggViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater)
        aggViewModel = ViewModelProvider(requireActivity())[AggViewModel::class.java]

        binding.date.setOnClickListener {

            CalculatorDatePicker {
                defultDate =it

                binding.date.text = formattedDateTime(it,"MM/dd/yyyy")

            }.show(childFragmentManager,"Date_Picker")
        }

        binding.time.setOnClickListener {


            CalculatorTimePicker {
                defultTime= it

                binding.time.text= formattedDateTime(it,"hh:mm a")

            }.show(childFragmentManager,"Time_Picker")

        }



        binding.saveBtn.setOnClickListener {

            val name = binding.name.text.toString()
            val qnt = binding.quantity.text.toString()
            val rtl = binding.rtlRate.text.toString()
            val wh = binding.whRate.text.toString()

           if (!validationField(name,qnt,rtl,wh)) return@setOnClickListener


            val c = Calculator()
            //total
            val total = c.totalPrice(qnt.toInt(), rtl.toDouble())
            //profit
            val profit = c.price_Profit(qnt.toInt(), wh.toDouble(), rtl.toDouble())


            val allData = AggData(
                namesw = name,
                total = total,
                quantity = qnt.toInt(),
                rate = rtl.toDouble(),
                profit = profit,
                date = defultDate,
                time = defultTime
            )

            aggViewModel.add(allData)
            findNavController().navigate(R.id.action_blankFragment_to_homeFragment)


        }


        return binding.root
    }
fun validationField(name:String,qnt:String,rtl:String,wh:String):Boolean{

    var tag = true

    if (name.isEmpty()) {
        binding.name.setError("Field cannot be Empty")
        tag = false
    }
    if (qnt.isEmpty()){
        binding.quantity.setError("Field cannot be Empty")
        tag = false
    }

    if (rtl.isEmpty()){
        binding.rtlRate.setError("Field cannot be Empty")
        tag = false
    }

    if (wh.isEmpty()){
        binding.whRate.setError("Field cannot be Empty")
        tag = false
    }
    return tag
}


}




