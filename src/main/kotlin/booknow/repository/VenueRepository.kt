package booknow.repository

import booknow.model.entity.Venue
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

//@Repository
interface VenueRepository : CrudRepository<Venue, Long> {
    //    @Query("SELECT v FROM Venue v  WHERE v.id = :id")
//    fun findVenueDetailsById(@Param("id") id: Long): Venue?
//    @Query("SELECT v FROM Venue v WHERE v.id = :id")
    fun findVenueById(@Param("id") id: Long): Venue?

    @Query("SELECT v FROM Venue v WHERE v.location.id = :locationId")
    fun findVenueByLocationId(@Param("locationId") locationId: Long): Venue?
}