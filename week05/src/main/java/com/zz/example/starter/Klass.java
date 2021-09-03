package com.zz.example.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouzeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
