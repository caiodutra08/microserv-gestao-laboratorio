package br.univille.microservgestaolaboratorio.scheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.univille.microservgestaolaboratorio.scheduling.dto.SchedulingSaveDTO;
import br.univille.microservgestaolaboratorio.scheduling.entity.SchedulingEntity;
import br.univille.microservgestaolaboratorio.scheduling.service.SchedulingService;

@Controller
@RequestMapping("/api/v1/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    public ResponseEntity<List<SchedulingEntity>> findAll() {
        var scheduling = schedulingService.findAll();

        return new ResponseEntity<List<SchedulingEntity>>(scheduling, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SchedulingEntity> save(@RequestBody SchedulingSaveDTO schedulingSaveDTO) {
        if (schedulingSaveDTO == null || schedulingSaveDTO.getSubject() == null || schedulingSaveDTO.getCourse() == null
                || schedulingSaveDTO.getTeacherId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var schedulingSaved = schedulingService.save(schedulingSaveDTO);

        return new ResponseEntity<SchedulingEntity>(schedulingSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingEntity> findById(@PathVariable String id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var scheduling = schedulingService.findById(id);

        return new ResponseEntity<SchedulingEntity>(scheduling, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SchedulingEntity> update(@PathVariable String id, @RequestBody SchedulingEntity scheduling) {
        if (scheduling == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var schedulingUpdated = schedulingService.update(id, scheduling);

        return new ResponseEntity<SchedulingEntity>(schedulingUpdated, HttpStatus.OK);
    }


    @PatchMapping("/{id}/cancel")
    public ResponseEntity<SchedulingEntity> cancel(@PathVariable String id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var schedulingCanceled = schedulingService.cancel(id);

        return new ResponseEntity<SchedulingEntity>(schedulingCanceled, HttpStatus.OK);
    }
}
