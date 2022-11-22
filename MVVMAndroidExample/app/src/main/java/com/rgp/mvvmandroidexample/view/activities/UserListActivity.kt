package com.rgp.mvvmandroidexample.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.mvvmandroidexample.R
import com.rgp.mvvmandroidexample.databinding.ActivityUserListBinding
import com.rgp.mvvmandroidexample.view.fragments.ListFragment

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
            .commit()
    }
}