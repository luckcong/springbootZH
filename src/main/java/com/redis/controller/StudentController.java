package com.redis.controller;

import com.redis.entity.Student;
import com.redis.mapper.StudentMapper;
import com.redis.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "swagger操作接口测试")
@RestController
@RequestMapping("/redis")
public class StudentController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private StudentMapper studentMapper;

    public  static Map<String,Object> map=new HashMap<String,Object>();

    @GetMapping("/set/{key}")
    public void setTest(@RequestBody Student student,@PathVariable("key") String key){
        redisUtil.set(key,student);
    }

    @GetMapping("/get/{key}")
    public Student getStu(@PathVariable("key") String key){
        return (Student) redisUtil.get(key);
    }

//    @DeleteMapping("/delete/{key}")
//    public boolean delStu(@PathVariable("key") String key){
//        redisUtil.del(key);
//        return redisUtil.hasKey(key);
//    }

    @ApiOperation("查询学生所有数据")
    @GetMapping("/findAll/{index}/{limit}")
    public List<Student> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        map.clear();
        map.put("index",index);
        map.put("lim",limit);
        List<Student> list= studentMapper.findAll(map);
        return list;
    }

    @GetMapping("/getTest")
    public String getTest(){
        return "成功";
    }




}
