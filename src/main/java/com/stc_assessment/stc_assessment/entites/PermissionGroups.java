package com.stc_assessment.stc_assessment.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "permission_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionGroups {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "permission_groups_s", sequenceName = "permission_groups_s", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_groups_s")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;
}
