package tv.voxus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "paymentSequence")
    @Column(name = "id", length = 3)
    private Integer id;

    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @NotBlank(message = "Title is required")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotNull(message = "Value is required")
    @Column(name = "value", nullable = false, length = 12, precision = 2)
    private Double value;

    @NotNull(message = "Date is required")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "tax"/*, nullable = false*/, length = 9, precision = 2)
    private Double tax;

    @Size(max = 250, message = "Comment can only be up to 250 characters")
    @Column(name = "comment", length = 250)
    private String comment;

}
