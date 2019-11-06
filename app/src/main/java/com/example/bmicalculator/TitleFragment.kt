package com.example.bmicalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.bmicalculator.databinding.FragmentTitleBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    //private lateinit var viewModel: TitleViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener{ view : View ->
            username = binding.editName.getText().toString()
            if(!(username.equals(""))){
                view.findNavController().
                    navigate(TitleFragmentDirections.actionTitleFragmentToBmiCalculatoFragment(username))
            }else{
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.snack_name_message),
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            //view.findNavController().navigate(R.id.action_titleFragment_to_bmiCalculatoFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
