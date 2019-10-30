package com.example.bmicalculator


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bmicalculator.databinding.FragmentBmrCalculatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class bmrCalculatorFragment : Fragment() {

    private lateinit var viewModel: bmrCalculatorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBmrCalculatorBinding>(inflater,
            R.layout.fragment_bmr_calculator,container,false)

        Log.i("bmrCalculatorViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(bmrCalculatorViewModel::class.java)

        binding.BMIButton.setChecked(false)
        binding.BMRButton.setChecked(true)
        binding.LBWButton.setChecked(false)

        var gender = "Male"
        var age = false
        var weight = false
        var height = false
        var checkAsButton = false
        var numberDotHeight = 0
        var numberDotWeight = 0
        var numberDotAge = 0

        binding.BMIButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrCalculatorFragment_to_bmiCalculatoFragment)
            view.findNavController().navigate(bmrCalculatorFragmentDirections.actionBmrCalculatorFragmentToBmiCalculatoFragment("no show"))
        }
        binding.BMRButton.setOnClickListener{
            binding.BMRButton.setChecked(true)
        }
        binding.LBWButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrCalculatorFragment_to_lmrCalculatorFragment)
            view.findNavController().navigate(bmrCalculatorFragmentDirections.actionBmrCalculatorFragmentToLmrCalculatorFragment())
        }

        binding.tableButton.setOnClickListener{ view : View ->
            //view.findNavController().navigate(R.id.action_bmrCalculatorFragment_to_bmrResultFragment)
            view.findNavController().navigate(bmrCalculatorFragmentDirections.actionBmrCalculatorFragmentToBmrResultFragment())
        }

        fun ClickAsButtonToTrueInHeight(){
            binding.editHeight.setText(binding.editHeight.getText().toString());
        }

        fun ClickAsButtonToTrueInWeight(){
            binding.editWeight.setText(binding.editWeight.getText().toString());
        }

        fun ClickAsButtonToTrueInAge(){
            binding.editAge.setText(binding.editAge.getText().toString());
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


        binding.editAge.setOnClickListener {
            age = true
            weight = false
            height = false
            checkAsButton = false
            if(age == true){
                binding.buttonNumber0.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20
                        || binding.editAge.getText().toString().length == 0){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"0");
                    }
                }
                binding.buttonNumber1.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"1");
                    }
                }
                binding.buttonNumber2.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"2");
                    }
                }
                binding.buttonNumber3.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"3");
                    }
                }
                binding.buttonNumber4.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"4");
                    }
                }
                binding.buttonNumber5.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"5");
                    }
                }
                binding.buttonNumber6.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"6");
                    }
                }
                binding.buttonNumber7.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"7");
                    }
                }
                binding.buttonNumber8.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"8");
                    }
                }
                binding.buttonNumber9.setOnClickListener { view : View ->
                    if(checkAsButton == true
                        ||  binding.editAge.getText().toString().length >= 20){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText(binding.editAge.getText().toString()+"9");
                    }
                }
                binding.CButton.setOnClickListener {
                    if(checkAsButton == true){
                        ClickAsButtonToTrueInAge()
                    }else{
                        binding.editAge.setText("");
                    }
                }
                binding.DeleteButton.setOnClickListener {
                    if(checkAsButton == true){
                        ClickAsButtonToTrueInAge()
                    }else{
                        if (binding.editAge.getText().toString() == null ||
                            binding.editAge.getText().toString().length == 0) {
                            binding.editAge.setText("");
                        }else{
                            binding.editAge.setText(binding.editAge.getText().toString()
                                .substring(0, binding.editAge.getText().toString().length - 1));
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
            viewModel.setWeightString(binding.editWeight.getText().toString())
            viewModel.setAgeString(binding.editAge.getText().toString())
            viewModel.calcutator(gender)

            viewModel.bmrDouble.observe(this, Observer { bmrDouble ->
                binding.BMRCost.setText(String.format("%.1f", bmrDouble));
            })


            if(viewModel.statusHeight == true && viewModel.statusWeight == true && viewModel.statusAge == true){
                binding.BMRHeadText.visibility = View.VISIBLE
                binding.BMRTailText.visibility = View.VISIBLE
                binding.BMRCost.visibility = View.VISIBLE
            }
        }

        setHasOptionsMenu(true)
        Log.i("bmrCalculatorFragment", "onCreateView called")
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_bmr_text, viewModel.bmrCost.value))
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
        Log.i("bmrCalculatorFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("bmrCalculatorFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("bmrCalculatorFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("bmrCalculatorFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("bmrCalculatorFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("bmrCalculatorFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("bmrCalculatorFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("bmrCalculatorFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("bmrCalculatorFragment", "onDetach called")
    }
}
