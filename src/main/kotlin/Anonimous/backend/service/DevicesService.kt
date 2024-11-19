package Anonimous.backend.service

import Anonimous.backend.model.Devices
import Anonimous.backend.repository.DevicesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DevicesService {
    @Autowired
    lateinit var devicesRepository: DevicesRepository

    fun list(): List<Devices> = devicesRepository.findAll()

    fun save(device: Devices): Devices {
        return try {
            devicesRepository.save(device)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(device: Devices): Devices {
        try {
            devicesRepository.findById(device.id)
                ?: throw Exception("ID no existe")
            return devicesRepository.save(device)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(device: Devices): Devices {
        try {
            val existingDevice = devicesRepository.findById(device.id)
                ?: throw Exception("ID no existe")
            existingDevice.apply {
               estado = device.estado
            }
            return devicesRepository.save(existingDevice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Devices? = devicesRepository.findById(id)

    fun delete(id: Long?): Boolean {
        return try {
            devicesRepository.findById(id)
                ?: throw Exception("ID no existe")
            devicesRepository.deleteById(id!!)
            true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}

