package booknow.service

import booknow.exception.VenueNotFoundException
import booknow.model.entity.Venue
import booknow.repository.LocationRepository
import booknow.repository.VenueRepository
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun getVenueByLocationId(id: Long): Any {
        return locationRepository.getLocationWithVenueById(id) ?: throw VenueNotFoundException(id)
    }
}