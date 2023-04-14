package project.productsandservice.ui.createAdvert

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel
import project.productsandservice.R
import project.productsandservice.databinding.ActivityCreateAdvertBinding
import project.productsandservice.domain.usecase.GetDateTimeUseCase
import project.productsandservice.domain.usecase.GetTextCurrencyInSymbolUseCase

class CreateAdvertViewModel: ViewModel() {
    private val getDateTimeUseCase = GetDateTimeUseCase()
    private val getTextCurrencyInSymbolUseCase = GetTextCurrencyInSymbolUseCase()

    fun createAd(
        context: Context,
        binding: ActivityCreateAdvertBinding
    ) {
        if (
            binding.titleAd.text.isNullOrEmpty() && binding.descriptionAd.text.isNullOrEmpty() &&
            binding.priceAd.text.isNullOrEmpty()
        ) {

        } else {

        }
    }

    fun addImage(
        binding: ActivityCreateAdvertBinding
    ) {
        binding.addImage.setOnClickListener {
            getSpinnerData(
                binding = binding
            )
        }
    }

    fun initSpinner(
        context: Context,
        binding: ActivityCreateAdvertBinding
    ) {
        ArrayAdapter.createFromResource(
            context.applicationContext,
            R.array.array,
            R.layout.item_spinner
        ).also {
                adapterSpinner -> adapterSpinner
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCurrency.adapter = adapterSpinner
        }
    }

    private fun getSpinnerData(
        binding: ActivityCreateAdvertBinding
    ) {
        binding.spinnerCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?,
                                        position: Int, id: Long
            ) {
                println(binding.priceAd.text.toString() +
                        getTextCurrencyInSymbolUseCase.execute(parent?.selectedItem.toString()))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}
