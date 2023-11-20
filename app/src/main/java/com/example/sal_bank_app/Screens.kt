package com.example.sal_bank_app

sealed class Screens(val route :String){
    object Home :Screens("Home")

    object Cards :Screens("Cards")
    object Loans :Screens("Loans")
    object LoanCalculator :Screens("LoanCalculator")
    object popup :Screens("popup")

}
