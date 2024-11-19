package Anonimous.backend.controller

import Anonimous.backend.model.Containers
import Anonimous.backend.service.ContainersService
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
@RequestMapping("/containers")
class ContainersController {
    @Autowired
    lateinit var containersService: ContainersService

    @GetMapping
    fun list(): List<Containers> = containersService.list()

    @PostMapping
    fun save(@RequestBody container: Containers): ResponseEntity<Containers> {
        return ResponseEntity(containersService.save(container), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody container: Containers): ResponseEntity<Containers> {
        return ResponseEntity(containersService.update(container), HttpStatus.OK)
    }

    @PatchMapping
    fun updateCapacity(@RequestBody container: Containers): ResponseEntity<Containers> {
        return ResponseEntity(containersService.updateCapacity(container), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(containersService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return containersService.delete(id)
    }
}

