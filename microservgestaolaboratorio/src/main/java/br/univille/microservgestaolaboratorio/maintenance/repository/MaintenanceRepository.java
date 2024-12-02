package br.univille.microservgestaolaboratorio.maintenance.repository;

import org.springframework.stereotype.Repository;

import br.univille.microservgestaolaboratorio.maintenance.entity.MaintenanceEntity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceEntity, String> {
    List<MaintenanceEntity> findAllMaintenanceByTeacherId(String teacherId);

    MaintenanceEntity findTop1ByTeacherIdOrderByCreatedAt(String teacherId);
}
