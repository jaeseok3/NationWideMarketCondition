package com.example.nationwidemarketcondition.di

import com.example.nationwidemarketcondition.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MapViewModel(get()) }
}