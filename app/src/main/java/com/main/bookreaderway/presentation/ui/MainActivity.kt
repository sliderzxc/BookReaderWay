package com.main.bookreaderway.presentation.ui

import android.os.Bundle
import com.main.bookreaderway.databinding.ActivityMainBinding
import com.main.core.base.BaseActivity

class MainActivity : BaseActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}