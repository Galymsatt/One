package kz.one.lab.lesson4.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_arenas")
public class Arena {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "name")
    private String name;
    @Setter
//    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Fighter> fighters;



//    List<Fighter> fighters = new ArrayList<>();

//    public List<Fighter> getFighters() {//Jpa eto zameniaet
//        return fighters;
//    }

}
