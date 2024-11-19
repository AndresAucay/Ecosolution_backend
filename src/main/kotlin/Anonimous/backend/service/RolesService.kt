package Anonimous.backend.service

import Anonimous.backend.model.Roles
import Anonimous.backend.repository.RolesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RolesService {
    @Autowired
    lateinit var rolesRepository: RolesRepository

    fun list(): List<Roles> = rolesRepository.findAll()

    fun save(role: Roles): Roles {
        return try {
            rolesRepository.save(role)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(role: Roles): Roles {
        try {
            rolesRepository.findById(role.id)
                ?: throw Exception("ID no existe")
            return rolesRepository.save(role)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(role: Roles): Roles {
        try {
            val existingRole = rolesRepository.findById(role.id)
                ?: throw Exception("ID no existe")
            existingRole.apply {
                nameRol = role.nameRol
            }
            return rolesRepository.save(existingRole)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Roles? = rolesRepository.findById(id)

    fun delete(id: Long?): Boolean {
        return try {
            rolesRepository.findById(id)
                ?: throw Exception("ID no existe")
            rolesRepository.deleteById(id!!)
            true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}

