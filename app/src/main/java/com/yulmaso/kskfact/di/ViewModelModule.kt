package com.yulmaso.kskfact.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.kskfact.di.ViewModelFactory
import com.yulmaso.kskfact.di.ViewModelKey
import com.yulmaso.kskfact.ui.cameras.CamerasViewModel
import com.yulmaso.kskfact.ui.horseProfile.HorseProfileViewModel
import com.yulmaso.kskfact.ui.horses.HorsesViewModel
import com.yulmaso.kskfact.ui.login.LoginViewModel
import com.yulmaso.kskfact.ui.menu.MenuViewModel
import com.yulmaso.kskfact.ui.news.NewsViewModel
import com.yulmaso.kskfact.ui.settings.SettingsViewModel
import com.yulmaso.kskfact.ui.timetable.TimetableViewModel
import com.yulmaso.kskfact.ui.userProfile.UserProfileViewModel
import com.yulmaso.kskfact.ui.users.UsersViewModel
import com.yulmaso.kskfact.ui.vaccinationsHistory.VaccinationsHistoryViewModel
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
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    abstract fun bindUsersViewModel(usersViewModel: UsersViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewModel(userProfileViewModel: UserProfileViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CamerasViewModel::class)
    abstract fun bindCamerasViewModel(camerasViewModel: CamerasViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VaccinationsHistoryViewModel::class)
    abstract fun bindVaccinationsHistoryViewModel(vaccinationsHistoryViewModel: VaccinationsHistoryViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

}