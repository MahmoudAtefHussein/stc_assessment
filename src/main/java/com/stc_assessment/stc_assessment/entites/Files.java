package com.stc_assessment.stc_assessment.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Files {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "files_s", sequenceName = "files_s", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "files_s")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "file_binary", nullable = false)
    @Lob
    private byte[] fileBinary;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_path", nullable = false)
    private String filePath;

}
