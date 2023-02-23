package com.main.books.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.books.data.entities.Book
import com.main.books.databinding.FragmentBooksBinding
import com.main.books.presentation.adapter.BooksAdapter
import com.main.core.base.BaseFragment

class BooksFragment : BaseFragment() {
    private val binding by lazy { FragmentBooksBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BooksAdapter()
        binding.rvBooks.adapter = adapter
        adapter.setNewList(listOf(
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 1", "PDF", "14MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 2","PDF", "13 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 3","PDF", "14 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 1","PDF","14 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 2","PDF", "12 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 3","PDF", "19 MB"),
        ))
    }
}