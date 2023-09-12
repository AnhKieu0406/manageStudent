package com.vn.devmaster.services.managestudent.service;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.mapper.AddressMapper;
import com.vn.devmaster.services.managestudent.mapper.StudentMapper;
import com.vn.devmaster.services.managestudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class
StudentService {
//        List<Student> findAll();
//
//        List<StudentDTO> findAllDTO();
//
//        StudentDTO findById(Integer id);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AddressMapper addressMapper;


    public List<Student> getAll(){
        List<Student> list = studentRepository.findAll();
        return list;
    }

    public List<StudentDTO> findAll(){
        List<Student> list = getAll();
       return studentMapper.toDTO(list);

    }
    public List<Student> getByName(String name){
        List<Student> list = getAll();
        List<Student>   findName = new ArrayList<>();
        for (Student student : list){
            if(student.getFirstName().equals(name)){
                findName.add(student);
            }
        }
        return findName;
    }

    public void save(StudentDTO student) {
        Student students = studentMapper.toEntity(student);
        studentRepository.save(students);
    }

    @Transactional
    public void save(List<StudentDTO> studentDTOS) {
        List<Student> students = studentMapper.toEntity(studentDTOS);
       studentRepository.saveAll(students);
    }

    public List<StudentDTO> filterByname(String name) {
        List<Student> students = studentRepository.filterByName(name);
       return studentMapper.toDTO(students);

    }
    public List<StudentDTO> findById(Integer id){
        List<Student> student = studentRepository.findAllById(id);
        return studentMapper.toDTO(student);
    }

    public List<StudentDTO> findByCity(String city) {
        List<Student> students= studentRepository.findAllByAdress_City(city);
        return  studentMapper.toDTO(students);
    }

    public void deletebyId(Integer id) {
//        if (id >= 1) {
//            List<Student>  student = studentRepository.findAllById(id);
//            if (student != null) {
//                studentRepository.deleteById(id);
//            }
//        }
        studentRepository.deleteById(id);
    }
}
