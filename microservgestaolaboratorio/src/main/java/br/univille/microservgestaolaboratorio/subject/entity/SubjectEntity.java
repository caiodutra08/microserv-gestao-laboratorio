package br.univille.microservgestaolaboratorio.subject.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName = "subject", autoCreateContainer = true)
public class SubjectEntity implements Serializable {
  @Id
  @PartitionKey
  private String id;
  private String name;
}
