package ru.trendsoft.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andry on 21.05.17.
 */

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select p from Category p"),
        @NamedQuery(name = "Category.findById", query = "select distinct p from Category p where p.id = :id")
})
public class Category {

    private Long id;
    private String name;
    private Set<News> news = new HashSet<>();

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "news_categories", joinColumns = { @JoinColumn(name = "categories_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "news_id", referencedColumnName = "id") })
    public Set<News> getNews() {
        return news;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Category that = (Category) obj;
        if (!name.equals(that.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + "]";
    }

}
