package br.univille.microservgestaolaboratorio.maintenance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.maintenance.enums.MaintenanceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceEntity implements Serializable {
  private UUID id;
  private LabEntity lab;
  private MaintenanceStatus status;
  private Date date_maintenance;
  private UUID id_teacher;
  private Date created_at;
}
