package negocio.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import negocio.entidade.Adocao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T11:28:42")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> telefone;
    public static volatile CollectionAttribute<Pessoa, Adocao> adocaoCollection;
    public static volatile SingularAttribute<Pessoa, Date> datanasc;
    public static volatile SingularAttribute<Pessoa, Date> datacadastro;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Integer> idpessoa;
    public static volatile SingularAttribute<Pessoa, Boolean> status;

}