package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.toaast)

        var welcome = findViewById<Button>(R.id.w1)
        var Default = findViewById<Button>(R.id.D1)
        var Button = findViewById<Button>(R.id.B1)
        var next=findViewById<Button>(R.id.next)

        welcome.setOnClickListener{
            Toast.makeText(this,"❤️Welcome" ,Toast.LENGTH_SHORT).show()

        }
        Default.setOnClickListener{
            Toast.makeText(this,"Default",Toast.LENGTH_LONG).show()
        }

        Button.setOnClickListener{
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show()

        }

        next.setOnClickListener{
            val intent = Intent(this@MainActivity, MainActivity1::class.java)
            startActivity(intent)
            finish()
        }

    }
}
