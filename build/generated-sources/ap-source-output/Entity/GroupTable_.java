package Entity;

import Entity.GroupMatch;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-30T20:07:24", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(GroupTable.class)
public class GroupTable_ { 

    public static volatile SingularAttribute<GroupTable, String> password;
    public static volatile SingularAttribute<GroupTable, String> address;
    public static volatile SingularAttribute<GroupTable, String> role;
    public static volatile SingularAttribute<GroupTable, String> city;
    public static volatile SingularAttribute<GroupTable, String> phone;
    public static volatile SingularAttribute<GroupTable, Integer> id;
    public static volatile SingularAttribute<GroupTable, String> state;
    public static volatile SingularAttribute<GroupTable, String> email;
    public static volatile ListAttribute<GroupTable, GroupMatch> groupMatchList;
    public static volatile SingularAttribute<GroupTable, String> username;

}