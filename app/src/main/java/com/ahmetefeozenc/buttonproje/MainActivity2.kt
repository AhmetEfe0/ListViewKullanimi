package com.ahmetefeozenc.buttonproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.ahmetefeozenc.buttonproje.appHelper.Companion.IntentOluştur
import com.ahmetefeozenc.buttonproje.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var liste: ListView
    lateinit var islemidtxt2:EditText
    lateinit var silbtn2: Button
    lateinit var myDataBase:myDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        var view =binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        liste=binding.liste
        islemidtxt2=binding.islemidtxt2
        silbtn2=binding.silbtn2
        myDataBase=myDataBase()

        myDataBase.Listle(this, liste)

        silbtn2.setOnClickListener(){
            val id =islemidtxt2.text.toString().toIntOrNull()
            if (id != null) {
                myDataBase.kullaniciSil(id,this)
            }
            myDataBase.Listle(this, liste)
        }


    }
}