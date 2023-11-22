package vn.edu.iuh.fit.thuchanhwww_buoi3.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skill {
    @Id
    @Column(name = "skill_id")
    private UUID id=UUID.randomUUID();

    @Column(name = "skill_description", columnDefinition = "varchar(255)")
    private String skillDescription=null;

    @Column(name = "skill_name", columnDefinition = "varchar(255)")
    private String skillName=null;

    @Column(columnDefinition = "tinyint(4)")
    private int type;

}