package com.application.vietlotterysixteen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_content_second.*
import kotlinx.android.synthetic.main.card_layout_tips.view.*

class ContentSecondAct : AppCompatActivity() {

    private var content : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_second)

        content = findViewById(R.id.content)

        setContentDetails()
        ret?.setOnClickListener{
            onBackClicked()
        }
    }
    private fun onBackClicked() {
        onBackPressed()
    }
    private fun setContentDetails() {
        content?.text = Html.fromHtml(resources.getString(intent.getIntExtra("content", 0)))
        image?.setBackgroundResource(intent.getIntExtra("image", 0))
    }
}
class MyModel2(var title: String, var description:Int) {
}
class Adapter2(private val context: Context, private val myModelArrayList2: ArrayList<MyModel2>): PagerAdapter() {
    override fun getCount(): Int {
        return myModelArrayList2.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout_tips, container, false)

        val model = myModelArrayList2[position]
        val title = model.title
        val description = context.resources.getString(model.description)

        view.title2.text = title
        view.content2.text = description

        view.setOnClickListener{
            Navigator.showContent(context, "$title \n $description")
        }
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}