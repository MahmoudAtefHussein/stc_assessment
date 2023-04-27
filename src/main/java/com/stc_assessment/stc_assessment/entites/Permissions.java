package com.stc_assessment.stc_assessment.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "permissions", uniqueConstraints = @UniqueConstraint(columnNames = {"user_email", "permission_level", "group_id"}, name = "uk_email_level_group"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "permissions_s", sequenceName = "permissions_s", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_s")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "permission_level", nullable = false)
    private String permissionLevel;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private PermissionGroups permissionGroup;
}
