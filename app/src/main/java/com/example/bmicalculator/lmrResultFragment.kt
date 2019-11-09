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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bmicalculator.database.LBWDatabase
import com.example.bmicalculator.databaseViewModel.LBWdatabaseViewModel
import com.example.bmicalculator.databaseViewModel.LBWdatabaseViewModelFactory
import com.example.bmicalculator.databinding.FragmentLmrResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class lmrResultFragment : Fragment() {

    private lateinit var viewModel: lmrResultViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLmrResultBinding>(inflater,
            R.layout.fragment_lmr_result,container,false)

        Log.i("lmrResultViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(lmrResultViewModel::class.java)

        val args = lmrResultFragmentArgs.fromBundle(arguments!!)
        username = args.name

        val application = requireNotNull(this.activity).application

        val dataSource = LBWDatabase.getInstance(application).LBWDao
        val viewModelFactory = LBWdatabaseViewModelFactory(dataSource, application)

        val lbwDatabaseViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(LBWdatabaseViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.lbWdatabaseViewModel = lbwDatabaseViewModel

        val adapter = lbwResultAdapter()
        binding.lbwList.adapter = adapter

        lbwDatabaseViewModel.Lbws.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        binding.BMIButton.setChecked(false)
        binding.BMRButton.setChecked(false)
        binding.LBWButton.setChecked(true)

        binding.BMIButton.setOnClickListener{view : View ->
            //view.findNavController().navigate(R.id.action_lmrResultFragment_to_bmiResultFragment)
            view.findNavController().navigate(lmrResultFragmentDirections.actionLmrResultFragmentToBmiResultFragment(username))
        }
        binding.BMRButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(lmrResultFragmentDirections.actionLmrResultFragmentToBmrResultFragment(username))
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            binding.LBWButton.setChecked(true)
        }

        binding.tableButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_lmrResultFragment_to_lmrCalculatorFragment)
            view.findNavController().navigate(lmrResultFragmentDirections.actionLmrResultFragmentToLmrCalculatorFragment(username))
        }

        setHasOptionsMenu(true)
        Log.i("lmrResultFragment", "onCreateView called")
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("lmrResultFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lmrResultFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("lmrResultFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("lmrResultFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("lmrResultFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("lmrResultFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("lmrResultFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("lmrResultFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("lmrResultFragment", "onDetach called")
    }
}
