package br.com.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6131311050358241535L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    /*
     * @Transient private Integer parent_product_id;
     * 
     * @ManyToOne(fetch = FetchType.LAZY, optional = true)
     * 
     * @JoinColumn(name="parent_product_id")
     * 
     * @JsonManagedReference private Product parent;
     * 
     * @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
     * 
     * @Cascade({ CascadeType.ALL })
     * 
     * @JsonBackReference private List<Product> children = new
     * ArrayList<Product>() ;
     */

    @JsonBackReference
    // @Cascade({ CascadeType.REMOVE })
    @OneToMany(mappedBy = "product")
    private List<Image> images = new ArrayList<Image>();

    public List<Image> getImages() {
	return images;
    }

    public void setImages(List<Image> images) {

	if (images != null) {
	    images.clear();
	}

	this.images = images;
    }

    /*
     * public List<Product> getChildren() {
     * 
     * if (children != null) { children.clear(); }
     * 
     * return children; }
     * 
     * public void setChildren(List<Product> children) { this.children =
     * children; }
     */

    public Product() {
    }

    public Product(Integer id, String name) {
	this.id = id;
	this.name = name;
    }

    public Product(String name) {
	this.name = name;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * public Product getParent() { return parent; }
     * 
     * public void setParent(Product parent) { this.parent = parent; }
     */

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (description == null ? 0 : description.hashCode());
	result = prime * result + (id == null ? 0 : id.hashCode());
	result = prime * result + (images == null ? 0 : images.hashCode());
	result = prime * result + (name == null ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Product other = (Product) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (images == null) {
	    if (other.images != null)
		return false;
	} else if (!images.equals(other.images))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

}
