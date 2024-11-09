package booknow.model

import jakarta.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "venue_id")
    val venue: Venue,

    val name: String,
    val title: String,
    val providesServices: Boolean,
    val sentiments : List<String>? = null
)