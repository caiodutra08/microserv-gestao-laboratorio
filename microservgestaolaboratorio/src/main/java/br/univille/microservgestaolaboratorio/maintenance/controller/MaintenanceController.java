package br.univille.microservgestaolaboratorio.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservgestaolaboratorio.maintenance.dto.MaintenanceSaveDTO;
import br.univille.microservgestaolaboratorio.maintenance.entity.MaintenanceEntity;
import br.univille.microservgestaolaboratorio.maintenance.service.MaintenanceService;

@RestController
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<MaintenanceEntity>> findAll() {
        var maintenances = maintenanceService.findAll();

        return new ResponseEntity<List<MaintenanceEntity>>(maintenances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenanceEntity> save(@RequestBody MaintenanceSaveDTO maintenanceSaveDTO) {
        if (maintenanceSaveDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var maintenanceSaved = maintenanceService.save(maintenanceSaveDTO);

        return new ResponseEntity<MaintenanceEntity>(maintenanceSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceEntity> findById(@PathVariable String id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var maintenance = maintenanceService.findById(id);

        return new ResponseEntity<MaintenanceEntity>(maintenance, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MaintenanceEntity> update(@PathVariable String id,
            @RequestBody MaintenanceEntity maintenance) {
        if (maintenance == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var maintenanceUpdated = maintenanceService.update(id, maintenance);

        return new ResponseEntity<MaintenanceEntity>(maintenanceUpdated, HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<MaintenanceEntity>> findAllMaintenanceByTeacherId(@PathVariable String teacherId) {
        if (teacherId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var maintenances = maintenanceService.findAllMaintenanceByTeacherId(teacherId);

        return new ResponseEntity<List<MaintenanceEntity>>(maintenances, HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}/last")
    public ResponseEntity<MaintenanceEntity> findLastMaintenanceByTeacherId(@PathVariable String teacherId) {
        if (teacherId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var maintenance = maintenanceService.findLastMaintenanceByTeacherId(teacherId);

        return new ResponseEntity<MaintenanceEntity>(maintenance, HttpStatus.OK);
    }
}
