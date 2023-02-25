package com.main.bookreaderway.app

import android.app.Application
import com.main.bookreaderway.di.component.DaggerMainComponent
import com.main.bookreaderway.di.component.MainComponent
import com.main.bookreaderway.di.provider.ProvideMainComponent
import com.main.books.di.component.BooksComponent
import com.main.books.di.component.DaggerBooksComponent
import com.main.books.di.provider.ProvideBooksComponent
import com.main.core.di.modules.CoreModule

class Application : Application(), ProvideBooksComponent, ProvideMainComponent {

    private val mainComponent by lazy {
        DaggerMainComponent
            .builder()
            .coreModule(CoreModule())
            .build()
    }

    private val booksComponent by lazy {
        DaggerBooksComponent
            .builder()
            .coreModule(CoreModule())
            .build()
    }

    override fun provideMainComponent(): MainComponent = mainComponent

    override fun provideBooksComponent(): BooksComponent = booksComponent
}