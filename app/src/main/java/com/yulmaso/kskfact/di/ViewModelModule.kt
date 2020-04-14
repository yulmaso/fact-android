package com.yulmaso.kskfact.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.kskfact.di.ViewModelFactory
import com.yulmaso.kskfact.di.ViewModelKey
import com.yulmaso.kskfact.ui.horseProfile.HorseProfileViewModel
import com.yulmaso.kskfact.ui.horses.HorsesViewModel
import com.yulmaso.kskfact.ui.login.LoginViewModel
import com.yulmaso.kskfact.ui.menu.MenuViewModel
import com.yulmaso.kskfact.ui.news.NewsViewModel
import com.yulmaso.kskfact.ui.settings.SettingsViewModel
import com.yulmaso.kskfact.ui.timetable.TimetableViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(menuViewModel: MenuViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TimetableViewModel::class)
    abstract fun bindTimetableViewModel(timetableViewModel: TimetableViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(settingsViewModel: SettingsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HorsesViewModel::class)
    abstract fun bindHorsesViewModel(horsesViewModel: HorsesViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HorseProfileViewModel::class)
    abstract fun bindHorseProfileViewModel(horseProfileViewModel: HorseProfileViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

}