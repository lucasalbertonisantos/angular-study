package br.com.lucasalbertoni.alura.angular.alurapic.alurapicbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasalbertoni.alura.angular.alurapic.alurapicbackend.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>{

}
