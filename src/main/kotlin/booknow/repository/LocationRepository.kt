package booknow.repository

import booknow.model.entity.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface LocationRepository : JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l JOIN FETCH l.venue WHERE l.id = :id")
    fun getLocationWithVenueById(@Param("id") id: Long): Location?
}