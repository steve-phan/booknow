package booknow.service

import booknow.model.Employee
import booknow.model.Location
import booknow.model.Venue
import booknow.model.VenueRegistrationDTO
import booknow.repository.EmployeeRepository
import booknow.repository.LocationRepository
import booknow.repository.VenueRepository
import org.springframework.stereotype.Service

@Service
class VenueService(
    private val venueRepository: VenueRepository,
private val locationRepository: LocationRepository,
private val employeeRepository: EmployeeRepository
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
            venue = savedVenue,
            countryId = dto.location.countryId,
            postalCode = dto.location.postalCode,
            addressLines = dto.location.addressLines,
            )
        savedVenue.location = location
        locationRepository.save(location)

        val employees = dto.employees.map { employeeDto ->
            Employee(
                venue = savedVenue,
                name = employeeDto.name,
                title = employeeDto.title,
                providesServices = employeeDto.providesServices,
                sentiments = employeeDto.sentiments ?: emptyList()
            )
        }

        employeeRepository.saveAll(employees)
        savedVenue.employees.addAll(employees)

        return savedVenue
    }
}