package com.clevmania.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    private lateinit var onBoardPager: ViewPager
    private lateinit var introAdapter: IntroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_intro)
        initViews()
    }

    private fun initViews(){
        tl_indicator.setupWithViewPager(vp_pager)
        vp_pager.adapter = IntroAdapter(this)
    }
}
