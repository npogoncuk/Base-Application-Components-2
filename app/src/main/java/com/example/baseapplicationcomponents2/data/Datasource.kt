package com.example.baseapplicationcomponents2.data

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import com.example.baseapplicationcomponents2.model.Contact


class Datasource() {
    companion object {
        var c: List<Contact> = listOf()
        fun getContacts() = c
    }



}