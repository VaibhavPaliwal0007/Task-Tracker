package org.example.tasktrackerbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Image.
 */
@Entity
@Getter
@Setter
@Table(name = "image")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NoArgsConstructor
public class Image implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(max = 100)
  @Column(name = "name", length = 100)
  private String name;

  @NotNull
  @Size(max = 255)
  @Column(name = "path", nullable = false)
  private String path;

  @Size(max = 255)
  @Column(name = "original_filename")
  private String originalFileName;

  @Column(name = "width")
  private Integer width;

  @Column(name = "height")
  private Integer height;

  @Column(name = "sequence")
  private Integer sequence;

  @Column(name = "public_url")
  private String publicUrl;

  @Column(name = "image_data")
  private String imageData;

  @Column(name = "created_at")
  @Size(max = 19)
  private String createdAt;

  public static Image newImage(String name, String imageData) {
    Image image = newImage();
    image.name = name;
    image.imageData = imageData;
    return image;
  }
}

