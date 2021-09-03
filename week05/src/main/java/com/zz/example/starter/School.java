package com.zz.example.starter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author zhouzeng
 */
@Data
public class School implements ISchool {

    // Resource //primary
    @Autowired(required = true)
    Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }

}
