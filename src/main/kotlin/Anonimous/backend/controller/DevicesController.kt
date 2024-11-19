package Anonimous.backend.controller

import Anonimous.backend.model.Devices
import Anonimous.backend.service.DevicesService
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
@RequestMapping("/devices")
class DevicesController {
    @Autowired
    lateinit var devicesService: DevicesService

    @GetMapping
    fun list(): List<Devices> = devicesService.list()

    @PostMapping
    fun save(@RequestBody device: Devices): ResponseEntity<Devices> {
        return ResponseEntity(devicesService.save(device), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody device: Devices): ResponseEntity<Devices> {
        return ResponseEntity(devicesService.update(device), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody device: Devices): ResponseEntity<Devices> {
        return ResponseEntity(devicesService.updateName(device), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(devicesService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return devicesService.delete(id)
    }
}

