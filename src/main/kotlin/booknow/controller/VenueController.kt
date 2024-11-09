package booknow.controller

import booknow.model.Venue
import booknow.model.VenueRegistrationDTO
import booknow.service.VenueService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/venues")
class VenueController(private val venueService: VenueService) {
    @PostMapping("/register")
    fun registerVenue(@RequestBody venueDTO: VenueRegistrationDTO) : ResponseEntity<Venue>{
        val createdVenue = venueService.registerVenue(venueDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVenue)
    }
}