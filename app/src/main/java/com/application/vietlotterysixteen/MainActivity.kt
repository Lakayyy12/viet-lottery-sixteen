package com.application.vietlotterysixteen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var exit = 0
    private var next : TextView? = null
    private var tc : TextView? = null

    private lateinit var myModelList2: ArrayList<MyModel2>
    private lateinit var Adapter2: Adapter2

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next = findViewById(R.id.next)
        next?.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        tc = findViewById(R.id.tc)
        tc?.setOnClickListener{
            val intent = Intent(this, TermsAndPolicy::class.java)
            startActivity(intent)
        }
        //init actionbar
        loadCards()
        //add page change listener
        viewPager20.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //change title of actionbar
                var title = myModelList2[position].title
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

    }
    private fun loadCards() {
        myModelList2 = ArrayList()

        myModelList2.add(MyModel2(
            "Mẹo 1",
            R.string.t1
        ))

        myModelList2.add(MyModel2(
            "Mẹo 2",
            R.string.t2
        ))

        myModelList2.add(MyModel2(
            "Mẹo 3",
            R.string.t3
        ))

        myModelList2.add(MyModel2(
            "Mẹo 4",
            R.string.t4
        ))
        Adapter2 = Adapter2(this, myModelList2)
        viewPager20.adapter=Adapter2
        viewPager20.setPadding(100, 0, 100, 0)
    }

    override fun onBackPressed() {
        if (exit == 0){
            exit = 1
            Toast.makeText(this, "NHẤP VÀO LẠI ĐỂ Thoát", Toast.LENGTH_SHORT).show()
        }else{
            super.finishAffinity()
        }
    }
}