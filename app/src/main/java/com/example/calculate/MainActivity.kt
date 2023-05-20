package com.example.calculate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculate.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
   private val expressionTextView:TextView by lazy {
       findViewById<TextView>(R.id.result)
   }

    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(v: View){
        when (v.id) {
            R.id.button0 -> numberButtonClicked("0")
            R.id.button1 -> numberButtonClicked("1")
            R.id.button2 -> numberButtonClicked("2")
            R.id.button3 -> numberButtonClicked("3")
            R.id.button4 -> numberButtonClicked("4")
            R.id.button5 -> numberButtonClicked("5")
            R.id.button6 -> numberButtonClicked("6")
            R.id.button7 -> numberButtonClicked("7")
            R.id.button8 -> numberButtonClicked("8")
            R.id.button9 -> numberButtonClicked("9")
            R.id.buttondot -> numberButtonClicked(".")

            R.id.buttonplus -> operatorButtonClicked("+")
            R.id.buttonminus -> operatorButtonClicked("-")
            R.id.buttonmulti -> operatorButtonClicked("X")
            R.id.buttondiv -> operatorButtonClicked("/")

        }
    }

    private fun numberButtonClicked(number: String) {
        if (isOperator) {
            expressionTextView.append(" ")
        }
        isOperator = false

        val expressionText = expressionTextView.text.split(" ")

        expressionTextView.append(number)
        result.text = calculateExpression()
    }
    private fun operatorButtonClicked(operator: String) {
        if (expressionTextView.text.isEmpty()) {
            return
        }

        when {
            isOperator -> {
                val text = expressionTextView.text.toString()
//                expressionTextView.text = text.dropLast(1) + operator
            }
            else -> {
                expressionTextView.append(" $operator")
            }

        }




    }