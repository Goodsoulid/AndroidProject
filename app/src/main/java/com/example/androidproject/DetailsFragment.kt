package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.androidproject.BundleConstants.IMAGE_VIEW


class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString(NAME)
            val date = safeBundle.getString(ItemsFragment.Companion.DATE)
            val image = safeBundle.getInt(IMAGE_VIEW)

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }
    }
}