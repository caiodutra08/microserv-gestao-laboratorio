package br.univille.microservgestaolaboratorio.scheduling.dto;

import br.univille.microservgestaolaboratorio.course.entity.CourseEntity;
import br.univille.microservgestaolaboratorio.lab.entity.LabEntity;
import br.univille.microservgestaolaboratorio.scheduling.enums.SchedulingStatus;
import br.univille.microservgestaolaboratorio.subject.entity.SubjectEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulingSaveDTO {
  private LabEntity lab;
  private String date;
  private SchedulingStatus status;
  private String teacherId;
  private SubjectEntity subject;
  private CourseEntity course;
}
