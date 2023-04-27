package com.stc_assessment.stc_assessment.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "item_s", sequenceName = "item_s", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_s")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "permission_group_id", referencedColumnName = "id", nullable = false)
    private PermissionGroups permissionGroup;
}
