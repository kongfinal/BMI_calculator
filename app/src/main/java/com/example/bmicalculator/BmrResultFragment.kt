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
import com.example.bmicalculator.databinding.FragmentBmrResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BmrResultFragment : Fragment() {

    private lateinit var viewModel: BmrResultViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBmrResultBinding>(inflater,
            R.layout.fragment_bmr_result,container,false)

        Log.i("BmrResultViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(BmrResultViewModel::class.java)

        val args = BmrResultFragmentArgs.fromBundle(arguments!!)
        username = args.name

        binding.BMIButton.setChecked(false)
        binding.BMRButton.setChecked(true)
        binding.LBWButton.setChecked(false)

        binding.BMIButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrResultFragment_to_bmiResultFragment)
            view.findNavController().navigate(BmrResultFragmentDirections.actionBmrResultFragmentToBmiResultFragment(username))
        }
        binding.BMRButton.setOnClickListener{
            binding.BMRButton.setChecked(true)
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrResultFragment_to_lmrResultFragment)
            view.findNavController().navigate(BmrResultFragmentDirections.actionBmrResultFragmentToLmrResultFragment(username))
        }

        binding.homeButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrResultFragment_to_bmrCalculatorFragment)
            view.findNavController().navigate(BmrResultFragmentDirections.actionBmrResultFragmentToBmrCalculatorFragment(username))
        }

        setHasOptionsMenu(true)
        Log.i("BmrResultFragment", "onCreateView called")
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("BmrResultFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("BmrResultFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("BmrResultFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("BmrResultFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("BmrResultFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("BmrResultFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("BmrResultFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("BmrResultFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("BmrResultFragment", "onDetach called")
    }
}
