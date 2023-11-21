package com.example.sal_bank_app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.compose.rememberNavController

sealed class Screens(val route :String){
    object Home :Screens("Home")

    object Cards :Screens("Cards")
    object Loans :Screens("Loans")
    object LoanCalculator :Screens("LoanCalculator")
    object cards_screen :Screens("cards_screen")
    object popup :Screens("popup")
}
