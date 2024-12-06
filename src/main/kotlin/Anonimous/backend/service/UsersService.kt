package Anonimous.backend.service

import Anonimous.backend.model.Roles
import Anonimous.backend.model.Users
import Anonimous.backend.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun list(): List<Users> {
        val usersList = usersRepository.findAll()
        // Modificar directamente los roles para devolver solo el nombre
        usersList.forEach { user ->
            user.role?.apply {
                // Solo devolver el nameRol, no el objeto completo
                user.role = Roles().apply { nameRol = this@apply.nameRol }
            }
        }
        return usersList
    }


    fun save(user: Users): Users {
        return try {
            usersRepository.save(user)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(user: Users): Users {
        try {
            usersRepository.findById(user.id)
                ?: throw Exception("ID no existe")
            return usersRepository.save(user)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateUsername(user: Users): Users {
        try {
            val existingUser = usersRepository.findById(user.id)
                ?: throw Exception("ID no existe")
            existingUser.apply {
                fullname = user.fullname
            }
            return usersRepository.save(existingUser)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Users? = usersRepository.findById(id)

    fun delete(id: Long?): Boolean {
        return try {
            usersRepository.findById(id)
                ?: throw Exception("ID no existe")
            usersRepository.deleteById(id!!)
            true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
