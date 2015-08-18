package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

/**
 *
 * @author Administrator
 */
public class XMLeditor extends javax.swing.JFrame {
   static JMenuItem addNode, addText, deleteNode;//右击时出现的弹出式菜单的菜单项
   static JPopupMenu clickMenu = new JPopupMenu();;//弹出式菜单 静态变量，直接用类名调用
   static DefaultTreeModel treeModel = null;
   DefaultMutableTreeNode rootNode;
    String filename;
    int flag = 0;
    XMLTree jTree1;
    public XMLeditor() {
        initComponents();
        jDialog1.setTitle("添加节点");
        jDialog1.setVisible(false);
        jDialog1.setBounds(800, 400, 400,200);
        setSize(700, 500);
        setLocation(150, 140);
        setVisible(true);
        addNode = new JMenuItem("添加节点");
        addText = new JMenuItem("添加文本");
        deleteNode = new JMenuItem("删除节点");
        addNode.addActionListener(new MItemListener());
        addText.addActionListener(new MItemListener());
        deleteNode.addActionListener(new MItemListener());
        clickMenu.add(addNode);
        clickMenu.add(deleteNode);
        clickMenu.add(addText);
        this.setTitle("XML编辑器");
//        jTree1.addMouseListener(new MyMouseListener());
       
    }
    public void insert(DefaultMutableTreeNode treeNode,NodeList nodeList){
         for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.TEXT_NODE){
                if(!node.getNodeValue().trim().equals("")){
                    System.out.println(node.getNodeValue());
                    DefaultMutableTreeNode textNode=new DefaultMutableTreeNode(node.getNodeValue());
                    treeNode.add(textNode);
                }
            }
            else if(node.getNodeType()==Node.ELEMENT_NODE){
                System.out.println(node.getNodeName());
                DefaultMutableTreeNode eNode=new DefaultMutableTreeNode(node.getNodeName());
                treeNode.add(eNode);
                
                insert(eNode,node.getChildNodes());
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jLabel1.setText("请输入要添加的内容：");

        jButton1.setText("添加");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("文件");

        jMenuItem2.setText("打开");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("保存");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem7.setText("另存为");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem4.setText("退出");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("操作");

        jMenuItem5.setText("添加");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("删除");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("数据库");

        jMenuItem8.setText("读取数据库");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String filename;
        String[] extensions = { "xml", "tld" };
        WindowUtilities.setNativeLookAndFeel();
        filename = ExtensionFileFilter.getFileName(".","XML Files",extensions);//从这里开始弹出文件选择框
        if (filename == null){
            filename = "test.xml";
        }
        else {
            try {
              if(jTree1!=null)
                  jTree1.removeAll();
              jTree1 = new XMLTree(filename);
              jTree1.setEditable(true);
              rootNode = XMLTree.getRootNode();
              treeModel=new  DefaultTreeModel(rootNode);
              jScrollPane1.setViewportView(jTree1);
              jTree1.updateUI();
              this.setTitle(filename);
              
        } catch (IOException ex) {
            Logger.getLogger(XMLeditor.class.getName()).log(Level.SEVERE, null, ex);
        }
         flag = 1;
         this.filename = filename;
        jTree1.addMouseListener(new MyMouseListener());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    Node  addChild(org.w3c.dom.Document document,Node parent,DefaultMutableTreeNode parentTreeNode){
      if(!parentTreeNode.isLeaf()&&!parentTreeNode.getFirstChild().toString().equals("NODE_CONTENT")){
        int num = parentTreeNode.getChildCount();
        for(int i=0;i<num;i++){
             DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentTreeNode.getChildAt(i);
             Node nodeNumber=document.createElement(node.toString());
             nodeNumber = addChild(document,nodeNumber,node);
             parent.appendChild(nodeNumber);
             System.out.print(parentTreeNode.getChildAt(i).toString()); 
        }
        System.out.println(); 
        
      }
      else if(!parentTreeNode.isLeaf()&&parentTreeNode.getFirstChild().toString().equals("NODE_CONTENT")){
        DefaultMutableTreeNode nodefirst = (DefaultMutableTreeNode)parentTreeNode.getFirstChild();
        String txt = nodefirst.getFirstChild().toString();
        parent.appendChild(document.createTextNode(txt));
       }
      else if(!parentTreeNode.isLeaf()&&parentTreeNode.getFirstChild().isLeaf()){
          
      }
      return parent;
    }
    javax.swing.JScrollPane getJScrollPane(){
        return jScrollPane1;
    }
        
    void writeToFile(String filename) {
        try {
             jTree1.updateUI();
             DocumentBuilderFactory factory=
             DocumentBuilderFactory.newInstance();
             DocumentBuilder domPaser= factory.newDocumentBuilder();
             org.w3c.dom.Document document;
             File file = new File(filename);
             document= domPaser.newDocument();
             document.setXmlVersion("1.0");
           //  Element root=document.createElement(rootNode.toString()); 
             Node root=document.createElement(rootNode.toString()); 
             root = addChild(document,root,rootNode);
             document.appendChild(root); 
            TransformerFactory transFactory=TransformerFactory.newInstance();
            Transformer transformer=transFactory.newTransformer();
            DOMSource  domSource=new DOMSource(document); //document为上面java所生成的
           FileOutputStream out=new FileOutputStream(file);
            StreamResult xmlResult=new StreamResult(out);
            transformer.transform(domSource, xmlResult);
            out.close();
            }catch (FileNotFoundException ex) {
           Logger.getLogger(XMLeditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLeditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           Logger.getLogger(XMLeditor.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(XMLeditor.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
    void save_XML(){
        File file;
        if(filename==null){
            JFileChooser cho = new JFileChooser();
            int state = cho.showSaveDialog(null);
            String[] extensions = { "xml", "tld" };
            cho.setFileFilter(new FileNameExtensionFilter("*.xml","xml"));
            file = cho.getSelectedFile();
            if(file!=null &&state==JFileChooser.APPROVE_OPTION){
               writeToFile(file.getAbsolutePath());
            }
        }
        else  if(filename!=null&&flag!=0){
             writeToFile(filename);
        }
         flag = 2;  
    }
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int n= JOptionPane.showConfirmDialog(this,"是否要保存文档？","确认对话框",JOptionPane.YES_NO_OPTION);
         if(n==JOptionPane.YES_OPTION){
              save_XML();
              System.exit(0);
         }
         else
             System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
   private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {                                    
        System.out.println(  ((DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent()).toString());        
    }      
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        save_XML();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JFileChooser cho = new JFileChooser();
        int state = cho.showSaveDialog(null);
        File file = cho.getSelectedFile();
        if(file!=null&&state==JFileChooser.APPROVE_OPTION){
            this.setTitle(file.getName());
            save_XML();
        }
        flag = 3;
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TreePath parentPath = jTree1.getSelectionPath();
         DefaultMutableTreeNode thenode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());
         if(parentPath!=null&&thenode!=rootNode&&!thenode.isLeaf())
         {
             DefaultMutableTreeNode addNodeode=new DefaultMutableTreeNode(jTextField1.getText().trim());
             addNodeode.setAllowsChildren(true);
             DefaultMutableTreeNode addNodeode1=new DefaultMutableTreeNode("NODE_CONTENT");
             addNodeode1.setAllowsChildren(true);
             DefaultMutableTreeNode addNodeode2=new DefaultMutableTreeNode("Name");
             addNodeode1.add(addNodeode2);
             addNodeode.add(addNodeode1);
             treeModel.insertNodeInto(addNodeode,thenode,thenode.getChildCount());
             jTree1.scrollPathToVisible(new TreePath(addNodeode.getPath()));
             jTree1.updateUI();
             jTextField1.setText("");
             jDialog1.setVisible(false);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new DataBase_Frame(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed
   public static void main(String args[]) { 
        DataBaseInteface da = new DataBaseInteface("aicheche");
        da.executeSQL("select * from t_s_user where officePhone = '7496661'");
        System.out.print(da.sqlResult);
        
       new XMLeditor();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
  
   class MItemListener implements ActionListener{ 
        MItemListener(){

        }
	public void actionPerformed(ActionEvent e){		
	  try{
            DefaultMutableTreeNode thenode;
            if(e.getSource()==XMLeditor.addNode){
                jDialog1.setVisible(true);	    			    	   		   
            }
            else if(e.getSource()==XMLeditor.deleteNode){
                    TreePath treepath= jTree1.getSelectionPath();
                    if(treepath!=null){
                        DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treepath.getLastPathComponent();
                        DefaultMutableTreeNode parent=(DefaultMutableTreeNode)selectionNode.getParent();
                        if(parent!=null&&selectionNode!=null&&selectionNode!=rootNode){					
                            parent.remove(selectionNode);
                            jTree1.updateUI();
                        }				
                    }					
            }
            else if(e.getSource()==XMLeditor.addText)
            {			
                String content=JOptionPane.showInputDialog("content:");
                TreePath treepath= jTree1.getSelectionPath();
                DefaultMutableTreeNode node=(DefaultMutableTreeNode)(treepath.getLastPathComponent());  
                String info=node.getUserObject().toString();
                if(node.isLeaf()||onlyAttributeChild(node))
                {            
                  DefaultMutableTreeNode father=new DefaultMutableTreeNode("NODE_CONTENT");
                  XMLeditor.treeModel.insertNodeInto(father,node,node.getChildCount());
                  DefaultMutableTreeNode child=new DefaultMutableTreeNode(content);
                  child.setAllowsChildren(false);
                  XMLeditor.treeModel.insertNodeInto(child,father,father.getChildCount());
                  jTree1.scrollPathToVisible(new TreePath(child.getPath()));              
                  }  
                }
	  }
	  catch(Exception ex){
              System.out.println(ex);
	  }	
	}
	 public boolean onlyAttributeChild(DefaultMutableTreeNode node){ 
	   if(node.getChildCount()==1)
	   {
	   	  DefaultMutableTreeNode n=(DefaultMutableTreeNode)XMLeditor.treeModel.
	        getChild(node,0);
	      if(n.getUserObject().toString().equals("NODE_ATTRIBUTE"))
	        return true;
	   }     
	   return false;
    }
    }
}
