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
