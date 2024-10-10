package br.univille.microservgestaolaboratorio.lab.entity;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabEntity implements Serializable {
  private UUID id;
  private String name;
}
