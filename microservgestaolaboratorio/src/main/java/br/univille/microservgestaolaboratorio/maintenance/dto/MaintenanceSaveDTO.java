package br.univille.microservgestaolaboratorio.maintenance.dto;

import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.maintenance.enums.MaintenanceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceSaveDTO {
    private LabEntity lab;
    private MaintenanceStatus status;
    private String date;
    private String teacherId;
}
