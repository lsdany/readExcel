package com.ld.entity;

/**
 * @author luisdany
 */
public class Student {

    private int idStudent;
    private String name;
    private String code;
    private String email;
    private int idClass;
    private String section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", idClass=" + idClass +
                ", section='" + section + '\'' +
                '}';
    }

}
