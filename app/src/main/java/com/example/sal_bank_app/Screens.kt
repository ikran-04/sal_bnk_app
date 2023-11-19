package com.example.sal_bank_app

sealed class Screens(val route :String){
    object Home :Screens("Home")

    object Cards :Screens("Cards")
    object Wallet :Screens("Wallet")

}
