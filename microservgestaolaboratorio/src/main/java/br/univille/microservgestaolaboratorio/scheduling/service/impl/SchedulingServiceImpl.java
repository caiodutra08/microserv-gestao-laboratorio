package br.univille.microservgestaolaboratorio.scheduling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservgestaolaboratorio.scheduling.dto.SchedulingSaveDTO;
import br.univille.microservgestaolaboratorio.scheduling.entity.SchedulingEntity;
import br.univille.microservgestaolaboratorio.scheduling.repository.SchedulingRepository;
import br.univille.microservgestaolaboratorio.scheduling.service.SchedulingService;
import br.univille.microservgestaolaboratorio.utils.SchedulingUtils;

@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Override
    public SchedulingEntity findById(String id) {
        return schedulingRepository.findById(id).orElse(null);
    }

    @Override
    public List<SchedulingEntity> findAll() {
        var scheduling = schedulingRepository.findAll();
        List<SchedulingEntity> schedulingList = new ArrayList<SchedulingEntity>();
        scheduling.forEach(schedulingList::add);

        return schedulingList;
    }

    @Override
    public SchedulingEntity save(SchedulingSaveDTO schedulingSaveDTO) {
        SchedulingEntity scheduling = SchedulingUtils.saveDTOToEntity(schedulingSaveDTO);
        return schedulingRepository.save(scheduling);
    }

    @Override
    public SchedulingEntity update(String id, SchedulingEntity scheduling) {
        var schedulingEntity = schedulingRepository.findById(id).orElse(null);

        if (schedulingEntity == null) {
            return null;
        }

        if (scheduling.getCourse() != null) {
            schedulingEntity.setCourse(scheduling.getCourse());
        }
        if (scheduling.getStatus() != null) {
            schedulingEntity.setStatus(scheduling.getStatus());
        }
        if (scheduling.getLab() != null) {
            schedulingEntity.setLab(scheduling.getLab());
        }
        if (scheduling.getSubject() != null) {
            schedulingEntity.setSubject(scheduling.getSubject());
        }
        if (scheduling.getDate() != null) {
            schedulingEntity.setDate(scheduling.getDate());
        }

        return schedulingRepository.save(schedulingEntity);

    }

}
