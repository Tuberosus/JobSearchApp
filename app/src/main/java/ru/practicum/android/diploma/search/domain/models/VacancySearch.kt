package ru.practicum.android.diploma.search.domain.models

data class VacancySearch(
    val id: String,
    val name: String,
    val address: String,
    val company: String,
    val salary: String?,
    val logo: String?,
)