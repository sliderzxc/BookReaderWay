package com.main.bookreaderway.di.component

import com.main.bookreaderway.presentation.ui.MainActivity
import com.main.core.di.modules.CoreModule
import dagger.Component

@Component(modules = [CoreModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}