import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private int id;

    @Column(name = "category_name", length = 100, nullable = false)
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Book> book;
}
