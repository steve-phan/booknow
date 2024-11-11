package booknow.model.entity

import jakarta.persistence.*

@Entity
data class Employee(


    val name: String,
    val title: String,
    val providesServices: Boolean,
    val sentiments: List<String>? = null,

    @ManyToOne
    @JoinColumn(name = "venue_id")
    val venue: Venue,


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
)