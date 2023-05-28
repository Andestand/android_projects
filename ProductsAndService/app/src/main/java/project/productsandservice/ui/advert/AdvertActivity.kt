package project.productsandservice.ui.advert

import project.productsandservice.databinding.ActivityAdvertBinding
import project.productsandservice.domain.models.Advert
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.R
import android.view.MenuItem
import android.widget.Toast
import android.view.Menu
import android.os.Bundle
import android.util.Log
import project.productsandservice.data.api.MyAdvertsDataBaseImplement
import project.productsandservice.domain.usecase.AddAdvertUseCase
import project.productsandservice.domain.usecase.ChangeAdvertUseCase
import project.productsandservice.domain.usecase.DeleteAdvertUseCase

class AdvertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvertBinding
    private lateinit var viewModel: AdvertViewModel
    private val myAdvertsDataBaseImplement = MyAdvertsDataBaseImplement()
    private val deleteAdvertUseCase = DeleteAdvertUseCase(myAdvertsDataBaseImplement)
    private val changeAdvertUseCase = ChangeAdvertUseCase(myAdvertsDataBaseImplement)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AdvertViewModel::class.java]
        setSupportActionBar(binding.toolbarAdverts)

        viewModel.addAdvert(
            context = applicationContext,
            ad = intent.getSerializableExtra("ad") as Advert,
            binding = binding
        )
        viewModel.initRV(
            context = applicationContext,
            binding = binding
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.advert_menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.deleteAdvert -> {
                deleteAdvertUseCase.execute(
                    intent.getSerializableExtra("ad") as Advert
                )
            }
            R.id.changeAdvert -> {
                changeAdvertUseCase.execute(
                    intent.getSerializableExtra("ad") as Advert
                )
            }
            R.id.toArchiveAdvert -> {

            }
            R.id.deArchiveAdvert -> {

            }
        }
        return true
    }
}
