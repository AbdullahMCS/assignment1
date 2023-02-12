package com.example.assignment

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityContactListBinding

class ContactListActivity : AppCompatActivity() {

    lateinit var binding: ActivityContactListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hasReadContactsPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_CONTACTS
        )
        Log.d("TAG", "onCreate: checkSelfPermission returned $hasReadContactsPermission")

        if (hasReadContactsPermission == PackageManager.PERMISSION_GRANTED) {
            Log.d("TAG", "onCreate: requesting permission")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }

        binding.btnRefresh.setOnClickListener {
            Log.d("TAG", "refresh")
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val projection = arrayOf(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);


                val cursor = contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    projection,
                    null,
                    null,
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
                )

                val contacts = ArrayList<String>()
                cursor?.use {
                    while (it.moveToNext()) {
                        contacts.add(it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)))
                    }
                }

                Log.d("TAG", contacts.toString())

                val adapter = ArrayAdapter(this, R.layout.contact_detail, R.id.contact_name, contacts)
                binding.contactList.adapter = adapter
            }
        }

    }
}