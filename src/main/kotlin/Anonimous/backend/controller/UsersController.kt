package Anonimous.backend.controller

import Anonimous.backend.model.Users
import Anonimous.backend.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {
    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun list(): List<Users> = usersService.list()

    @PostMapping
    fun save(@RequestBody user: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.save(user), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody user: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.update(user), HttpStatus.OK)
    }

    @PatchMapping
    fun updateUsername(@RequestBody user: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.updateUsername(user), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(usersService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return usersService.delete(id)
    }
}
