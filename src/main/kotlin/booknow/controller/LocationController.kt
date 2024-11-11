package booknow.controller

import booknow.model.entity.Venue
import booknow.service.LocationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/locations")
class LocationController(private val locationService: LocationService) {
    @GetMapping("/{id}")
    fun getLocationById(@PathVariable id: Long): Any =
        locationService.getVenueByLocationId(id)
}