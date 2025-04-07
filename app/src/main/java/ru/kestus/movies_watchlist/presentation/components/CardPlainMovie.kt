package ru.kestus.movies_watchlist.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.kestus.movies_watchlist.R
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem
import ru.kestus.movies_watchlist.presentation.ui.theme.Typography

@Composable
fun CardPlainMovie(movieItem: PlainMovieItem) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            ImageContainer(movieItem.posterUrl)
            Spacer(Modifier.width(8.dp))
            Column {
                Text(
                    text = movieItem.name,
                    style = Typography.titleLarge
                )

            }
        }
    }
}

@Composable
private fun ImageContainer(url: String?) {
    Box(
        modifier = Modifier
            .size(
                width = 64.dp,
                height = 84.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            fallback = painterResource(R.drawable.ic_image_placeholder)
        )
    }
}

@Preview
@Composable
private fun Prev() {
    CardPlainMovie(
        PlainMovieItem(
            id = 0,
            idKinopoisk = 0,
            name = "Name",
            description = "«Одноразовый сотрудник» Микки участвует в колонизации ледяного мира. После смерти Микки его сознание каждый раз загружается в новое тело.",
            year = 1999,
            genres = listOf("genre1", "genre2"),
            posterUrl = ""
        )
    )
}