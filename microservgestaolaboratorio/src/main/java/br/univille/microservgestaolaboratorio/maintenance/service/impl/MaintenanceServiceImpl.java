package br.univille.microservgestaolaboratorio.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservgestaolaboratorio.maintenance.dto.MaintenanceSaveDTO;
import br.univille.microservgestaolaboratorio.maintenance.entity.MaintenanceEntity;
import br.univille.microservgestaolaboratorio.maintenance.repository.MaintenanceRepository;
import br.univille.microservgestaolaboratorio.maintenance.service.MaintenanceService;
import br.univille.microservgestaolaboratorio.utils.MaintenanceUtils;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

  @Autowired
  private MaintenanceRepository maintenanceRepository;

  @Override
  public List<MaintenanceEntity> findAll() {
    var maintenance = maintenanceRepository.findAll();
    List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
    maintenance.forEach(maintenanceList::add);

    return maintenanceList;
  }

  @Override
  public MaintenanceEntity save(MaintenanceSaveDTO maintenanceSaveDTO) {
    MaintenanceEntity maintenance = MaintenanceUtils.saveDTOToEntity(maintenanceSaveDTO);
    return maintenanceRepository.save(maintenance);
  }

  @Override
  public MaintenanceEntity findById(String id) {
    return maintenanceRepository.findById(id).orElse(null);
  }

  @Override
  public MaintenanceEntity update(String id, MaintenanceEntity maintenance) {
    var maintenanceEntity = maintenanceRepository.findById(id).orElse(null);

    if (maintenanceEntity == null) {
      return null;
    }

    if (maintenance.getLab() != null) {
      maintenanceEntity.setLab(maintenance.getLab());
    }

    if (maintenance.getStatus() != null) {
      maintenanceEntity.setStatus(maintenance.getStatus());
    }

    if (maintenance.getDate() != null) {
      maintenanceEntity.setDate(maintenance.getDate());
    }

    if (maintenance.getTeacherId() != null) {
      maintenanceEntity.setTeacherId(maintenance.getTeacherId());
    }

    return maintenanceRepository.save(maintenanceEntity);
  }

  @Override
  public List<MaintenanceEntity> findAllMaintenanceByTeacherId(String teacherId) {
    var maintenance = maintenanceRepository.findAllMaintenanceByTeacherId(teacherId);
    List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
    maintenance.forEach(maintenanceList::add);

    return maintenanceList;
  }

  @Override
  public MaintenanceEntity findLastMaintenanceByTeacherId(String teacherId) {
    return maintenanceRepository.findTop1ByTeacherIdOrderByCreatedAt(teacherId);
  }

}
