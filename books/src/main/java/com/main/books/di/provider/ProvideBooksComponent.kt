package com.main.books.di.provider

import com.main.books.di.component.BooksComponent

interface ProvideBooksComponent {
    fun provideBooksComponent(): BooksComponent
}