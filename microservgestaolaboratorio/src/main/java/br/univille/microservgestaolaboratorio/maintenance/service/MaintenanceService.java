package br.univille.microservgestaolaboratorio.maintenance.service;

import java.util.List;

import br.univille.microservgestaolaboratorio.maintenance.dto.MaintenanceSaveDTO;
import br.univille.microservgestaolaboratorio.maintenance.entity.MaintenanceEntity;

public interface MaintenanceService {
  List<MaintenanceEntity> findAll();

  MaintenanceEntity save(MaintenanceSaveDTO maintenanceSaveDTO);

  MaintenanceEntity findById(String id);

  MaintenanceEntity update(String id, MaintenanceEntity maintenance);

  List<MaintenanceEntity> findAllMaintenanceByTeacherId(String teacherId);

  MaintenanceEntity findLastMaintenanceByTeacherId(String teacherId);

}
