package Anonimous.backend.controller

import Anonimous.backend.model.Roles
import Anonimous.backend.service.RolesService
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
@RequestMapping("/roles")
class RolesController {
    @Autowired
    lateinit var rolesService: RolesService

    @GetMapping
    fun list(): List<Roles> = rolesService.list()

    @PostMapping
    fun save(@RequestBody role: Roles): ResponseEntity<Roles> {
        return ResponseEntity(rolesService.save(role), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody role: Roles): ResponseEntity<Roles> {
        return ResponseEntity(rolesService.update(role), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody role: Roles): ResponseEntity<Roles> {
        return ResponseEntity(rolesService.updateName(role), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(rolesService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return rolesService.delete(id)
    }
}

