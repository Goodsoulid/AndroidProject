package com.example.androidproject.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.adapter.listener.ItemsListener
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.model.ItemsModel
import com.example.androidproject.utils.BundleConstants.DATE
import com.example.androidproject.utils.BundleConstants.IMAGE_VIEW
import com.example.androidproject.utils.BundleConstants.NAME
import com.example.androidproject.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()
    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)
    }

    override fun itemsReceive(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun itemsClicked(navigationData: NavigateWithBundle) {
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString(NAME, navigationData.name)
            bundle.putString(DATE, navigationData.date)
            bundle.putInt(IMAGE_VIEW, navigationData.image)
            detailsFragment.arguments = bundle

            fmReplace(parentFragmentManager, detailsFragment, true)
    }
}