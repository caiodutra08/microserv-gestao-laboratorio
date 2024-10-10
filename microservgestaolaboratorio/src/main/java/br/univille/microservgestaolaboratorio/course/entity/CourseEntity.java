package br.univille.microservgestaolaboratorio.course.entity;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseEntity implements Serializable {
  private UUID id;
  private String name;
}
