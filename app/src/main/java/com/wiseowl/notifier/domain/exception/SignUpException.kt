package com.wiseowl.notifier.domain.exception

class SignUpException: Exception(){
    override val message: String = "Unable to create account${if(!cause?.message.isNullOrEmpty()) " : "+cause?.message else ""}"
}