package com.oazisn.kalkulator.mainactivity

import android.widget.TextView

interface MainView {
    fun setRv(text : String)
    fun setScrolling(tv : TextView)
    fun showShortToast(text : String)
}