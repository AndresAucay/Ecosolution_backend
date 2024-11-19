package Anonimous.backend.repository

import Anonimous.backend.model.Devices
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DevicesRepository : JpaRepository<Devices, Long?> {
    fun findById(id: Long?): Devices?
}
