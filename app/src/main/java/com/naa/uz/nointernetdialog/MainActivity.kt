package com.naa.uz.nointernetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.naa.uz.nointernetdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.noInternetBtn.setOnClickListener {
            val beginTransaction = supportFragmentManager.beginTransaction()

            val newInstance = NoInternetDialogFragment.newInstance("Dialog", "Dialog")
            newInstance.show(beginTransaction, "Dialog")

            newInstance.setOnClick(object : NoInternetDialogFragment.OnClick {
                override fun onClick(str: String) {
                    Toast.makeText(this@MainActivity, "$str button clicked", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }


    }
}