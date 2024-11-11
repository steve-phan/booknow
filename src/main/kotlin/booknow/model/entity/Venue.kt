package booknow.model.entity

import jakarta.persistence.*

@Entity
//@Table(name = "venues")
data class Venue(
    var name: String,
    var description: String,
    var contactPhone: String,
    var email: String,
    var status: String = "pending",

    @OneToMany(mappedBy = "venue", cascade = [CascadeType.ALL])
    val employees: MutableList<Employee> = mutableListOf(),

//    @OneToOne(mappedBy = "venue", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @OneToOne(mappedBy = "venue", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name = "location_id")
    var location: Location? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)