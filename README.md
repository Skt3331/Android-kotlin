
# Android Start with Kotlin

1) Spalsh screen
https://github.com/airbnb/lottie/blob/master/android.md

![image](https://github.com/user-attachments/assets/2bc3c901-287e-4b32-8bfc-476006c71f92)

it include .json of loading screen and add delay using thread


2) Explore default and Custome Toast use repo

https://github.com/Shashank02051997/FancyToast-Android

![image](https://github.com/user-attachments/assets/9febda11-33a3-4d36-9542-49924248e1a1)

3) Explore menu with menu icon

create a seprate kotlin class and import into Activity

   package com.example.myapplication

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class MenuContent {
    fun customMenu(context: Context, view: View) {
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu)
        pop.setOnMenuItemClickListener {

            when (it!!.itemId) {
                R.id.open -> {
                    Toast.makeText(context, "Open File Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.edit -> {
                    Toast.makeText(context, "Edit menu clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.rename -> {
                    Toast.makeText(context, "Rename is Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.delete -> {
                    Toast.makeText(context, "Delete is Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        try {
            val fieldMpopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMpopup.isAccessible = true
            val mPopup = fieldMpopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            pop.show()
        }
    }
}
package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity1 : AppCompatActivity() {
    
    val customme=com.example.myapplication.MenuContent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main1)
       val showPopUp=findViewById<Button>(R.id.menub)
        showPopUp.setOnClickListener()
        {
            customme.customMenu(this,it)
        }
    }
}

   ![image](https://github.com/user-attachments/assets/e2c66c8d-7fe3-479f-b7e9-37f82870e85a)

   
