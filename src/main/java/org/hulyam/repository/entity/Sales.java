package org.hulyam.repository.entity;

import lombok.*;
import org.hulyam.constant.EPaymentMethod;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblsales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> purchased;
    private Double total;
    @Builder.Default
    private Long orderdate = System.currentTimeMillis();
    private EPaymentMethod paymentmethod;

}
