package Anonimous.backend.service

import Anonimous.backend.model.Containers
import Anonimous.backend.repository.ContainersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ContainersService {
    @Autowired
    lateinit var containersRepository: ContainersRepository

    fun list(): List<Containers> = containersRepository.findAll()

    fun save(container: Containers): Containers {
        return try {
            containersRepository.save(container)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(container: Containers): Containers {
        try {
            containersRepository.findById(container.id)
                ?: throw Exception("ID no existe")
            return containersRepository.save(container)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateCapacity(container: Containers): Containers {
        try {
            val existingContainer = containersRepository.findById(container.id)
                ?: throw Exception("ID no existe")
            existingContainer.apply {
                capacidad= container.capacidad
            }
            return containersRepository.save(existingContainer)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Containers? = containersRepository.findById(id)

    fun delete(id: Long?): Boolean {
        return try {
            containersRepository.findById(id)
                ?: throw Exception("ID no existe")
            containersRepository.deleteById(id!!)
            true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}

