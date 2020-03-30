package com.redis.mapper;

import com.redis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface StudentMapper{
    public List<Student> findAll(Map<String, Object> params);
    public Student findById(int id);
    public void saveOrUpdate(Student student);
    public void deleteById(int id);
}
