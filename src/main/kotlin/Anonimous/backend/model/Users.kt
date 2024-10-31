package Anonimous.backend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "client_credit")
class Users{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var codeText: String? = null
    var fullname: String? = null   //address
    var cedula: Int? = null   //address
    var email: String? = null   //address
    var password: String? = null   //address
    @Column(name = "roll_id")
    var rollId: String? = null   //address

}