package cobra.bdd;

import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import cobra.PersonneTemporaire;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

  public Bdd(String type) {
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
		file = new File("src\\cobra\\bdd\\autorisations.xml");
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
	NodeList personnesNode = root.getChildNodes();
	Personne pers;

	int i = 0;
	while (i < personnesNode.getLength()) {
	  Node personneNode = personnesNode.item(i);

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
//	Bdd bdd = new Bdd("personne");
//
//	HashMap<Matricule, Personne> pers = bdd.loadPersonnes();
//	for (Matricule mat : pers.keySet()) {
//	  System.out.println(mat + "  " + pers.get(mat));
//	}
//
//	PersonnePermanent p = new PersonnePermanent("mdp", true, "", new Matricule("pAzer"), "Azer", "Ty", "photoAzer");
//	bdd.addPersonnePermanente(p);
//	
//	PersonneTemporaire pp = new PersonneTemporaire(new Matricule("tqwer"), "Ty", "Qwer", "photoQwer");
//	bdd.addPersonneTemporaire(pp);
  }

}
