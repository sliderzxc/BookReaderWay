package com.main.books.di.component

import com.main.books.presentation.ui.BooksFragment
import com.main.core.di.modules.CoreModule
import dagger.Component

@Component(modules = [CoreModule::class])
interface BooksComponent {
    fun inject(booksFragment: BooksFragment)
}