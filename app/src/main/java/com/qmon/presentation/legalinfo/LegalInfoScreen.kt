package com.qmon.presentation.legalinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.qmonApp
import com.qmon.ui.theme.QmonTheme

@Composable
fun LegalInfoScreen() {
    val legalInfoRepository = qmonApp.legalInfoRepository
    var legalText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        legalText = legalInfoRepository.getLegalInfo()
    }
    LegalInfoScreenContent(legalText = legalText)
}

@Composable
private fun LegalInfoScreenContent(legalText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Юридическая информация",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = legalText,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LegalInfoScreenContentPreview() {
    QmonTheme {
        LegalInfoScreenContent(
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
        )
    }
}