package in.inuron.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "student_name", nullable = false, length = 344)
    private String name;

    @Column(name = "email", nullable = false, length = 120)
    private String email;

    private LocalDate DOB;

    @Lob
    private byte[] photo;

    @Lob
    private char[] bioData;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @CreationTimestamp
    private LocalDate createdAt;
}
