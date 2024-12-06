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
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "code_text", nullable = false, length = 8)
    var codeText: String? = null

    @Column(name = "fullname", nullable = false, length = 50)
    var fullname: String? = null

    @Column(name = "cedula", nullable = false)
    var cedula: Int? = null

    @Column(name = "email", nullable = false, length = 50)
    var email: String? = null

    @Column(name = "password", nullable = false, length = 25)
    var password: String? = null

    @ManyToOne
    @JoinColumn(name = "roll_id", referencedColumnName = "id")
    var role: Roles? = null

}
