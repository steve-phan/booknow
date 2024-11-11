package booknow.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Location(
    val countryId: Int,
    val postalCode: String,
    val addressLines: List<String>,

    @OneToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    @JoinColumn(name = "venue_id")
    var venue: Venue? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,


//    val latitude: Double,
//    val longitude: Double
)