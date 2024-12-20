package Anonimous.backend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dispositivos")
class Devices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "codeText", nullable = false, length = 8)
    var codeText: String? = null

    @Column(name = "latitud")
    var latitud: Double? = null

    @Column(name = "longitud")
    var longitud: Double? = null


    @Column(name = "nivel_capacidad")
    var nivelCapacidad: Int? = null

    @Column(name = "dateCreacion")
    var dateCreacion: String? = null

    @Column(name = "estado")
    var estado: String? = null

    @Column(name = "last_mantenimiento")
    var lastMantenimiento: String? = null
}
