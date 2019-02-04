package com.oazisn.kalkulator.mainactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.HorizontalScrollView
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import com.oazisn.kalkulator.R


class MainActivity : AppCompatActivity(), MainView {
    private val presenter = MainPresenter(this)
    override fun showShortToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun setRv(text: String) {
        tvResult.text = text
    }

    override fun setScrolling(tv: TextView) {
        tv.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//                    hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                    hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                }
            }
        )    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "0")
        }
        btn1.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "1")
        }
        btn2.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "2")
        }
        btn3.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "3")
        }
        btn4.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "4")
        }
        btn5.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "5")
        }
        btn6.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "6")
        }
        btn7.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "7")
        }
        btn8.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "8")
        }
        btn9.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "9")
        }
        btn0.setOnClickListener {
            presenter.reset()
            setRv(tvResult.text.toString() + "0")
        }
        btnComma.setOnClickListener {
            presenter.comma(tvResult.text.toString())
        }
        btnBackspace.setOnClickListener {
            val str = tvResult.text.toString()
            presenter.backspace(str)
        }
        btnPlus.setOnClickListener {
            presenter.plus(tvResult.text.toString())
        }

        btnMinus.setOnClickListener {
            presenter.minus(tvResult.text.toString())
        }

        btnTimes.setOnClickListener {
            presenter.times(tvResult.text.toString())
        }

        btnDivide.setOnClickListener {
            presenter.divide(tvResult.text.toString())
        }

        btnEquals.setOnClickListener {
            presenter.equals(tvResult.text.toString())
        }
    }
}
