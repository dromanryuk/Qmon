package com.qmon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.qmon.presentation.components.DefaultScaffold
import com.qmon.presentation.components.InternetConnectionDialog
import com.qmon.presentation.daily_bonus.DailyBonusScreen
import com.qmon.presentation.instruction.InstructionScreen
import com.qmon.presentation.overview.OverviewScreen
import com.qmon.presentation.question.QuestionScreen
import com.qmon.presentation.util.Screen
import com.qmon.presentation.withdrawal.WithdrawalScreen
import com.qmon.ui.theme.QmonTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreenContent()
        initializeAppodeal()
    }

    @OptIn(ExperimentalFoundationApi::class)
    private fun setScreenContent() {
        setContent {
            val navController = rememberNavController()
            QmonTheme {
                DefaultScaffold(
                    navigateToInstructionScreen = {
                        navController.navigate(
                            Screen.Instruction.route,
                            navOptions { launchSingleTop = true }
                        )
                    }
                ) {
                    CompositionLocalProvider(LocalOverScrollConfiguration provides null) {
                        NavGraph(navController)
                    }
                }
                InternetConnectionDialog()
            }
        }
    }

    @Composable
    fun NavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Overview.route
        ) {
            composable(Screen.Overview.route) {
                OverviewScreen(
                    navigateToQuestionScreen = { navController.navigate(Screen.Question.route) },
                    navigateToDailyBonusScreen = { navController.navigate(Screen.DailyBonus.route) },
                    navigateToWithdrawalScreen = { navController.navigate(Screen.Withdrawal.route) },
                )
            }
            composable(Screen.Instruction.route) {
                InstructionScreen()
            }
            composable(Screen.DailyBonus.route) {
                DailyBonusScreen()
            }
            composable(Screen.Withdrawal.route) {
                WithdrawalScreen()
            }
            composable(Screen.Question.route) {
                QuestionScreen()
            }
        }
    }
}
