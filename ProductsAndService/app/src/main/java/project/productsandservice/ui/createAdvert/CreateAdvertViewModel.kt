package project.productsandservice.ui.createAdvert

import project.productsandservice.domain.usecase.GetTextCurrencyInSymbolUseCase
import project.productsandservice.databinding.ActivityCreateAdvertBinding
import project.productsandservice.domain.usecase.GetDateTimeUseCase
import androidx.recyclerview.widget.GridLayoutManager
import androidx.lifecycle.ViewModel
import project.productsandservice.R
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import project.productsandservice.data.api.MyAdvertsDataBaseImplement
import project.productsandservice.data.arrays.ImagesArray
import project.productsandservice.data.arrays.UsersArray
import project.productsandservice.domain.models.Advert
import project.productsandservice.domain.models.Status
import project.productsandservice.domain.usecase.AddAdvertUseCase

class CreateAdvertViewModel: ViewModel() {
    private val getDateTimeUseCase = GetDateTimeUseCase()
    private val getTextCurrencyInSymbolUseCase = GetTextCurrencyInSymbolUseCase()
    private val myAdvertsDataBaseImplement = MyAdvertsDataBaseImplement()
    private val addAdvertUseCase = AddAdvertUseCase(myAdvertsDataBaseImplement)
    private val adapterImages = AdapterImages()

    fun createAd(
        binding: ActivityCreateAdvertBinding,
        list: List<Uri>
    ) {
        if (
            isEmptyText(binding = binding)
        ) {
            addAdvertUseCase.execute(
                Advert(
                    title = binding.titleAd.text?.toString()!!,
                    description = binding.descriptionAd.text?.toString()!!,
                    price = getSpinnerData(binding = binding),
                    media_file = listOf(list.toString()),
                    date_added = getDateTimeUseCase.execute(),
                    author_advert = UsersArray.array[0],
                    isStatus = Status.Active
                )
            )
        }
         else {
            binding.titleAd.error = "Вы не ввели название объявления"
            binding.descriptionAd.error = "Вы не ввели описание объявления"
            binding.priceAd.error = "Вы не ввели цену объявления"
        }
    }

    private fun isEmptyText(binding: ActivityCreateAdvertBinding): Boolean {
        return !binding.titleAd.text?.isEmpty()!! && !binding.descriptionAd.text?.isEmpty()!! &&
                !binding.priceAd.text?.isEmpty()!!
    }

    fun initSpinner(
        context: Context,
        binding: ActivityCreateAdvertBinding
    ) {
        ArrayAdapter.createFromResource(
            context.applicationContext,
            R.array.array,
            android.R.layout.simple_spinner_item
        ).also {
                adapterSpinner -> adapterSpinner
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCurrency.adapter = adapterSpinner
        }
    }

    private fun getSpinnerData(
        binding: ActivityCreateAdvertBinding
    ): String = binding.priceAd.text.toString() +
            getTextCurrencyInSymbolUseCase.execute(
                binding.spinnerCurrency.selectedItem.toString()
            )!!


}
