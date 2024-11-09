package booknow.repository

import booknow.model.Venue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VenueRepository : JpaRepository<Venue,Long> {
}