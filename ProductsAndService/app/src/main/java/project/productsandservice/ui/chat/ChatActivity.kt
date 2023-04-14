package project.productsandservice.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private lateinit var viewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        viewModel.initRV(
            context = this.applicationContext,
            binding = binding
        )
        viewModel.setMessage(
            binding = binding
        )
        viewModel.isConnected(
            context = applicationContext,
            binding = binding
        )
    }
}
