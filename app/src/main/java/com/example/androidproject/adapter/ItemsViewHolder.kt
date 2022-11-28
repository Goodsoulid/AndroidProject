package com.example.androidproject.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.listener.ItemsListener
import com.example.androidproject.model.ItemsModel
import org.w3c.dom.Text

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
): RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.textView2)
        val imageView = view.findViewById<ImageView>(R.id.image)
        val date = view.findViewById<TextView>(R.id.textView3)

        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        date.text = itemsModel.date

        imageView.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image,
            )
        }
    }
}