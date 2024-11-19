package Anonimous.backend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "roles")
class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "codeText", nullable = false, length = 8)
    var codeText: String? = null

    @Column(name = "name_rol", nullable = false, length = 50)
    var nameRol: String? = null

    @Column(name = "description", nullable = false, length = 1000)
    var description: String? = null
}
