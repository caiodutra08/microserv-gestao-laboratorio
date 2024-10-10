package br.univille.microservgestaolaboratorio.scheduling.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import br.univille.microservgestaolaboratorio.course.entity.CourseEntity;
import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.scheduling.enums.SchedulingStatus;
import br.univille.microservgestaolaboratorio.subject.entity.SubjectEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulingEntity implements Serializable {
  private UUID id;
  private LabEntity lab;
  private Date scheduling_date;
  private SchedulingStatus status;
  private UUID id_teacher;
  private SubjectEntity subject;
  private CourseEntity course;
  private Date created_at;
}
