package ru.kestus.movies_watchlist.data.network.kino.model

import com.google.gson.annotations.SerializedName

data class DetailedMovieDto(
    @SerializedName("kinopoiskId") val idKino: Int,
    @SerializedName("imdbId") val idImdb: String,
    @SerializedName("nameRu") val nameRu: String?,
    @SerializedName("nameEn") val nameEn: String?,
    @SerializedName("nameOriginal") val nameOriginal: String?,
    @SerializedName("year") val year: Int,
    @SerializedName("filmLength") val length: Int,
    @SerializedName("posterUrl") val posterUrl: String,
    @SerializedName("posterUrlPreview") val posterUrlPreview: String,
    @SerializedName("coverUrl") val coverUrl: String,
    @SerializedName("logoUrl") val logoUrl: String,
    @SerializedName("ratingKinopoisk") val ratingKino: Double,
    @SerializedName("ratingImdb") val ratingImdb: Double,
    @SerializedName("ratingGoodReview") val ratingGoodReview: Double,
    @SerializedName("ratingFilmCritics") val ratingFilmCritics: Double,
    @SerializedName("webUrl") val urlKino: String,
    @SerializedName("description") val description: String,
    @SerializedName("shortDescription") val descriptionShort: String,
    @SerializedName("type") val type: String,
    @SerializedName("countries") val countries: List<CountryDto>,
    @SerializedName("genres") val genres: List<GenreDto>,
    @SerializedName("serial") val serial: Boolean,
    @SerializedName("shortFilm") val shortFilm: Boolean
)