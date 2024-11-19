package Anonimous.backend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "containers")
class Containers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "codeText", nullable = false, length = 8)
    var codeText: String? = null

    @Column(name = "capacidad")
    var capacidad: Int? = null

    @Column(name = "last_emptying")
    var lastEmptying: String? = null

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", referencedColumnName = "id")
    var dispositivo: Devices? = null

}
