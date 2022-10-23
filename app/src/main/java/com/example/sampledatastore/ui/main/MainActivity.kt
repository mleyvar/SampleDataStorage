package com.example.sampledatastore.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sampledatastore.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val resultObserver = Observer<String> { result ->
        Toast.makeText(this@MainActivity, "VALUES PREFERENCE DATA STORE: $result", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initiListener()
        initLoginObserver()
    }

    private fun initLoginObserver() {
        viewModel.getNameAmount.observe(this, resultObserver)
    }

    private fun initiListener() {
        binding.apply {
            txtPreference.setOnClickListener {
                viewModel.setDataPreference("JHON", 15500.00F)
                Toast.makeText(this@MainActivity, "VALUES PREFERENCE SHARED: ${viewModel.getDataPreference()}", Toast.LENGTH_LONG).show()
            }

            txtDataStore.setOnClickListener {
                CoroutineScope(Dispatchers.Default).launch {
                    viewModel.setDataPreferenceDatStore("PETER", 350.89)
                    viewModel.getDataPreferenceDataStore()
                }
            }
        }
    }
}
