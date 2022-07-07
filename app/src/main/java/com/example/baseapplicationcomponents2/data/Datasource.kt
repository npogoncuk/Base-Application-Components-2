package com.example.baseapplicationcomponents2.data

import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import com.example.baseapplicationcomponents2.model.Contact


class Datasource {
    companion object {
        fun getContacts(context: Context): List<Contact> {
            val contentResolver = context.contentResolver
            val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            val cursor : Cursor = contentResolver.query(uri, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC")!!
            val contacts = mutableListOf<Contact>()
            if (cursor.count > 0) {
                while (cursor.moveToNext())
                    with(cursor) {
                        contacts += Contact(
                            getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                            getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)),
                            getString(getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY)) ?: "",
                            getString(getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS)) ?: ""
                        )
                    }

            }
            return contacts
        }
    }
}