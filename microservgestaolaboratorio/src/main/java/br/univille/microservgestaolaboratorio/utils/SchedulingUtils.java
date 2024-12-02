package br.univille.microservgestaolaboratorio.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.univille.microservgestaolaboratorio.scheduling.dto.SchedulingSaveDTO;
import br.univille.microservgestaolaboratorio.scheduling.entity.SchedulingEntity;

public class SchedulingUtils {
    public static SchedulingEntity saveDTOToEntity(SchedulingSaveDTO schedulingSaveDTO) {
        SchedulingEntity schedulingEntity = new SchedulingEntity();
        schedulingEntity.setLab(schedulingSaveDTO.getLab());
        schedulingEntity.setDate(schedulingSaveDTO.getDate());
        schedulingEntity.setStatus(schedulingSaveDTO.getStatus());
        schedulingEntity.setTeacherId(schedulingSaveDTO.getTeacherId());
        schedulingEntity.setSubject(schedulingSaveDTO.getSubject());
        schedulingEntity.setCourse(schedulingSaveDTO.getCourse());

        schedulingEntity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        return schedulingEntity;
    }
}
