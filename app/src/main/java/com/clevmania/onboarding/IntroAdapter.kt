package com.clevmania.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter

class IntroAdapter(private val context : Context): PagerAdapter() {
    private lateinit var slideImage: ImageView
    private lateinit var header: TextView
    private lateinit var body: TextView
    private lateinit var slideContainer : ConstraintLayout

    //Background Image Array
    private val sliderBackground = intArrayOf(R.drawable.boiling_food,
        R.drawable.ocha_cluster_food, R.drawable.hamburger_xxl, R.drawable.chinese_food)

    private val sliderHeader = arrayOf("Join the Community",
        "Find Classic Meals", "Caribbean blue hamburger", "Exquisite Chinese")

    private val sliderBody = arrayOf(context.getString(R.string.on_board_msg),
        context.getString(R.string.on_board_msg),
        context.getString(R.string.on_board_msg),
        context.getString(R.string.on_board_msg))

    override fun getCount(): Int {
        return sliderBackground.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_intro_slider, container, false)

        slideImage = view.findViewById(R.id.iv_slider)
        header = view.findViewById(R.id.tv_header)
        body = view.findViewById(R.id.tv_body)
        slideContainer = view.findViewById(R.id.cl_slide_container)

        slideImage.setBackgroundResource(sliderBackground[position])
        header.text = sliderHeader[position]
        body.text = sliderBody[position]

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}