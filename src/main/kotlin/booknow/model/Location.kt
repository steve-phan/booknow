package booknow.model

import jakarta.persistence.*

@Entity
@Table(name = "locations")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "venue_id")
    val venue: Venue,

    val countryId: Int,
    val postalCode: String,
    val addressLines: String,
//    val latitude: Double,
//    val longitude: Double
)