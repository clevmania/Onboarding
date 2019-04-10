package com.clevmania.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    private var currentPage: Int = 0
    private lateinit var slidePageListener: ViewPager.OnPageChangeListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_intro)
        initViews()
        onNextButtonClicked()
        setupPageChangeListener()
    }

    private fun initViews(){
        tl_indicator.setupWithViewPager(vp_pager)
        vp_pager.adapter = IntroAdapter(this)
    }

    private fun onNextButtonClicked(){
        btn_next.setOnClickListener {
            val currentItem = getItem(+1)
            if (currentItem < 4) {
                vp_pager.currentItem = currentItem
            }
        }

        btn_start.setOnClickListener {
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupPageChangeListener(){
        slidePageListener = object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                currentPage = position

                when (currentPage) {
                    3 -> {
                        btn_next.visibility = View.INVISIBLE
                        tl_indicator.visibility = View.INVISIBLE
                        btn_start.visibility = View.VISIBLE
                        btn_start.animation = AnimationUtils.loadAnimation(applicationContext,R.anim.btn_animation)
                    }
                    else -> {
                        btn_next.visibility = View.VISIBLE
                        tl_indicator.visibility = View.VISIBLE
                        btn_start.visibility = View.INVISIBLE
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        }

        vp_pager.addOnPageChangeListener(slidePageListener)
    }

    private fun getItem(i: Int): Int {
        return vp_pager.currentItem + i
    }
}
