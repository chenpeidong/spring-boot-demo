package site.syso.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import site.syso.bean.Student;

public interface StudentRepository extends ElasticsearchRepository<Student, Long> {

    List<Student> findByName(String name);

}
