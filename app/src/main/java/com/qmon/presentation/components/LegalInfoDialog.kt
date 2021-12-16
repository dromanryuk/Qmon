package com.qmon.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.qmon.qmonApp
import com.qmon.ui.theme.QmonTheme

@Composable
fun LegalInfoDialog() {
    val legalInfoRepository = qmonApp.legalInfoRepository

    var showDialog by remember { mutableStateOf(false) }
    var legalText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        showDialog = legalInfoRepository.shouldShowDialog()
        if (showDialog)
            legalText = legalInfoRepository.getLegalInfo()
    }

    if (showDialog)
        Dialog(onDismissRequest = {}) {
            LegalInfoDialogContent(
                legalText = legalText,
                onAccept = {
                    legalInfoRepository.onAcceptDialog()
                    showDialog = false
                }
            )
        }
}

@Composable
private fun LegalInfoDialogContent(legalText: String, onAccept: () -> Unit) {
    Card {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Перед началом необходимо принять пользовательское " +
                        "соглашение и политику конфиденциальности",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                elevation = 2.dp
            ) {
                Box(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(4.dp)
                ) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = legalText,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Text(
                text = "Нажимая кнопку подтвердить вы подтверждаете, что " +
                        "ознакомились и принимаете пользовательское соглашение и политику " +
                        "конфинденциальности",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            DefaultTextButton(
                text = "Подтверждаю",
                onClick = onAccept,
                color = ButtonColor.BLUE.color
            )
        }
    }
}

@Preview
@Composable
private fun LegalInfoDialogContentPreview() {
    QmonTheme {
        LegalInfoDialogContent(
            "1. Общие положения\n" +
                    "Настоящая политика обработки персональных данных составлена в соответствии с требованиями Федерального закона от 27.07.2006. №152-ФЗ «О персональных данных» (далее - Закон о персональных данных) и определяет порядок обработки персональных данных и меры по обеспечению безопасности персональных данных, предпринимаемые Qmoll (далее – Оператор).\n" +
                    "1.1. Оператор ставит своей важнейшей целью и условием осуществления своей деятельности соблюдение прав и свобод человека и гражданина при обработке его персональных данных, в том числе защиты прав на неприкосновенность частной жизни, личную и семейную тайну.\n" +
                    "1.2. Настоящая политика Оператора в отношении обработки персональных данных (далее – Политика) применяется ко всей информации, которую Оператор может получить о посетителях Приложения Qmoll.\n" +
                    "2. Основные понятия, используемые в Политике\n" +
                    "2.1. Автоматизированная обработка персональных данных – обработка персональных данных с помощью средств вычислительной техники.\n" +
                    "2.2. Блокирование персональных данных – временное прекращение обработки персональных данных (за исключением случаев, если обработка необходима для уточнения персональных данных).\n" +
                    "2.3. Веб-сайт – совокупность графических и информационных материалов, а также программ для ЭВМ и баз данных, обеспечивающих их доступность в сети интернет по сетевому адресу https://Приложения Qmoll.\n" +
                    "2.4. Информационная система персональных данных — совокупность содержащихся в базах данных персональных данных, и обеспечивающих их обработку информационных технологий и технических средств.\n" +
                    "2.5. Обезличивание персональных данных — действия, в результате которых невозможно определить без использования дополнительной информации принадлежность персональных данных конкретному Пользователю или иному субъекту персональных данных.\n",
            {}
        )
    }
}