package ru.trendsoft.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andry on 21.05.17.
 */

@Entity
@Table(name = "news")
@NamedQueries({
        @NamedQuery(name = "News.findAll", query = "select p from News p"),
        @NamedQuery(name = "News.findById", query = "select distinct p from News p where p.id = :id")
})
public class News {

    private Long id;
    private String name;
    private String content;
    private Date date;
    private Set<Category> categorys = new HashSet<>();

    public News(){};

    public News(String name, String content){
        this.name = name;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "news_categories",
            joinColumns={@JoinColumn(name = "news_id", referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name = "categories_id", referencedColumnName = "id")})
    public Set<Category> getCategorys() {
        return categorys;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getDate(){ return date; }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }

    public void setDate(Date date){ this.date = date; }

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
        return "[id=" + this.id + ", name=" + this.name + ", content=" + this.content + "]";
    }
}
