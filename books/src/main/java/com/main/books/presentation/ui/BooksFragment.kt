package com.main.books.presentation.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.main.books.R
import com.main.books.data.entities.Book
import com.main.books.databinding.FragmentBooksBinding
import com.main.books.di.provider.ProvideBooksComponent
import com.main.books.presentation.adapter.BooksAdapter
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.core.viewmodel.CoreViewModel
import com.main.core.viewmodel.CoreViewModelFactory
import javax.inject.Inject

class BooksFragment : BaseFragment() {
    private val binding by lazy { FragmentBooksBinding.inflate(layoutInflater) }
    @Inject
    lateinit var coreViewModelFactory: CoreViewModelFactory
    private val coreViewModel: CoreViewModel by activityViewModels { coreViewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideBooksComponent).provideBooksComponent().inject(this)
        Log.d("MyLog", "value: ${coreViewModel.valueIsNeedToGoToBookReadingFragment()}")
//        if (coreViewModel.valueIsNeedToGoToBookReadingFragment() == true) {
//            val navOptions = NavOptions.Builder().setPopUpTo(R.id.booksNavGraph, true).build()
//            findNavController().navigate(DeepLinks.BOOK_READING_DEEP_LINK, navOptions)
//        }
        val adapter = BooksAdapter()
        binding.rvBooks.adapter = adapter
        adapter.setNewList(listOf(
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 1", "PDF", "14 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 2","PDF", "13 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 3","PDF", "14 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 1","PDF","14 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 2","PDF", "12 MB"),
            Book("Чистая архитектура. Искусство разработки програмного обеспечения 3","PDF", "19 MB"),
        ))
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.booksNavGraph, true).build()
        findNavController().navigate(DeepLinks.BOOK_READING_DEEP_LINK, navOptions)
    }
}