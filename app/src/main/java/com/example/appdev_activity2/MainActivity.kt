package com.example.appdev_activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.graphics.Color
import com.example.appdev_activity2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private var greetings = "Ohaiyo!!"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val fName = binding.FnameTxt.text.toString()
            val lName = binding.LnameTxt.text.toString()
            val mInit = binding.MnameTxt.text.toString()

            if (fName.isNotEmpty() && lName.isNotEmpty() && mInit.isNotEmpty()) {
                binding.outputTxt.text = "$greetings\n$fName $mInit $lName"

            } else {
                Toast.makeText(this, "Don't Leave it blank", Toast.LENGTH_SHORT).show()
                binding.outputTxt.text = "Please Don't leave it blank"
                binding.FnameTxt.text.clear()
                binding.LnameTxt.text.clear()
                binding.MnameTxt.text.clear()
            }

        }

        binding.btnColor1.setOnClickListener{
            btnColorChange(Color.RED)
            binding.btnColor1.setBackgroundColor(Color.RED)
        }
        binding.btnColor2.setOnClickListener {
            btnColorChange(Color.BLUE)
            binding.btnColor2.setBackgroundColor(Color.BLUE)
        }
        binding.btnColor3.setOnClickListener {
            btnColorChange(Color.GREEN)
            binding.btnColor3.setBackgroundColor(Color.GREEN)
        }

        binding.btnFont1.setOnClickListener {
            txtSizeChange(34f)
        }
        binding.btnFont2.setOnClickListener {
            txtSizeChange(24f)
        }
        binding.btnFont3.setOnClickListener {
            txtSizeChange(20f)
        }

        binding.txtGreetings1.setOnClickListener {
            greetingsChanger("Hajimemashite!!")
        }
        binding.txtGreetings2.setOnClickListener {
            greetingsChanger("Kawaii!!")
        }
        binding.txtGreetings3.setOnClickListener {
            greetingsChanger("Senpai!!")
        }
    }

    private fun greetingsChanger(greetingsNew: String){
        greetings = greetingsNew

        val oldtxt = binding.outputTxt.text.toString()
        if (oldtxt.isNotBlank()) {
            //split() function returns a list of outputTxt
            val parts = oldtxt.split("\n")
            if (parts.size > 1) {
                binding.outputTxt.text = "$greetings\n${parts[1]}"
            }
        }
    }

    private fun btnColorChange(color: Int) {
        binding.outputTxt.setTextColor(color)
    }

    private fun txtSizeChange(size: Float) {
        binding.outputTxt.textSize = size
    }
}