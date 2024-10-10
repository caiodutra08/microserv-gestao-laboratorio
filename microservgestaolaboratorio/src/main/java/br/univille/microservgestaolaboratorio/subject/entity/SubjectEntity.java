package br.univille.microservgestaolaboratorio.subject.entity;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectEntity implements Serializable {
  private UUID id;
  private String name;
}
