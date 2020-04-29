package com.yulmaso.kskfact.data.web

import com.yulmaso.kskfact.data.model.Event
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.data.web.service.*
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val eventService: EventService,
    private val horseService: HorseService,
    private val newsService: NewsService,
    private val servicesService: ServicesService,
    private val stableService: StableService,
    private val userService: UserService,
    private val vaccinationService: VaccinationService
) {
    fun getAllEvents() = eventService.getAllEvents()
    fun getEvent(id: Long) = eventService.getEvent(id)
    fun saveEvent(event: Event) = eventService.saveEvent(event)
    fun removeEvent(id: Long) = eventService.removeEvent(id)

    fun getAllHorses() = horseService.getAllHorses()
    fun getHorse(id: Long) = horseService.getHorse(id)
    fun saveHorse(horse: Horse) = horseService.saveHorse(horse)

    fun getAllNews() = newsService.getAllNews()

    fun getAllServices() = servicesService.getAllServices()
    fun getService(id: Long) = servicesService.getService(id)
    fun saveService(service: Service) = servicesService.saveService(service)
    fun removeService(id: Long) = servicesService.removeService(id)

    fun getAllStables() = stableService.getAllStables()
    fun getStable(id: Int) = stableService.getStable(id)

    fun getAllUsers() = userService.getAllUsers()
    fun getUser(id: Long) = userService.getUser(id)
    fun saveUser(user: User) = userService.saveUser(user)
    fun removeUser(id: Long) = userService.removeUser(id)

    fun getAllVaccinations() = vaccinationService.getAllVaccinations()
    fun getVaccination(id: Long) = vaccinationService.getVaccination(id)
}