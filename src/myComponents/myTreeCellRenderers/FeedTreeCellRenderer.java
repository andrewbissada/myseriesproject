/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myComponents.myTreeCellRenderers;

import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import myComponents.myGUI.MyFont;

/**
 *
 * @author ΔΙΟΝΥΣΗΣ
 */
public class FeedTreeCellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {

  private static final long serialVersionUID = 534646765786987L;

  public FeedTreeCellRenderer() {
   // setOpaque(true);
    setLeafIcon(new ImageIcon(getClass().getResource("/images/rss.png")));
    setClosedIcon(new ImageIcon(getClass().getResource("/images/rss_closed.png")));
    setOpenIcon(new ImageIcon(getClass().getResource("/images/rss_opened.png")));

  }

  @Override
  public Font getFont() {
    Font font = new Font(MyFont.mySmallerFont.getFontName(), Font.PLAIN, MyFont.mySmallerFont.getSize());
    return font;
  }

  @Override
  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
    return this;
  }
}
