package com.itlg.demo.pdf;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Data
public class Test {

    public static void main(String[] args) {
        List<stu> stuList = new ArrayList<>();
        stuList.add(new stu(18, "a", "1"));
        stuList.add(new stu(18, "a", "1"));
        stuList.add(new stu(18, "a", "2"));
        stuList.add(new stu(18, "a", "3"));
        HashSet<stu> hashSet = new HashSet();
        stuList.forEach(e->{
            hashSet.add(e);
        });
        hashSet.forEach(e->{
            System.out.println(e.toString());
        });
    }

}
@ToString
class stu {
    int age;
    String name;
    String num;

    public stu(int age, String name, String num) {
        this.age = age;
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stu stu = (stu) o;
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}


