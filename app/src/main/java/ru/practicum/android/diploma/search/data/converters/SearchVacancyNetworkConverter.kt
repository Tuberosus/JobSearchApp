package ru.practicum.android.diploma.search.data.converters

import android.content.Context
import ru.practicum.android.diploma.R
import ru.practicum.android.diploma.search.data.dto.VacancyItemDto
import ru.practicum.android.diploma.search.domain.models.VacancySearch

class SearchVacancyNetworkConverter(
    private val salaryCurrencySignFormater: SalaryCurrencySignFormater
) {

    fun map(vacancyItemDto: VacancyItemDto): VacancySearch {
        return VacancySearch(
            id = vacancyItemDto.id,
            name = vacancyItemDto.name,
            address = getAddressFromDto(vacancyItemDto),
            company = vacancyItemDto.employer.name,
            salary = salaryCurrencySignFormater.getStringSalary(vacancyItemDto.salary),
            logo = vacancyItemDto.employer.logoUrls?.size240
        )
    }

    private fun getAddressFromDto(vacancyItemDto: VacancyItemDto): String {
        return if (vacancyItemDto.address?.city == null) {
            vacancyItemDto.area.name
        } else {
            vacancyItemDto.address.city
        }
    }
}
