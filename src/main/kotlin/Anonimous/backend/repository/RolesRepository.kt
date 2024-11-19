package Anonimous.backend.repository


import Anonimous.backend.model.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository : JpaRepository<Roles, Long?>{
    fun findById(id: Long?): Roles?

}
