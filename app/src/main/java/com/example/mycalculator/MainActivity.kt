package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        castViews()




      binding.btnadd.setOnClickListener {
          validate("+")
      }
      binding.btnsubtract.setOnClickListener {
          validate("-")
      }
      binding.btnmultiply.setOnClickListener {
          validate("*")
      }
      binding.btnmodulus.setOnClickListener {
          validate("/")
      }
  }

    fun validate(sign: String) {
        val num1Str = binding.etnum1.text.toString()
        val num2Str = binding.etnum2.text.toString()



        var inputError = false
        if (num1Str.isBlank()) {
            inputError = true
            binding.etnum1.error = "Num 1 is required"
        }

        if (num2Str.isBlank()) {
            inputError = true
            binding.etnum2.error = "Num 2 is required"
        }


        if (!inputError) {
            calculate(num1Str.toDouble(), num2Str.toDouble(), sign)
        }
    }
    fun calculate(num1:Double,num2:Double,sign:String){

        var result = 0.0

        when(sign){
            "+"->result= num1+num2
            "-"->result= num1-num2
            "*"->result= num1*num2
            "/"->result= num1/num2
        }
        binding.tvresults.text = result.toString()
    }
}









