package br.univille.microservgestaolaboratorio.scheduling.service;

import java.util.List;

import br.univille.microservgestaolaboratorio.scheduling.dto.SchedulingSaveDTO;
import br.univille.microservgestaolaboratorio.scheduling.entity.SchedulingEntity;

public interface SchedulingService {
    List<SchedulingEntity> findAll();

    SchedulingEntity save(SchedulingSaveDTO scheduling);

    SchedulingEntity findById(String id);

    SchedulingEntity update(String id, SchedulingEntity scheduling);
}
