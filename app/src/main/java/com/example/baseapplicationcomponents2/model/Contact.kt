package com.example.baseapplicationcomponents2.model

data class Contact(
    val name: String,
    val number: String,
    val organization: String = "Contact has no organization",
    val email: String = "Contact has no email"
)