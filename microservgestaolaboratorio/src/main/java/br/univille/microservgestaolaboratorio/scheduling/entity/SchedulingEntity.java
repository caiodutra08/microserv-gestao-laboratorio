package br.univille.microservgestaolaboratorio.scheduling.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import br.univille.microservgestaolaboratorio.course.entity.CourseEntity;
import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.scheduling.enums.SchedulingStatus;
import br.univille.microservgestaolaboratorio.subject.entity.SubjectEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName = "scheduling", autoCreateContainer = true)
public class SchedulingEntity implements Serializable {
  @Id
  @GeneratedValue
  @PartitionKey
  private String id;
  private LabEntity lab;
  private String date;
  private SchedulingStatus status;
  private String teacherId;
  private SubjectEntity subject;
  private CourseEntity course;
  private String createdAt;
}
