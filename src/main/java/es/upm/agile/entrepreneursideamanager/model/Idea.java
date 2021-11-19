package es.upm.agile.entrepreneursideamanager.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Idea {

  @Id @GeneratedValue private Long id;
  private String name;
  private String description;

  protected Idea() {}

  Idea(String name, String description) {
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
