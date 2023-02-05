package com.siit.hospital_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="admin")
@Data
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@SuperBuilder
public class Admin extends User {


    public Admin() {

    }


}
