package com.example.bmicalculator


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bmicalculator.databinding.FragmentBmiResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class bmiResultFragment : Fragment() {

    private lateinit var viewModel: bmiResultViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBmiResultBinding>(inflater,
            R.layout.fragment_bmi_result,container,false)

        Log.i("bmiResultViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(bmiResultViewModel::class.java)

        val args = bmiResultFragmentArgs.fromBundle(arguments!!)
        username = args.name

        binding.BMIButton.setChecked(true)
        binding.BMRButton.setChecked(false)
        binding.LBWButton.setChecked(false)

        binding.BMIButton.setOnClickListener{
            binding.BMIButton.setChecked(true)
        }
        binding.BMRButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiResultFragment_to_bmrResultFragment)
            view.findNavController().navigate(bmiResultFragmentDirections.actionBmiResultFragmentToBmrResultFragment(username))
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiResultFragment_to_lmrResultFragment)
            view.findNavController().navigate(bmiResultFragmentDirections.actionBmiResultFragmentToLmrResultFragment(username))
        }


        binding.homeButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiResultFragment_to_bmiCalculatoFragment)
            view.findNavController().navigate(bmiResultFragmentDirections.actionBmiResultFragmentToBmiCalculatoFragment(username))
        }


        setHasOptionsMenu(true)
        Log.i("bmiResultFragment", "onCreateView called")
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("bmiResultFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("bmiResultFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("bmiResultFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("bmiResultFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("bmiResultFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("bmiResultFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("bmiResultFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("bmiResultFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("bmiResultFragment", "onDetach called")
    }
}
