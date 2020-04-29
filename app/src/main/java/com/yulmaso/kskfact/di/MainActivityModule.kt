package com.yulmaso.kskfact.di

import com.yulmaso.kskfact.MainActivity
import com.yulmaso.kskfact.ui.cameras.CamerasFragment
import com.yulmaso.kskfact.ui.dialogFragments.addService.AddServiceDialogFragment
import com.yulmaso.kskfact.ui.horseProfile.HorseProfileFragment
import com.yulmaso.kskfact.ui.horses.HorsesFragment
import com.yulmaso.kskfact.ui.login.LoginFragment
import com.yulmaso.kskfact.ui.menu.MenuFragment
import com.yulmaso.kskfact.ui.news.NewsFragment
import com.yulmaso.kskfact.ui.settings.SettingsFragment
import com.yulmaso.kskfact.ui.timetable.TimetableFragment
import com.yulmaso.kskfact.ui.userProfile.UserProfileFragment
import com.yulmaso.kskfact.ui.users.UsersFragment
import com.yulmaso.kskfact.ui.vaccinationsHistory.VaccinationsHistoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeCamerasFragment(): CamerasFragment

    @ContributesAndroidInjector
    abstract fun contributeHorsesFragment(): HorsesFragment

    @ContributesAndroidInjector
    abstract fun contributeHorseProfileFragment(): HorseProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsFragment(): NewsFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun contributeTimetableFragment(): TimetableFragment

    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment(): UserProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    abstract fun contributeVaccinationsHistoryFragment(): VaccinationsHistoryFragment

    @ContributesAndroidInjector
    abstract fun contributeAddServiceDialogFragment(): AddServiceDialogFragment
}