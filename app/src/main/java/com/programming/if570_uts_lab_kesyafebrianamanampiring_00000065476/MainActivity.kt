package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            textInputName.addTextChangedListener(textWatcher)

            btnLogin.setOnClickListener {
                if (textInputName.text.isNullOrEmpty()) {
                    textInputLayoutName.error = "This field is required!"
                    Toast.makeText(this@MainActivity, "Name cannot be empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else {
                    textInputLayoutName.error = null
                }

                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("name", textInputName.text.toString())
                startActivity(intent)
            }

        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            // Enable the login button if both fields are not empty
            binding.btnLogin.isEnabled = !binding.textInputName.text.isNullOrEmpty()
        }
    }
}