package com.main.bookreaderway.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.main.bookreaderway.databinding.ActivityMainBinding
import com.main.bookreaderway.di.provider.ProvideMainComponent
import com.main.core.base.BaseActivity
import com.main.core.navigation.DeepLinks
import com.main.core.viewmodel.CoreViewModel
import com.main.core.viewmodel.CoreViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @Inject
    lateinit var coreViewModelFactory: CoreViewModelFactory
    private val coreViewModel: CoreViewModel by viewModels { coreViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (applicationContext as ProvideMainComponent).provideMainComponent().inject(this)

        val navController = NavController(this)
        if (intent.action == Intent.ACTION_VIEW) {
            Log.d("MyLog", "action")
            coreViewModel.manageIsNeedToGoToBookReadingFragment(true)
            intent.data?.let { uri -> coreViewModel.manageUri(uri) }
        } else {
            Log.d("MyLog", "else")
            coreViewModel.manageIsNeedToGoToBookReadingFragment(false)
        }
    }
}