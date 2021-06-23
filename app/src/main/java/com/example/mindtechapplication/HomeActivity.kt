package com.example.mindtechapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.adapter.CursolAapter
import com.example.mindtechapplication.adapter.ListItemsAdapter
import kotlinx.android.synthetic.main.activity_home.*
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViewpager()
initRecyclerView()
    }
    fun initViewpager() {
        val arrayListOf = arrayListOf(R.drawable.on, R.drawable.yug_1)
        val cursolAapter = CursolAapter(this, arrayListOf)
        viewpager.adapter = cursolAapter
    }
    fun initRecyclerView() {
        val arrayListOf =
            arrayListOf<String>("ONe", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine","Ten","Eleven","Tweleve","Thirteen","Fourtin","Fifteen","Sventeen")
        val listItemsAdapter = ListItemsAdapter(this, arrayListOf)
        rv_view.layoutManager=LinearLayoutManager(this)
        rv_view.adapter=listItemsAdapter
    }
}