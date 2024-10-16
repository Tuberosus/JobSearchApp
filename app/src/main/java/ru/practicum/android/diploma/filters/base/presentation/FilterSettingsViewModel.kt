package ru.practicum.android.diploma.filters.base.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.practicum.android.diploma.search.data.model.SavedFilters
import ru.practicum.android.diploma.search.domain.api.RequestBuilderInteractor

class FilterSettingsViewModel(private val requestBuilderInteractor: RequestBuilderInteractor) : ViewModel() {

    private val baseFilterScreenState: MutableLiveData<FilterSettingsStateScreen> = MutableLiveData()
    val getBaseFiltersScreenState: LiveData<FilterSettingsStateScreen> = baseFilterScreenState
    private fun initFilters(): SavedFilters {
        return requestBuilderInteractor.getSavedFilters()
    }

    fun checkFilterFields() {
        val filters = initFilters()
        baseFilterScreenState.value =
            FilterSettingsStateScreen.FilterSettings(
                filters.savedArea ?: "",
                filters.savedIndustry ?: "",
                filters.savedSalary ?: "",
                filters.savedIsShowWithSalary ?: false
            )
    }

}
