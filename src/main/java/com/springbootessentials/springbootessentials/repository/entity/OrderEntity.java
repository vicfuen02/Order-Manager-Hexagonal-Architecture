package com.springbootessentials.springbootessentials.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootessentials.springbootessentials.repository.common.entity.CodeEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Table(name="SPE_ORDERS", schema="SPE_SCHEMA",
        /*uniqueConstraints={
            @UniqueConstraint(columnNames="itemName")
        },*/
        indexes={
            @Index(name="index_order_item_name", columnList="itemName", unique = false)
        }
)
@Entity
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_user_id_gen")
    @SequenceGenerator(name="seq_user_id_gen", sequenceName="SEQ_USER_ID", initialValue = 1000, allocationSize = 5) // name of the sequence, initial value for the seq, number of id hibernate will fetch at the same time to avoid going to the db
    private Long id;

    @Column(unique = false, nullable = false, length=40)
    private String itemName;

    @JoinColumn(name="code", nullable=false, referencedColumnName = "code")
    @ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.EAGER, optional=false)
    private CodeEntity status;



    @JoinColumn(name="address_id", nullable=false, referencedColumnName = "id")
    @ManyToOne(optional=true, fetch = FetchType.LAZY)
    private AddressEntity address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public CodeEntity getStatus() {
        return status;
    }

    public void setStatus(CodeEntity status) {
        this.status = status;
    }


    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", status=" + status +
                '}';
    }
}
