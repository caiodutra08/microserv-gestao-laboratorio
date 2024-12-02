package br.univille.microservgestaolaboratorio.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.univille.microservgestaolaboratorio.maintenance.dto.MaintenanceSaveDTO;
import br.univille.microservgestaolaboratorio.maintenance.entity.MaintenanceEntity;

public class MaintenanceUtils {
    public static MaintenanceEntity saveDTOToEntity(MaintenanceSaveDTO maintenance) {
        MaintenanceEntity maintenanceEntity = new MaintenanceEntity();
        maintenanceEntity.setLab(maintenance.getLab());
        maintenanceEntity.setStatus(maintenance.getStatus());
        maintenanceEntity.setDate(maintenance.getDate());
        maintenanceEntity.setTeacherId(maintenance.getTeacherId());

        maintenanceEntity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        return maintenanceEntity;
    }
}
