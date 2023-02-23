package com.main.bookreading.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.bookreading.R
import com.main.bookreading.databinding.FragmentReadingBookBinding
import com.main.core.base.BaseFragment

class ReadingBookFragment : BaseFragment() {
    private val binding by lazy { FragmentReadingBookBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}