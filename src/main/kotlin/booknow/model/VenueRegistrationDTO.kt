package booknow.model

data class VenueRegistrationDTO(
    val name : String,
    val description: String,
    val contactPhone: String,
    val email: String,
    val location: LocationDTO,
    val employees: List<EmployeeDTO>,
 //   val openingHours: List<String>
)

data class LocationDTO(
    val countryId: Int,
    val postalCode: String,
    val addressLines: List<String>,
//    val latitude: Double,
//    val longitude: Double
)

data class EmployeeDTO(
    val name: String,
    val title: String,
    val providesServices: Boolean,
    val sentiments : List<String>? = null
)