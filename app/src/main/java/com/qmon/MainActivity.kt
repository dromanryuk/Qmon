package com.qmon

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qmon.domain.model.Question
import com.qmon.domain.util.readJsonFile
import com.qmon.presentation.components.InternetConnectionDialog
import com.qmon.presentation.daily_bonus.DailyBonusScreen
import com.qmon.presentation.instruction.InstructionScreen
import com.qmon.presentation.overview.OverviewScreen
import com.qmon.presentation.question.QuestionScreen
import com.qmon.presentation.util.Screen
import com.qmon.presentation.withdrawal.WithdrawalScreen
import com.qmon.ui.theme.QmonTheme
import kotlinx.coroutines.FlowPreview

class MainActivity : ComponentActivity() {
    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("Coins", Context.MODE_PRIVATE)

        setContent {
            val navController = rememberNavController()

//            val coinsCount = remember {
//                mutableStateOf(
//                    sharedPreferences.getInt("coinsCount", 0)
//                )
//            }
//            println("000000000000000000000000000000000000000000 ${coinsCount.value}")


            val inputStream = assets.open("q.json").bufferedReader()
            val questions = readJsonFile(inputStream)

            QmonTheme {
                InternetConnectionDialog()
            }
            NavGraph(navController, questions, sharedPreferences)
        }

    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    questions: List<Question>,
    sharedPreferences: SharedPreferences
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Overview.route
    ) {
        composable(Screen.Overview.route) {
            OverviewScreen(
                navigateToInstructionScreen = { navController.navigate(Screen.Instruction.route) },
                navigateToQuestionScreen = { navController.navigate(Screen.Question.route) },
                navigateToDailyBonusScreen = { navController.navigate(Screen.DailyBonus.route) },
                navigateToWithdrawalScreen = { navController.navigate(Screen.Withdrawal.route) },
                navigateToLegalInfoScreen = { navController.navigate(Screen.LegalInfo.route) },
            )
        }
        composable(Screen.Instruction.route) {
            InstructionScreen(
                navigateToInstructionScreen = { navController.navigate(Screen.Instruction.route) },
                navigateToLegalInfoScreen = { navController.navigate(Screen.LegalInfo.route) }
            )
        }
        composable(Screen.DailyBonus.route) {
            DailyBonusScreen(
                navigateToInstructionScreen = { navController.navigate(Screen.Instruction.route) },
                navigateToLegalInfoScreen = { navController.navigate(Screen.LegalInfo.route) },
                sharedPreferences
            )
        }
        composable(Screen.Withdrawal.route) {
            WithdrawalScreen(
                navigateToInstructionScreen = { navController.navigate(Screen.Instruction.route) },
                navigateToLegalInfoScreen = { navController.navigate(Screen.LegalInfo.route) }
            )
        }
        composable(Screen.Question.route) {
            QuestionScreen(
                questions = questions,
                navigateToInstructionScreen = { navController.navigate(Screen.Instruction.route) },
                navigateToLegalInfoScreen = { navController.navigate(Screen.LegalInfo.route) },
                sharedPreferences
            )
        }
    }
}
