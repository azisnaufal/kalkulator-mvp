package com.oazisn.kalkulator.mainactivity

import com.oazisn.kalkulator.dao.Bil
import java.lang.StringBuilder
import java.text.DecimalFormat

class MainPresenter(private var view : MainView){
    private var bilangan1 : Bil = Bil("", ' ')
    private var bilangan2 : Bil = Bil("", ' ')
    private var comma = false
    private var operation = false
    private var equals = false


    private fun hitung(bil1 : Float, bil2 : Float) : Float{
        when (bilangan1.operasi){
            '+' -> return bil1 + bil2
            '-' -> return bil1 - bil2
            '*' -> return bil1 * bil2
            '/' -> return bil1 / bil2
        }
        return 0.0f
    }
    
    fun divide (tvResult: String){
        if (bilangan1.operasi != ' ')
        {
            bilangan2.bilangan = tvResult

            val bil1  = bilangan1.bilangan.toFloat()
            val bil2 = bilangan2.bilangan.toFloat()
            val nf = DecimalFormat("#.####")

            view.setRv(nf.format(hitung(bil1, bil2)))
        }
        operation = true
        bilangan1.bilangan = tvResult
        bilangan1.operasi = '/'

    }
    
    fun equals (tvResult : String){
        operation = false
        bilangan2.bilangan = tvResult

        val bil1  = bilangan1.bilangan.toFloat()
        val bil2 = bilangan2.bilangan.toFloat()
        val nf = DecimalFormat("#.####")
        bilangan1.bilangan = nf.format(hitung(bil1, bil2))
        bilangan1.operasi = ' '
        view.setRv(bilangan1.bilangan)
    }
    
    fun minus(tvResult : String){
        if (bilangan1.operasi != ' ')
        {
            bilangan2.bilangan = tvResult

            val bil1  = bilangan1.bilangan.toFloat()
            val bil2 = bilangan2.bilangan.toFloat()

            val nf = DecimalFormat("#.####")

            view.setRv(nf.format(hitung(bil1, bil2)))
        }
        operation = true
        bilangan1.bilangan = tvResult
        bilangan1.operasi = '-'
    }
    
    fun times(tvResult: String){
        if (bilangan1.operasi != ' ')
        {
            bilangan2.bilangan = tvResult

            val bil1  = bilangan1.bilangan.toFloat()
            val bil2 = bilangan2.bilangan.toFloat()
            val nf = DecimalFormat("#.####")

            view.setRv(nf.format(hitung(bil1, bil2)))
        }
        operation = true
        bilangan1.bilangan = tvResult
        bilangan1.operasi = '*'
    }
    
    fun plus(tvResult : String){
        if (bilangan1.operasi != ' ')
        {
            bilangan2.bilangan = tvResult

            val bil1  = bilangan1.bilangan.toFloat()
            val bil2 = bilangan2.bilangan.toFloat()

            val nf = DecimalFormat("#.####")

            view.setRv(nf.format(hitung(bil1, bil2)))
        }
        operation = true
        bilangan1.bilangan = tvResult
        bilangan1.operasi = '+'
    }
    
    fun backspace(tvResult : String){
        if (tvResult != ""){
            val strB = StringBuilder(tvResult)
            if (tvResult.toCharArray()[tvResult.length-1].equals('.'))  comma = false

            strB.deleteCharAt(tvResult.length-1)
            view.setRv(strB.toString())
        }
        else {
            bilangan1.bilangan = ""
            bilangan1.operasi = '-'

            bilangan2.bilangan = ""
            bilangan2.operasi = '-'

            comma = false
            operation = false
            equals = false

            view.showShortToast("Cleared!")
        }
    }

    fun reset(){
        if (operation){
            operation = false
            view.setRv(" ")
        }
    }

    fun comma(text : String){
        if (!comma){
            view.setRv("$text.")
            comma = true
        }
    }
}