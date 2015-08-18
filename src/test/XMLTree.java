package test;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;   


 class XMLTree extends JTree 
{
  public static DefaultMutableTreeNode rootTreeNode=null;
  public static DefaultMutableTreeNode docTypeNode=null;
  public static DocumentType docType=null;
  public XMLTree(String filename) throws IOException 
  {
    this(filename, new FileInputStream(new File(filename)));
  }

  public XMLTree(String filename, InputStream in) 
  {
    super(makeRootNode(in));
  }
  static DefaultMutableTreeNode getRootNode(){
      return rootTreeNode;
  }
  private static DefaultMutableTreeNode makeRootNode(InputStream in) 
  {
    try 
    {
 
      System.setProperty("javax.xml.parsers.DocumentBuilderFactory","com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");

      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = builderFactory.newDocumentBuilder();
      Document document=builder.parse(in);  
      document.getDocumentElement().normalize();
      docType=document.getDoctype();
      if(docType!=null){
      docTypeNode=new DefaultMutableTreeNode("DOCTYPE");
      DefaultMutableTreeNode docTypeContentNode=new DefaultMutableTreeNode(docType.getName());
      docTypeNode.add(docTypeContentNode);
      }
      Element rootElement = document.getDocumentElement();
      rootTreeNode =buildTree(rootElement);
      return(rootTreeNode);
    } 
    catch(Exception e) 
    {
      String errorMessage =
        "Error making root node: " + e;
      System.err.println(errorMessage);
      e.printStackTrace();
      return(new DefaultMutableTreeNode(errorMessage));
    }
  }

  private static DefaultMutableTreeNode buildTree(Element rootElement) 
  {
    
    DefaultMutableTreeNode rootTreeNode =
      new DefaultMutableTreeNode(treeNodeLabel(rootElement));
    addChildren(rootTreeNode, rootElement);
    return(rootTreeNode);
  }

  private static void addChildren(DefaultMutableTreeNode parentTreeNode,Node parentXMLElement) 
  {
  
    String content=null;
    NodeList childElements =
      parentXMLElement.getChildNodes();
    NamedNodeMap elementAttributes =
      parentXMLElement.getAttributes();
    int numAttributes = elementAttributes.getLength();
    DefaultMutableTreeNode childTreeAttribute =
          new DefaultMutableTreeNode
            ("NODE_ATTRIBUTE"); 
    for(int i=0; i<numAttributes; i++) {
        Node attribute = elementAttributes.item(i); 
        DefaultMutableTreeNode treeAttribute =
          new DefaultMutableTreeNode
            (attribute.getNodeName()+"="+attribute.getNodeValue());
        childTreeAttribute.add(treeAttribute);
    }                
    if(childTreeAttribute.isLeaf()==false)
      parentTreeNode.add(childTreeAttribute);  
    NodeList nodes=parentXMLElement.getChildNodes();
    if(childElements.getLength()>0)
      content= nodes.item(0).getNodeValue(); //未完成
    
    if(content!=null&&content.trim().equals("")==false){
    
      DefaultMutableTreeNode treeContent =
          new DefaultMutableTreeNode
            ("NODE_CONTENT");
      DefaultMutableTreeNode contentNode =
          new DefaultMutableTreeNode
            (content);      
      treeContent.add(contentNode);
      parentTreeNode.add(treeContent);  
    }   
             
    else{
             
    for(int i=0; i<childElements.getLength(); i++) {
      Node childElement = childElements.item(i);
      if (!(childElement instanceof Text ||
            childElement instanceof Comment)) {
        DefaultMutableTreeNode childTreeNode =
          new DefaultMutableTreeNode
            (treeNodeLabel(childElement));
        parentTreeNode.add(childTreeNode);
        addChildren(childTreeNode, childElement);
      }
      else if(childElement instanceof Comment){
      	String comment=childElement.getNodeValue();
      	DefaultMutableTreeNode treeComment =
          new DefaultMutableTreeNode
            ("COMMENT");
      DefaultMutableTreeNode commentNode =
          new DefaultMutableTreeNode
            (comment);      
      treeComment.add(commentNode);
      parentTreeNode.add(treeComment);  
      }
    }
   } 
  }

  private static String treeNodeLabel(Node childElement) {
    NamedNodeMap elementAttributes =
      childElement.getAttributes();
    String treeNodeLabel = childElement.getNodeName();
    if (elementAttributes != null &&
        elementAttributes.getLength() > 0) {
      treeNodeLabel = treeNodeLabel + "";
      int numAttributes = elementAttributes.getLength();
      for(int i=0; i<numAttributes; i++) {
        Node attribute = elementAttributes.item(i);
        if (i > 0) {
          treeNodeLabel = treeNodeLabel + "";
        }
        treeNodeLabel =treeNodeLabel ;
      }
      treeNodeLabel = treeNodeLabel + "";
    }
    return(treeNodeLabel);
  }
}