package booknow.model

import jakarta.persistence.*

@Entity
@Table(name = "venues")
data class Venue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val contactPhone: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val status: String = "pending",

    @OneToMany(mappedBy = "venue", cascade = [CascadeType.ALL])
    val employees: MutableList<Employee> = mutableListOf(),

    @OneToOne(mappedBy = "venue", cascade = [CascadeType.ALL])
    var location: Location? = null,
)