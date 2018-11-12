package negocio.entidade;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import negocio.entidade.Adocao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T11:28:42")
@StaticMetamodel(Animal.class)
public class Animal_ { 

    public static volatile SingularAttribute<Animal, BigInteger> tipo;
    public static volatile CollectionAttribute<Animal, Adocao> adocaoCollection;
    public static volatile SingularAttribute<Animal, Date> datanasc;
    public static volatile SingularAttribute<Animal, Integer> idanimal;
    public static volatile SingularAttribute<Animal, String> raca;
    public static volatile SingularAttribute<Animal, String> nome;
    public static volatile SingularAttribute<Animal, Boolean> status;

}