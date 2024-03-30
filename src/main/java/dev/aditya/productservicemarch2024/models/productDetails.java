package dev.aditya.productservicemarch2024.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class productDetails extends BaseModel{
    private String title;
    private String Description;
    private double price;
    private String imageUrl;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private category Category;
    public productDetails(String s) {
        super();
    }
}
