package com.example.mindtechapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mindtechapplication.adapter.CarouselAdapter
import com.example.mindtechapplication.adapter.ListItemsAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViewpager()
        initRecyclerView()
    }

    private fun initViewpager() {
        val arrayListOf = arrayListOf(R.drawable.on, R.drawable.yug)
        val carouselAdapter = CarouselAdapter(this, arrayListOf)
        viewpager.adapter = carouselAdapter
    }

    private fun initRecyclerView() {
        val arrayListOf =
            arrayListOf(
                "Afghanistan",
                "Albania",
                "Algeria",
                "Andorra",
                "Angola",
                "Antigua and Barbuda",
                "Argentina",
                "Armenia",
                "Australia",
                "Austria",
                "Austrian Empire",
                "Azerbaijan",
                "Baden",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Bavaria",
                "Belarus",
                "Belgium",
                "Belize",
                "Benin",
                "Bolivia",
                "Bosnia",
                "Botswana",
                "Brazil",
                "Brunei",
                "Brunswick",
                "Bulgaria"
            )
        val listItemsAdapter = ListItemsAdapter(this, arrayListOf)
        rv_view.layoutManager = LinearLayoutManager(this)
        rv_view.adapter = listItemsAdapter
        TabLayoutMediator(tl_main, viewpager) { tab, position ->
        }.attach()
        sv_main.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listItemsAdapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun toString(): String {
        return "HomeActivity()"
    }
}