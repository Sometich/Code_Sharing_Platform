package platform.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Code {

    @Id
    @Column(nullable = false)
    @JsonIgnore
    private String id;
    private String code;
    private String date;
    private long time;
    private long views;
    @Transient
    @JsonIgnore
    private boolean viewsLimited;
}