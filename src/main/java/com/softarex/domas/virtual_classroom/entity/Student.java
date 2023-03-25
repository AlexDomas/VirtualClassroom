package com.softarex.domas.virtual_classroom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends BaseEntity implements Serializable {

    private String name;
    private boolean hand;

}
