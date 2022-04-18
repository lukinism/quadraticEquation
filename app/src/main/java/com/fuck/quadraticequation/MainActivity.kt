package com.fuck.quadraticequation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fuck.quadraticequation.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (!isFieldEmpty()){
                val result: String = isResult()
                binding.result.text = result
            }
        }
    }


    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (etA.text.isNullOrEmpty()) etA.error = "Поле должно A быть заполнено"
            if (etB.text.isNullOrEmpty()) etB.error = "Поле должно B быть заполнено"
            if (etC.text.isNullOrEmpty()) etC.error = "Поле должно C быть заполнено"
            return etA.text.isNullOrEmpty() || etB.text.isNullOrEmpty() || etC.text.isNullOrEmpty()
        }
    }

    private fun isResult(): String {
        val a: Double
        val b: Double
        val c: Double
        binding.apply {
            a = etA.text.toString().toDouble()
            b = etB.text.toString().toDouble()
            c = etC.text.toString().toDouble()
        }
        val discriminant: Double = (b.pow(2) - (4 * a * c))
        var result = String()
        if (discriminant < 0) result = "Дискриминант равен ${discriminant}. Решений нет."
        if (discriminant == 0.toDouble()) result = "Дискриминант равен ${discriminant}.\nx1 =${-b / (2 * a)}"
        if (discriminant > 0.toDouble()) result  = "Дискриминант равен ${discriminant}.\nx1 =${(-b - sqrt(discriminant)) / (2 * a)}\nx2 =${(-b + sqrt(discriminant)) / (2 * a)}"

        return result
    }
}