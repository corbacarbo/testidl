package controleAcces;

/**
 * Un zoneur est responsable :
 * - maintenir une liste des personnes actuellement présentes dans sa zone
 * (afin d'éviter les usurpations)
 * - servir de relais pour décharger le naming service : les entités et 
 * clients spécifiques à une zone passent par lui pour obtenir des IOR.
 * - de gérer les id des portes présentes dans sa zone.
 */
public interface zoneur extends zoneurOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity
{
}
