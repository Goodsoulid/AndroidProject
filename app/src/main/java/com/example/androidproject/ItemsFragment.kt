package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.listener.ItemsListener
import com.example.androidproject.model.ItemsModel

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2023"

            ),
            ItemsModel(R.drawable.ios,
                "Ios",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.flutter,
                "Flutter",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.xamarin,
                "Xamarin",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                ".NET",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "C++",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "Goland",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "Ruby on Rains",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "JS",
                "26.02.2023"
            ),
        )

        itemsAdapter.submitList(listItems)



    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked",Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name) //передавать аргументы из фрагмента
        bundle.putString("date", date)
        bundle.putInt("ImageView", imageView)
        detailsFragment.arguments = bundle

        //TODO add метод мы больше не используем
        //теперь мы всегда будем использовать replace
        //replace всегда будет иметь или addToBackStack, чтобы
        //мочь вернуться назад или де его не будет, чтобы
        //мы вернулись назад.
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container,detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}