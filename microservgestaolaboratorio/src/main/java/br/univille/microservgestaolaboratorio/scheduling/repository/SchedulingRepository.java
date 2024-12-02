package br.univille.microservgestaolaboratorio.scheduling.repository;

import org.springframework.stereotype.Repository;

import br.univille.microservgestaolaboratorio.scheduling.entity.SchedulingEntity;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface SchedulingRepository extends CrudRepository<SchedulingEntity, String> {
}
