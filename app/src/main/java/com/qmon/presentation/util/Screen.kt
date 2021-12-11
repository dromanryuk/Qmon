package com.qmon.presentation.util

sealed class Screen(val route: String) {
    object Overview: Screen("OverviewScreen")
    object Instruction: Screen("InstructionScreen")
    object Question: Screen("QuestionScreen")
    object DailyBonus: Screen("DailyBonusScreen")
    object Withdrawal: Screen("WithdrawalScreen")
    object LegalInfo: Screen("LegalInfoScreen")
}
