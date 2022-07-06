package com.example.baseapplicationcomponents2.data

import com.example.baseapplicationcomponents2.model.Contact

class Datasource {
    companion object {
        fun getContacts() = listOf(Contact("nazar", "1"), Contact("sasha", "2"),
        Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3"),Contact("nazar", "1"), Contact("sasha", "2"),
            Contact("amamamam", "3")
        )
    }
}