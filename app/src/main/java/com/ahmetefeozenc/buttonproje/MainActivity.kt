package com.ahmetefeozenc.buttonproje

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.ahmetefeozenc.buttonproje.appHelper.Companion.IntentOluştur
import com.ahmetefeozenc.buttonproje.appHelper.Companion.toastmsg
import com.ahmetefeozenc.buttonproje.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adtxt: EditText
    lateinit var soyadtxt: EditText
    lateinit var yastxt: EditText
    lateinit var database: SQLiteDatabase
    lateinit var kaydetbtn: Button
    lateinit var guncellesayfabtn: Button
    lateinit var silsayfabtn: Button
    lateinit var myDataBase:myDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view =binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        adtxt=binding.adtxt
        soyadtxt=binding.soyadtxt
        yastxt=binding.yastxt
        kaydetbtn=binding.kaydetbtn
        silsayfabtn=binding.silsayfabtn
        guncellesayfabtn=binding.guncellesayfabtn
        myDataBase=myDataBase()


        myDataBase.VeriTabaniOlustur(this)

        kaydetbtn.setOnClickListener(){
            val ad = adtxt.text.toString()
            val soyad = soyadtxt.text.toString()
            val yas = yastxt.text.toString().toIntOrNull()

            if (yas != null) {
                myDataBase.ekleKullanici(ad,soyad,yas,this)
            }
        }
        guncellesayfabtn.setOnClickListener(){
            IntentOluştur(this,MainActivity3::class.java)
        }
        silsayfabtn.setOnClickListener(){
            IntentOluştur(this,MainActivity2::class.java)
        }

    }

}