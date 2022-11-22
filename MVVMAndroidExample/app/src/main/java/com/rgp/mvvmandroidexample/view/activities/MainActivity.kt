package com.rgp.mvvmandroidexample.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.mvvmandroidexample.databinding.ActivityDetailBinding
import com.rgp.mvvmandroidexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = "Hola, viewBinding!"
        binding.tvTitle2.text = "Hola nombre con camelCase!! :D"
        binding.tvTitle3.text = "Tercias!"
        binding.tvTitle4.text = "Cuartas!!"
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.tvTitle.text = "ON RESUME"
    }
}