package es.upm.agile.entrepreneursideamanager.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Idea {

  @Id @GeneratedValue private Long id;
  private String name;
  private String description;
  
  @JsonIgnore
  @OneToMany(mappedBy="idea")
  private List<Comment> comments;
  
  protected Idea() {}

  public Idea(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
