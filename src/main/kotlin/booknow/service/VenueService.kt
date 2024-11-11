package booknow.service

import booknow.model.entity.Location
import booknow.model.entity.Venue
import booknow.model.dto.VenueRegistrationDTO
import booknow.repository.LocationRepository
import booknow.repository.VenueRepository
import org.springframework.stereotype.Service

@Service
class VenueService(
    private val venueRepository: VenueRepository,
    private val locationRepository: LocationRepository,

    ) {
    fun registerVenue(dto: VenueRegistrationDTO): Venue {
        val venue = Venue(
            name = dto.name,
            description = dto.description,
            contactPhone = dto.contactPhone,
            email = dto.email
        )
        val savedVenue = venueRepository.save(venue)
        val location = Location(
            countryId = dto.location.countryId,
            postalCode = dto.location.postalCode,
            addressLines = dto.location.addressLines,
            venue = savedVenue
        )
        locationRepository.save(location)

        return savedVenue
    }

    fun getVenueDetailsById(id: Long) = venueRepository.findVenueById(id)

    fun getLocationById(id: Long) = locationRepository.getLocationWithVenueById(id)

    fun getVenueByLocationId(id: Long) = venueRepository.findVenueByLocationId(id)
}