package com.example.nationwidemarketcondition.di

import com.example.nationwidemarketcondition.map.MapViewModel
import com.example.nationwidemarketcondition.map.TestClass
import com.example.nationwidemarketcondition.networkmodel.RetrofitMapInterface
import com.example.nationwidemarketcondition.networkmodel.dataclass.MapRetrofitData
//import com.example.nationwidemarketcondition.networkmodel.dataclass.MapRetrofitData
import com.example.nationwidemarketcondition.networkmodel.repository.NetworkRepository
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val NAVER_HOST = "https://naveropenapi.apigw.ntruss.com"

val viewModelModule = module {
    viewModel { MapViewModel(get()) }
}

val networkServerModule = module {
    single { provideNaverApi(provideNaverRetrofit(get())) }
}

val repositoryModule = module{
    single { NetworkRepository(get()) }
}
val testModule = module{
    single { TestClass() }
}
val retrofitModule = module{
    single { MapRetrofitData(get(),get(),get()) }
}

private fun provideNaverRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(NAVER_HOST)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

private fun provideNaverApi(retrofit: Retrofit): RetrofitMapInterface =
    retrofit.create(RetrofitMapInterface::class.java)