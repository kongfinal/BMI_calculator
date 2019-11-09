package com.example.bmicalculator


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bmicalculator.database.LBWDatabase
import com.example.bmicalculator.databaseViewModel.LBWdatabaseViewModel
import com.example.bmicalculator.databaseViewModel.LBWdatabaseViewModelFactory
import com.example.bmicalculator.databinding.FragmentLmrCalculatorBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class lmrCalculatorFragment : Fragment() {

    private lateinit var viewModel: lmrCalculatorViewModel
    private var username = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLmrCalculatorBinding>(inflater,
            R.layout.fragment_lmr_calculator,container,false)

        Log.i("lmrCalculatorViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(lmrCalculatorViewModel::class.java)

        val args = lmrCalculatorFragmentArgs.fromBundle(arguments!!)
        username = args.name

        val application = requireNotNull(this.activity).application

        val dataSource = LBWDatabase.getInstance(application).LBWDao
        val viewModelFactory = LBWdatabaseViewModelFactory(dataSource, application)

        val lbwDatabaseViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(LBWdatabaseViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.lbWdatabaseViewModel = lbwDatabaseViewModel

        binding.BMIButton.setChecked(false)
        binding.BMRButton.setChecked(false)
        binding.LBWButton.setChecked(true)

        var gender = "Male"
        var weight = false
        var height = false
        var checkAsButton = false
        var numberDotHeight = 0
        var numberDotWeight = 0

        binding.BMIButton.setOnClickListener{view : View ->
            //view.findNavController().navigate(R.id.action_lmrCalculatorFragment_to_bmiCalculatoFragment)
            view.findNavController().navigate(lmrCalculatorFragmentDirections.actionLmrCalculatorFragmentToBmiCalculatoFragment(username))
        }
        binding.BMRButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_lmrCalculatorFragment_to_bmrCalculatorFragment)
            view.findNavController().navigate(lmrCalculatorFragmentDirections.actionLmrCalculatorFragmentToBmrCalculatorFragment(username))
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            binding.LBWButton.setChecked(true)
        }

        binding.tableButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_lmrCalculatorFragment_to_lmrResultFragment)
            view.findNavController().navigate(lmrCalculatorFragmentDirections.actionLmrCalculatorFragmentToLmrResultFragment(username))
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

        binding.genderButton.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked) {
                gender = "Female"
            } else {
                gender = "Male"
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

            viewModel.calcutator(gender);

            viewModel.lbwDouble.observe(this, Observer { lbwDouble ->
                binding.SBWCostText.setText(String.format("%.1f", lbwDouble))
            })

            viewModel.FatCost.observe(this, Observer { FatCost ->
                binding.FatWeightCostText.setText(String.format("%.1f", FatCost))
            })

            viewModel.lbwCriterion.observe(this, Observer { lbwCriterion ->
                binding.criterionResult.setText(String.format(lbwCriterion))
            })


            if(viewModel.statusHeight == true && viewModel.statusWeight == true){
                binding.SBWHeadText.visibility = View.VISIBLE
                binding.SBWCostText.visibility = View.VISIBLE
                binding.SBWTailText.visibility = View.VISIBLE
                binding.FatWeightHeadText.visibility = View.VISIBLE
                binding.FatWeightCostText.visibility = View.VISIBLE
                binding.fatWeightTailText.visibility = View.VISIBLE
                binding.LBWHeadText.visibility = View.VISIBLE
                binding.criterionResult.visibility = View.VISIBLE
                lbwDatabaseViewModel
                    .onStartCalculator(username,
                        gender,
                        viewModel.weightDouble.value.toString().toDouble(),
                        viewModel.heightDouble.value.toString().toDouble(),
                        viewModel.lbwDouble.value.toString().toDouble(),
                        viewModel.FatCost.value.toString().toDouble(),
                        viewModel.lbwCriterion.value.toString()
                    )
            }

        }

        setHasOptionsMenu(true)
        Log.i("lmrCalculatorFragment", "onCreateView called")
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_lbw_text,
            viewModel.lbwCost.value,viewModel.FatWCost.value,viewModel.lbwCriterion.value))
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
        Log.i("lmrCalculatorFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lmrCalculatorFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("lmrCalculatorFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("lmrCalculatorFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("lmrCalculatorFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("lmrCalculatorFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("lmrCalculatorFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("lmrCalculatorFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("lmrCalculatorFragment", "onDetach called")
    }
}
