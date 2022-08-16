package com.application.vietlotterysixteen

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.card_layout_guides.*
import com.application.vietlotterysixteen.Navigator.Companion.openPage
import kotlinx.android.synthetic.main.activity_content_second.*

class SecondActivity : AppCompatActivity(), OnContentClickListener, View.OnClickListener {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private val onItemClicked by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initRecyclerView()
        initOnClicked()
    }
    private fun initRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = AdapterMo(onItemClicked)
    }
    private fun initOnClicked(){
        cardView?.setOnClickListener(){
            openPage(this, ContentSecondAct::class.java)
        }
    }
    override fun OnContentItemClicked(content: Int, image: Int) {
        openPage(this, ContentSecondAct::class.java, content, image)
    }

    override fun openPage() {
        TODO("Not yet implemented")
    }

    override fun onClick(p0: View?) {
    }
}