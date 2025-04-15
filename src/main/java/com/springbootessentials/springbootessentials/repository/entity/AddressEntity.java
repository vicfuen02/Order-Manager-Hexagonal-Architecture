package com.springbootessentials.springbootessentials.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Table(name="SPE_ADDRESS", schema="SPE_SCHEMA")
@Entity
public class AddressEntity implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_address_id_gen")
    @SequenceGenerator(name="seq_address_id_gen", sequenceName="SEQ_ADDRESS_ID", initialValue = 1000, allocationSize = 2)
    private Long id;

    @Column(unique = false, nullable = false, length=70)
    private String address;


    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", address='" + address +
                '}';
    }
}
