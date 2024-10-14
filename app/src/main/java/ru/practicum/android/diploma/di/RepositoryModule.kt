package ru.practicum.android.diploma.di

import org.koin.dsl.module
import ru.practicum.android.diploma.favorite.data.FavoriteVacancyRepositoryImpl
import ru.practicum.android.diploma.favorite.domain.api.FavoriteVacancyRepository
import ru.practicum.android.diploma.filters.data.FilterAreaRepositoryImpl
import ru.practicum.android.diploma.filters.data.impl.FilterIndustriesRepositoryImpl
import ru.practicum.android.diploma.filters.domain.api.FilterAreaRepository
import ru.practicum.android.diploma.filters.domain.api.FilterIndustriesRepository
import ru.practicum.android.diploma.search.data.impl.RequestBuilderRepositoryImpl
import ru.practicum.android.diploma.search.data.impl.SearchVacancyRepositoryImpl
import ru.practicum.android.diploma.search.domain.api.RequestBuilderRepository
import ru.practicum.android.diploma.search.domain.api.SearchVacancyRepository
import ru.practicum.android.diploma.vacancy.data.impl.GetVacancyDetailsRepositoryImpl
import ru.practicum.android.diploma.vacancy.domain.api.GetVacancyDetailsRepository

val repositoryModule = module {

    single<SearchVacancyRepository> {
        SearchVacancyRepositoryImpl(get(), get())
    }

    single<FavoriteVacancyRepository> {
        FavoriteVacancyRepositoryImpl(get(), get())
    }

    single<GetVacancyDetailsRepository> {
        GetVacancyDetailsRepositoryImpl(get(), get(), get())
    }

    single<FilterAreaRepository> {
        FilterAreaRepositoryImpl(get(), get())
    }

    single<FilterIndustriesRepository> {
        FilterIndustriesRepositoryImpl(get())
    }

    single<RequestBuilderRepository> {
        RequestBuilderRepositoryImpl(get())
    }
}
