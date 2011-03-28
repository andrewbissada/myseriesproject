/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myComponents.myGUI.buttons;

/**
 *
 * @author lordovol
 */
public class MyDefaultButton extends MyAbstractButton {

  private static final long serialVersionUID = 346457645764674L;

  public MyDefaultButton() {
    super();
  }

  public MyDefaultButton(String icon, String tooltip) {
    super(icon);
    setToolTipText(tooltip);
  }
}
