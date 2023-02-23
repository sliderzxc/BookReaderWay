package com.main.books.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.books.R
import com.main.books.data.entities.Book
import com.main.books.databinding.ItemBookBinding

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    private val books = mutableListOf<Book>()

    class BooksViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemBookBinding.bind(view) }
        fun bind(book: Book) {
            binding.tvBookTitle.text = book.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view)
    }


    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size

    fun setNewList(list: List<Book>) {
        books.addAll(list)
        notifyDataSetChanged()
    }
}