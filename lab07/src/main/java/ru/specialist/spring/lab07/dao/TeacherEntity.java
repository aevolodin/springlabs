package ru.specialist.spring.lab07.dao;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "teachers", schema = "public")
public class TeacherEntity {
    private int id;
    private String name;
    private String addr;
    private String phone;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "addr", nullable = false, length = -1)
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 25)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(addr, that.addr) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addr, phone);
    }

    @Override
    public String toString() {
        return String.format("%-3d %s %s %s", getId(), getName(), getAddr(), getPhone());
    }
}
