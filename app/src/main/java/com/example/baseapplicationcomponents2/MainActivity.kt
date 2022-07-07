package com.example.baseapplicationcomponents2

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.baseapplicationcomponents2.data.Datasource
import com.example.baseapplicationcomponents2.model.Contact


class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        requestReadContactPermission()

        getContactList()
        Datasource.c = contactList


    }

    private fun requestReadContactPermission() {
        while (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.READ_CONTACTS),
                888
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    var contactList: ArrayList<Contact> = ArrayList()

    private val PROJECTION = arrayOf(
        ContactsContract.RawContacts._ID,
        ContactsContract.Contacts.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Organization.COMPANY,
        ContactsContract.CommonDataKinds.Email.DATA
    )

    private fun getContactList() {
        val cr = contentResolver
        val cursor: Cursor? = cr.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            PROJECTION,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        if (cursor != null) {
            val mobileNoSet = HashSet<String>()
            try {
                val nameIndex: Int = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val numberIndex: Int =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val organizationIndex: Int = cursor.getColumnIndex(PROJECTION[3])
                val emailIndex: Int = cursor.getColumnIndex(PROJECTION[4])
                var name: String
                var number: String
                var organization: String
                var email: String
                while (cursor.moveToNext()) {
                    name = cursor.getString(nameIndex)
                    number = cursor.getString(numberIndex)
                    number = number.replace(" ", "")
                    organization = cursor.getString(organizationIndex)
                    email = cursor.getString(emailIndex)
                    if (!mobileNoSet.contains(number)) {
                        contactList.add(Contact(name, number, organization, email))
                        mobileNoSet.add(number)
                        Log.d(
                            "MyContact", "onCreaterrView  Phone Number: name = " + name
                                    + " No = " + number + " Organization " + organization + " Email " + email
                        )
                    }
                }
            } finally {
                cursor.close()
            }
        }
    }

}