package Anonimous.backend.repository

import Anonimous.backend.model.Containers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContainersRepository : JpaRepository<Containers, Long?> {
    fun findById(id: Long?): Containers?
}
