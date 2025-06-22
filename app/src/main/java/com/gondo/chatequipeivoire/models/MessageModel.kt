package com.gondo.chatequipeivoire.models

data class MessageModel(
    val sender:String,
    val receiver:String,
    val text:String,
    val heure:Long,
    val isReceived:Boolean=true
)