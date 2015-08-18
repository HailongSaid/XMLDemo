package test;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

class MyMouseListener extends MouseAdapter
{
	public void mouseReleased(MouseEvent me)
	{
		if((me.getModifiers()&InputEvent.BUTTON3_MASK)!=0)
		  XMLeditor.clickMenu.show(me.getComponent(),me.getX(),me.getY());
	}
	
}