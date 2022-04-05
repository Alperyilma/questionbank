package mathbank.questionbank.entities.conceretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Size(max = 50)
    @NotNull(message = "Please enter the product name")
    @Column(name = "product_name")
    private String productName;

    @Size(max = 250)
    @NotNull(message = "Please enter the link")
    @Column(name = "link_of_product")
    private String linkOfProduct;

    @Size(max = 3)
    @NotNull(message = "Please enter the category")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
