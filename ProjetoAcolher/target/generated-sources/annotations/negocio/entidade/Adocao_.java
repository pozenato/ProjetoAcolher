package negocio.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import negocio.entidade.Animal;
import negocio.entidade.Pessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T11:28:42")
@StaticMetamodel(Adocao.class)
public class Adocao_ { 

    public static volatile SingularAttribute<Adocao, Date> dataadocao;
    public static volatile SingularAttribute<Adocao, Integer> idadocao;
    public static volatile SingularAttribute<Adocao, Animal> idanimal;
    public static volatile SingularAttribute<Adocao, Pessoa> idpessoa;

}