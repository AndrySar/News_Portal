package ru.trendsoft.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Andry on 21.05.17.
 */

@Entity
@Table(name = "news")
@NamedQueries({
        @NamedQuery(name = "News.findAll", query = "select p from News p"),
        @NamedQuery(name = "News.findById", query = "select distinct p from News p where p.id = :id"),
        @NamedQuery(name = "News.findByTitleAndContent", query = "select p from News p where p.name like :search or p.content like :search"),
        @NamedQuery(name = "News.findByCategoryId", query = "select p from News p join p.categorys g where g.id = :categoryId")

})
public class News implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String content;
    private Date date;
    private Set<Category> categorys = new HashSet<>();
    private String formatDate;


    public News(){};

    public News(String name, String content){
        this.name = name;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name", length = 500 )
    public String getName() {
        return name;
    }

    @Column(name = "description", length = 1000 )
    public String getDescription() { return description; }

    @Column(name = "content", length = 5000 )
    public String getContent() {
        return content;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "news_categories",
            joinColumns=@JoinColumn(name = "news_id", referencedColumnName = "id"),
            inverseJoinColumns={@JoinColumn(name = "categories_id", referencedColumnName = "id")})
    public Set<Category> getCategorys() {
        return categorys;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getDate(){ return date; }

    @Transient
    public String getFormatDate() {
        return formatDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) { this.description = description; }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }

    public void setCategorys(Category category) {
        this.categorys.add(category);
    }

    public void setCategorys(List<Category> categoryList) {
        this.categorys.addAll(categoryList);
    }

    public void setDate(Date date){
        this.date = date;
        this.formatDate = (new SimpleDateFormat(" E d MMMM, yyyy").format(this.date));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        if (!name.equals(that.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", content=" + this.content + "]";
    }


}
