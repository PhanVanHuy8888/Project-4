package project4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable = false,
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" ,nullable = false,
                foreignKey = @ForeignKey(name = "ORDER_DETAIL_FK"))
    private Product product;

    private Integer quantity;

    private Float price;

    private Float total;

}
