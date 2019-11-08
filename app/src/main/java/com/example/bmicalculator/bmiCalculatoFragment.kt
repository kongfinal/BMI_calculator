package com.example.bmicalculator


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.renderscript.Double2;
import android.util.Log
import android.widget.*;
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bmicalculator.database.BMIDatabase
import com.example.bmicalculator.databaseViewModel.BMIdatabaseViewModel
import com.example.bmicalculator.databaseViewModel.BMIdatabaseViewModelFactory
import com.example.bmicalculator.databinding.FragmentBmiCalculatoBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class bmiCalculatoFragment : Fragment() {

    private lateinit var viewModel: bmiCalculatoViewModel
    private lateinit var databaseViewModel: BMIdatabaseViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding:FragmentBmiCalculatoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bmi_calculato,container,false)

        val application = requireNotNull(this.activity).application

        val dataSource = BMIDatabase.getInstance(application).BMIDao
        val viewModelFactory = BMIdatabaseViewModelFactory(dataSource, application)

        val bmiDatabaseViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(BMIdatabaseViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.bmIdatabaseViewModel = bmiDatabaseViewModel

        val args = bmiCalculatoFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "Username: ${args.name}", Toast.LENGTH_LONG).show()
        username = args.name

        Log.i("bmiCalculatoViewModel", "Called bmiCalculatoViewModel.of")
        viewModel = ViewModelProviders.of(this).get(bmiCalculatoViewModel::class.java)

        var weight = false
        var height = false
        var checkAsButton = false
        var numberDotHeight = 0
        var numberDotWeight = 0

        binding.BMIButton.setChecked(true)
        binding.BMRButton.setChecked(false)
        binding.LBWButton.setChecked(false)

        binding.BMIButton.setOnClickListener{
            binding.BMIButton.setChecked(true)
        }
        binding.BMRButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiCalculatoFragment_to_bmrCalculatorFragment)
            view.findNavController().navigate(bmiCalculatoFragmentDirections.actionBmiCalculatoFragmentToBmrCalculatorFragment(username))
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiCalculatoFragment_to_lmrCalculatorFragment)
            view.findNavController().
                navigate(bmiCalculatoFragmentDirections.actionBmiCalculatoFragmentToLmrCalculatorFragment(username))
        }

        binding.tableButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmiCalculatoFragment_to_bmiResultFragment)
            view.findNavController().navigate(bmiCalculatoFragmentDirections.actionBmiCalculatoFragmentToBmiResultFragment(username))
        }

        fun ClickAsButtonToTrueInHeight(){
            binding.editHeight.setText(binding.editHeight.getText().toString());
        }

        fun ClickAsButtonToTrueInWeight(){
            binding.editWeight.setText(binding.editWeight.getText().toString());
        }

        binding.editHeight.setOnClickListener {
            height = true
            weight = false
            checkAsButton = false
            if(height == true ){
                binding.buttonNumber0.setOnClickListener { view : View ->
                    if(checkAsButton == true
                                || binding.editHeight.getText().toString().length >= 20
                                ||  binding.editHeight.getText().toString().length == 0){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"0");
                    }
                }
                binding.buttonNumber1.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"1");
                    }
                }
                binding.buttonNumber2.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"2");
                    }
                }
                binding.buttonNumber3.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"3");
                    }
                }
                binding.buttonNumber4.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"4");
                    }
                }
                binding.buttonNumber5.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"5");
                    }
                }
                binding.buttonNumber6.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"6");
                    }
                }
                binding.buttonNumber7.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"7");
                    }
                }
                binding.buttonNumber8.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"8");
                    }
                }
                binding.buttonNumber9.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+"9");
                    }
                }
                binding.dotNutton.setOnClickListener {
                    if(checkAsButton == true
                        ||  binding.editHeight.getText().toString().length >= 20
                        ||  binding.editHeight.getText().toString().length == 0
                        || numberDotHeight != 0){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText(binding.editHeight.getText().toString()+".");
                        numberDotHeight = 1
                    }
                }
                binding.CButton.setOnClickListener {
                    if(checkAsButton == true){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        binding.editHeight.setText("");
                    }
                }
                binding.DeleteButton.setOnClickListener {
                    if(checkAsButton == true){
                        ClickAsButtonToTrueInHeight();
                    }else{
                        if (binding.editHeight.getText().toString() == null ||
                            binding.editHeight.getText().toString().length == 0) {
                            binding.editHeight.setText("");
                        }else{
                            binding.editHeight.setText(binding.editHeight.getText().toString()
                                .substring(0, binding.editHeight.getText().toString().length - 1));
                        }
                    }
                }
            }
            }


        binding.editWeight.setOnClickListener {
            weight = true
            height = false
            checkAsButton = false
            if(weight == true){
                binding.buttonNumber0.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20
                        || binding.editWeight.getText().toString().length == 0){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"0");
                    }
                }
                binding.buttonNumber1.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"1");
                    }
                }
                binding.buttonNumber2.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"2");
                    }
                }
                binding.buttonNumber3.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"3");
                    }
                }
                binding.buttonNumber4.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"4");
                    }
                }
                binding.buttonNumber5.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"5");
                    }
                }
                binding.buttonNumber6.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"6");
                    }
                }
                binding.buttonNumber7.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"7");
                    }
                }
                binding.buttonNumber8.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"8");
                    }
                }
                binding.buttonNumber9.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+"9");
                    }
                }
                binding.dotNutton.setOnClickListener {
                    if(checkAsButton == true
                        ||  binding.editWeight.getText().toString().length >= 20
                        ||  binding.editWeight.getText().toString().length == 0
                        || numberDotWeight != 0){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText(binding.editWeight.getText().toString()+".");
                        numberDotWeight = 1
                    }
                }
                binding.CButton.setOnClickListener {
                    if(checkAsButton == true){
                        ClickAsButtonToTrueInWeight()
                    }else{
                        binding.editWeight.setText("");
                    }
                }
                    binding.DeleteButton.setOnClickListener {
                        if(checkAsButton == true){
                            ClickAsButtonToTrueInWeight()
                        }else{
                            if (binding.editWeight.getText().toString() == null ||
                                binding.editWeight.getText().toString().length == 0) {
                                binding.editWeight.setText("");
                            }else{
                                binding.editWeight.setText(binding.editWeight.getText().toString()
                                    .substring(0, binding.editWeight.getText().toString().length - 1));
                            }
                        }
                    }
            }
        }


        binding.asButton.setOnClickListener {
            weight = false
            height = false
            checkAsButton = true

            viewModel.setHeightString(binding.editHeight.getText().toString())
            viewModel.showSnackBarHeight.observe(this, Observer {
                if (it == true) {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.snack_height_message),
                        Snackbar.LENGTH_SHORT
                    ).show()
                    viewModel.doneShowingSnackbarHeight()
                }
            })

            viewModel.setWeightString(binding.editWeight.getText().toString())
            viewModel.showSnackBarWeight.observe(this, Observer {
                if (it == true) {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.snack_weight_message),
                        Snackbar.LENGTH_SHORT
                    ).show()
                    viewModel.doneShowingSnackbarWeight()
                }
            })

            viewModel.calcutator();

            viewModel.bmiDouble.observe(this, Observer { bmiDouble ->
                binding.BMICost.setText(String.format("%.2f", bmiDouble));
            })

            viewModel.bmiCriterion.observe(this, Observer { bmiCriterion ->
                binding.BMICriterionResult.setText(bmiCriterion);
            })

            if(viewModel.statusHeight == true && viewModel.statusWeight == true){
                binding.BMIText.visibility = View.VISIBLE
                binding.BMICriterionText.visibility = View.VISIBLE
                binding.BMICost.visibility = View.VISIBLE
                binding.BMICriterionResult.visibility = View.VISIBLE
                bmiDatabaseViewModel
                    .onStartCalculator(username,
                        viewModel.weightDouble.value.toString().toDouble(),
                        viewModel.heightDouble.value.toString().toDouble(),
                        viewModel.bmiDouble.value.toString().toDouble(),
                        viewModel.bmiCriterion.value.toString()
                    )
            }

        }

        setHasOptionsMenu(true)
        Log.i("bmiCalculatoFragment", "onCreateView called")
        //databaseViewModel.onStartTracking()
        return binding.root
    }


    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,
            getString(R.string.share_bmi_text, viewModel.bmiCost.value,viewModel.bmiCriterion.value))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("bmiCalculatoFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("bmiCalculatoFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("bmiCalculatoFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("bmiCalculatoFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("bmiCalculatoFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("bmiCalculatoFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("bmiCalculatoFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("bmiCalculatoFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("bmiCalculatoFragment", "onDetach called")
    }
}
