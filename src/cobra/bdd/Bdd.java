package cobra.bdd;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.Date;
import cobra.Empreinte;
import cobra.Horaire;
import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import cobra.PersonneTemporaire;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Bdd {

  private DocumentBuilderFactory factory;
  private DocumentBuilder builder;
  private Document document;
  private Element root;

  private TransformerFactory transformerFactory;
  private Transformer transformer;
  private DOMSource source;
  private StreamResult sortie;

  private File file;

  private HashMap<String, String> pps;
  private HashMap<String, String> pts;

  public Bdd(String type, String zone) {
	factory = DocumentBuilderFactory.newInstance();
	try {
	  builder = factory.newDocumentBuilder();
	} catch (ParserConfigurationException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	}

	switch (type) {
	  case "personne":
		file = new File("src\\cobra\\bdd\\personnes.xml");
		break;
	  case "empreinte":
		file = new File("src\\cobra\\bdd\\empreintes.xml");
		break;
	  case "autorisation":
		if (zone != null) {
		  file = new File("src\\cobra\\bdd\\autorisations" + zone + ".xml");
		} else {
		  file = new File("src\\cobra\\bdd\\autorisations" + "T" + ".xml");
		}
		break;
	}

	try {
	  document = builder.parse(file);
	  root = document.getDocumentElement();
	} catch (SAXException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	}

	try {
	  transformerFactory = TransformerFactory.newInstance();
	  transformer = transformerFactory.newTransformer();
	  source = new DOMSource(document);
	  sortie = new StreamResult(file);
	} catch (TransformerConfigurationException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	}

  }

  private void clearPps() {
	pps = new HashMap<>();
	pps.put("matricule", "");
	pps.put("nom", "");
	pps.put("prenom", "");
	pps.put("mdp", "");
	pps.put("photo", "");
	pps.put("changemdp", "");
	pps.put("responsabilite", "");
  }

  private void fillPps(PersonnePermanent pers) {
	clearPps();
	pps.put("matricule", pers.getMatricule().toIdl());
	pps.put("nom", pers.getNom());
	pps.put("prenom", pers.getPrenom());
	pps.put("mdp", pers.getMdp());
	pps.put("photo", pers.getPhoto());
	pps.put("changemdp", Boolean.toString(pers.isMdpChange()));
	pps.put("responsabilite", pers.getResponsabilite());
  }

  private void clearPts() {
	pts = new HashMap<>();
	pts.put("matricule", "");
	pts.put("nom", "");
	pts.put("prenom", "");
	pts.put("photo", "");
  }

  private void fillPts(PersonneTemporaire pers) {
	clearPps();
	pps.put("matricule", pers.getMatricule().toIdl());
	pps.put("nom", pers.getNom());
	pps.put("prenom", pers.getPrenom());
	pps.put("photo", pers.getPhoto());
  }

  public HashMap<Matricule, Personne> loadPersonnes() {
	HashMap<Matricule, Personne> personnesMap = new HashMap<>();
	NodeList personnesList = root.getChildNodes();
	Personne pers;

	int i = 0;
	while (i < personnesList.getLength()) {
	  Node personneNode = personnesList.item(i);

	  if (personneNode.getNodeType() == Node.ELEMENT_NODE) {
		if (personneNode.getNodeName().equals("personnePermanent")) {
		  pers = extractPersonnePermanente(personneNode);
		} else if (personneNode.getNodeName().equals("personneTemporaire")) {
		  pers = extractPersonneTemporaire(personneNode);
		} else {
		  System.out.println("Erreur de balise");
		  return null;
		}
		personnesMap.put(pers.getMatricule(), pers);
	  }
	  i++;
	}
	return personnesMap;
  }

  public HashMap<Empreinte, Matricule> loadEmpreintes() {
	HashMap<Empreinte, Matricule> res = new HashMap<>();
	NodeList empreintesList = root.getChildNodes();
	Matricule matricule;
	Empreinte empreinte;

	int i = 0;
	while (i < empreintesList.getLength()) {
	  if (empreintesList.item(i).getNodeType() == Node.ELEMENT_NODE) {
		Element champ = (Element) empreintesList.item(i);
		matricule = new Matricule(champ.getElementsByTagName("matricule")
				.item(0).getTextContent());
		empreinte = new Empreinte(Long.parseLong(champ.getElementsByTagName("empreinte")
				.item(0).getTextContent()));
		res.put(empreinte, matricule);
	  }
	  i++;
	}
	return res;
  }

  public ArrayList<Autorisation> loadAutorisations(String zoneParam) {
	ArrayList<Autorisation> res = new ArrayList<>();
	NodeList autorisationsList = root.getChildNodes();

	int i = 0;
	while (i < autorisationsList.getLength()) {
	  if (autorisationsList.item(i).getNodeType() == Node.ELEMENT_NODE) {
		Autorisation autoObj;
		Node autoNode = autorisationsList.item(i);
		Element autoEle = (Element) autoNode;
		if (zoneParam != null && autoNode.getNodeName().equals("autorisation")) {
		  String zone = autoEle.getElementsByTagName("zone").item(0).
				  getTextContent();
		  if (zone.equals(zoneParam)) {
			Matricule mat = new Matricule(autoEle.
					getElementsByTagName("matricule").item(0).getTextContent());
			Horaire horaireD = new Horaire(autoEle.
					getElementsByTagName("horaired").item(0).getTextContent());
			Horaire horaireF = new Horaire(autoEle.
					getElementsByTagName("horairef").item(0).getTextContent());
			autoObj = new Autorisation(mat, horaireD, horaireF);
			res.add(autoObj);
		  }
		} else if (zoneParam == null && autoNode.getNodeName().equals("autorisationRestreinte")) {
		  Matricule mat = new Matricule(autoEle.
				  getElementsByTagName("matricule").item(0).getTextContent());
		  Horaire horaireD = new Horaire(autoEle.
				  getElementsByTagName("horaired").item(0).getTextContent());
		  Horaire horaireF = new Horaire(autoEle.
				  getElementsByTagName("horairef").item(0).getTextContent());
		  Date dateD = new Date(autoEle.
				  getElementsByTagName("dated").item(0).getTextContent());
		  dateD.add(Calendar.MONTH, -1);
		  Date dateF = new Date(autoEle.
				  getElementsByTagName("datef").item(0).getTextContent());
		  dateF.add(Calendar.MONTH, -1);
		  String zone = autoEle.getElementsByTagName("zone").item(0).
				  getTextContent();
		  autoObj = new AutorisationRestreinte(dateD, dateF, zone, mat, horaireD, horaireF);
		  res.add(autoObj);
		}

	  }
	  i++;
	}
	return res;
  }

  private PersonnePermanent extractPersonnePermanente(Node personneNode) {
	PersonnePermanent res;
	clearPps();
	NodeList attributesNode = personneNode.getChildNodes();
	Element pp = (Element) personneNode;

	for (String nom : pps.keySet()) {
	  String valeur = pp.getElementsByTagName(nom).item(0).getTextContent();
	  pps.replace(nom, valeur);
	}

//	int i = 0;
//	while (i < attributesNode.getLength()) {
//	  Node attributeNode = attributesNode.item(i);
//	  if (attributeNode.getNodeType() == Node.ELEMENT_NODE) {
//		Node content = attributeNode.getFirstChild();
//		if (content != null) {
//		  pps.replace(attributeNode.getNodeName(), content.getNodeValue());
//		}
//	  }
//	  i++;
//	}
	res = new PersonnePermanent(pps.get("mdp"),
			Boolean.parseBoolean(pps.get("changemdp")),
			pps.get("responsabilite"),
			new Matricule(pps.get("matricule")),
			pps.get("nom"),
			pps.get("prenom"),
			pps.get("photo"));
	return res;
  }

  private PersonneTemporaire extractPersonneTemporaire(Node personneNode) {
	PersonneTemporaire res;
	clearPts();
	NodeList attributesNode = personneNode.getChildNodes();

	Element pp = (Element) personneNode;

	for (String nom : pts.keySet()) {
	  String valeur = pp.getElementsByTagName(nom).item(0).getTextContent();
	  pts.replace(nom, valeur);
	}

//	int i = 0;
//	while (i < attributesNode.getLength()) {
//	  Node attributeNode = attributesNode.item(i);
//	  if (attributeNode.getNodeType() == Node.ELEMENT_NODE) {
//		Node content = attributeNode.getFirstChild();
//		if (content != null) {
//		  pts.replace(attributeNode.getNodeName(), content.getNodeValue());
//		}
//	  }
//	  i++;
//	}
	res = new PersonneTemporaire(new Matricule(pts.get("matricule")),
			pts.get("nom"),
			pts.get("prenom"),
			pts.get("photo"));
	return res;
  }

  public void addPersonnePermanente(PersonnePermanent p) {
	fillPps(p);
	Element personneNode = document.createElement("personnePermanent");
	root.appendChild(personneNode);

	for (String nom : pps.keySet()) {
	  Element newAttribute = document.createElement(nom);
	  personneNode.appendChild(newAttribute);
	  newAttribute.appendChild(document.createTextNode(pps.get(nom)));
	}
	write();
  }

  public void addPersonneTemporaire(PersonneTemporaire p) {
	fillPts(p);
	Element personneNode = document.createElement("personneTemporaire");
	root.appendChild(personneNode);

	for (String nom : pts.keySet()) {
	  Element newAttribute = document.createElement(nom);
	  personneNode.appendChild(newAttribute);
	  newAttribute.appendChild(document.createTextNode(pps.get(nom)));
	}
	write();
  }

  public void modifierMdp(Matricule matricule, String nouveauMdp) {
	NodeList personnesList = root.getChildNodes();

	int i = 0;
	while (i < personnesList.getLength()) {
	  Node personneNode = personnesList.item(i);

	  if (personneNode.getNodeType() == Node.ELEMENT_NODE) {
		Element personneElement = (Element) personneNode;
		String mat = personneElement.getElementsByTagName("matricule").item(0)
				.getTextContent();
		Matricule matCourant = new Matricule(mat);
		if (matricule.equals(matCourant)) {
		  personneElement.getElementsByTagName("mdp").item(0)
				  .setTextContent(nouveauMdp);
		  write();
		  return;
		}
	  }
	  i++;
	}
  }

  public void addEmpreinte(Matricule matricule, Empreinte empreinte) {
	Element couple = document.createElement("empreinte");
	root.appendChild(couple);

	Element mat = document.createElement("matricule");
	mat.appendChild(document.createTextNode(matricule.getMat()));
	couple.appendChild(mat);
	Element emp = document.createElement("empreinte");
	emp.appendChild(document.createTextNode(Long.toString(empreinte.toIdl())));
	couple.appendChild(emp);

	write();
  }

  public void removeEmpreinte(Matricule matricule) {
	NodeList empreintesList = root.getChildNodes();

	int i = 0;
	while (i < empreintesList.getLength()) {
	  Node empreinteNode = empreintesList.item(i);

	  if (empreinteNode.getNodeType() == Node.ELEMENT_NODE) {
		Element empreinteElement = (Element) empreinteNode;
		String mat = empreinteElement.getElementsByTagName("matricule").item(0)
				.getTextContent();
		Matricule matCourant = new Matricule(mat);
		if (matricule.equals(matCourant)) {
		  root.removeChild(empreinteNode);
		  write();
		  return;
		}
	  }
	  i++;
	}
	System.out.println("bdd: impossible d'enlever l'empreinte.");
  }

  public void modifierEmpreinte(Matricule matricule, Empreinte empreinte) {
	NodeList empreintesList = root.getChildNodes();

	int i = 0;
	while (i < empreintesList.getLength()) {
	  Node empreinteNode = empreintesList.item(i);

	  if (empreinteNode.getNodeType() == Node.ELEMENT_NODE) {
		Element empreinteElement = (Element) empreinteNode;
		String mat = empreinteElement.getElementsByTagName("matricule").item(0)
				.getTextContent();
		Matricule matCourant = new Matricule(mat);
		if (matricule.equals(matCourant)) {
		  empreinteElement.getElementsByTagName("empreinte").item(0)
				  .setTextContent(Long.toString(empreinte.toIdl()));
		  write();
		  return;
		}
	  }
	  i++;
	}
	addEmpreinte(matricule, empreinte);
  }

  public void addAutorisation(Autorisation auto, String zoneParam) {
	Element autoEle = document.createElement("autorisation");
	root.appendChild(autoEle);

	String mat = auto.getMatricule().toIdl();
	Element matEle = document.createElement("matricule");
	matEle.appendChild(document.createTextNode(mat));
	autoEle.appendChild(matEle);

	String horaireD = auto.getHoraireD().toStringSimple();
	Element horaireDEle = document.createElement("horaired");
	horaireDEle.appendChild(document.createTextNode(horaireD));
	autoEle.appendChild(horaireDEle);

	String horaireF = auto.getHoraireF().toStringSimple();
	Element horaireFEle = document.createElement("horairef");
	horaireFEle.appendChild(document.createTextNode(horaireF));
	autoEle.appendChild(horaireFEle);

	Element zoneEle = document.createElement("zone");
	zoneEle.appendChild(document.createTextNode(zoneParam));
	autoEle.appendChild(zoneEle);

	write();
  }

  public void addAutorisationRestreinte(AutorisationRestreinte auto) {
	try {
	  builder.parse(file);
	} catch (SAXException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	}

	Element autoEle = document.createElement("autorisationRestreinte");
	root.appendChild(autoEle);

	String mat = auto.getMatricule().toIdl();
	Element matEle = document.createElement("matricule");
	matEle.appendChild(document.createTextNode(mat));
	autoEle.appendChild(matEle);

	String horaireD = auto.getHoraireD().toStringSimple();
	Element horaireDEle = document.createElement("horaired");
	horaireDEle.appendChild(document.createTextNode(horaireD));
	autoEle.appendChild(horaireDEle);

	String horaireF = auto.getHoraireF().toStringSimple();
	Element horaireFEle = document.createElement("horairef");
	horaireFEle.appendChild(document.createTextNode(horaireF));
	autoEle.appendChild(horaireFEle);

	String dateD = auto.getDateDPrint().toStringSimple();
	Element dateDEle = document.createElement("dated");
	dateDEle.appendChild(document.createTextNode(dateD));
	autoEle.appendChild(dateDEle);

	String dateF = auto.getDateFPrint().toStringSimple();
	Element dateFEle = document.createElement("datef");
	dateFEle.appendChild(document.createTextNode(dateF));
	autoEle.appendChild(dateFEle);

	String zone = auto.getZone();
	Element zoneEle = document.createElement("zone");
	zoneEle.appendChild(document.createTextNode(zone));
	autoEle.appendChild(zoneEle);

	write();
  }

  private void write() {
	try {
	  transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	  transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	  //transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	  transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

	  transformer.transform(source, sortie);

	} catch (TransformerConfigurationException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	} catch (TransformerException ex) {
	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

  public static void main(String[] args) {
	Bdd bddA = new Bdd("autorisation", "D");
	Bdd bddT = new Bdd("autorisation", null);

	ArrayList<Autorisation> autos = bddA.loadAutorisations("A");
	for (Autorisation auto : autos) {
	  System.out.println(auto);
	}
	autos = bddT.loadAutorisations(null);
	for (Autorisation auto : autos) {
	  System.out.println(auto);
	}

	bddA.addAutorisation(new Autorisation(new Matricule("pjohn"), new Horaire("22:00"), new Horaire("23:00")), "D");

	bddT.addAutorisationRestreinte(new AutorisationRestreinte(new Date("01/01/2010"), new Date("01/01/2022"), "C", new Matricule("pjohn"), new Horaire("22:00"), new Horaire("23:00")));

//	Matricule mat = new Matricule("pmatt");
//	Empreinte emp = new Empreinte("ematt");
//	bdd.addEmpreinte(mat, emp);
//	
//	try {
//	  Thread.sleep(10000);
//	} catch (InterruptedException ex) {
//	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
//	}
//	
//	bdd.modifierEmpreinte(mat, new Empreinte("ejohn"));
//	
//	try {
//	  Thread.sleep(10000);
//	} catch (InterruptedException ex) {
//	  Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
//	}
//	
//	bdd.removeEmpreinte(mat);
//	PersonnePermanent p = new PersonnePermanent("mdp", true, "", new Matricule("pAzer"), "Azer", "Ty", "photoAzer");
//	bdd.addPersonnePermanente(p);
//	
//	PersonneTemporaire pp = new PersonneTemporaire(new Matricule("tqwer"), "Ty", "Qwer", "photoQwer");
//	bdd.addPersonneTemporaire(pp);
//	bdd.modifierMdp(new Matricule("pjohn"), "mdp");
  }

}
