package br.univille.microservgestaolaboratorio.maintenance.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.maintenance.enums.MaintenanceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName = "maintenance", autoCreateContainer = true)
public class MaintenanceEntity implements Serializable {
  @Id
  @PartitionKey
  @GeneratedValue
  private String id;
  private LabEntity lab;
  private MaintenanceStatus status;
  private String date;
  private String teacherId;
  private String createdAt;
}
