/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DownloadSubtitlesForm.java
 *
 * Created on 26 Μαρ 2010, 9:44:53 μμ
 */
package tools.download.subtitles;

import java.util.logging.Level;
import myComponents.myGUI.MyDraggable;
import tools.MySeriesLogger;
import tools.Skin;

/**
 *
 * @author lordovol
 */
public abstract class AbstractDownloadForm extends MyDraggable {

    private static final long serialVersionUID = 25436476L;

    public void init() {
        MySeriesLogger.logger.log(Level.INFO, "Downloading subtitles form");
        MySeriesLogger.logger.log(Level.INFO, "Initializong components");
        initComponents();
        MySeriesLogger.logger.log(Level.FINE, "Components initialized");
        myseriesproject.MySeries.glassPane.activate(null);
    }

    public AbstractDownloadForm() {
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    innerPanel = new javax.swing.JPanel();
    progress = new javax.swing.JProgressBar();
    label_message = new javax.swing.JLabel();
    label_subtitle = new javax.swing.JLabel();
    label_title = new javax.swing.JLabel();
    myButtonCancel1 = new myComponents.myGUI.buttons.MyButtonCancel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
    });

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    innerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    progress.setStringPainted(true);

    label_subtitle.setFont(label_subtitle.getFont().deriveFont(label_subtitle.getFont().getSize()+2f));

    javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
    innerPanel.setLayout(innerPanelLayout);
    innerPanelLayout.setHorizontalGroup(
      innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(innerPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_subtitle, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
          .addComponent(label_message, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
          .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        .addContainerGap())
    );
    innerPanelLayout.setVerticalGroup(
      innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, innerPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(label_subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_message, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("Downloading Subtitles");

    myButtonCancel1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        myButtonCancel1ActionPerformed(evt);
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
            .addComponent(innerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
          .addComponent(myButtonCancel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGap(34, 34, 34))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(myButtonCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_title))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(innerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      myseriesproject.MySeries.glassPane.deactivate();
  }//GEN-LAST:event_formWindowClosed

  private void myButtonCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButtonCancel1ActionPerformed
      dispose();
  }//GEN-LAST:event_myButtonCancel1ActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel innerPanel;
  private javax.swing.JPanel jPanel1;
  public javax.swing.JLabel label_message;
  public javax.swing.JLabel label_subtitle;
  protected javax.swing.JLabel label_title;
  private myComponents.myGUI.buttons.MyButtonCancel myButtonCancel1;
  public javax.swing.JProgressBar progress;
  // End of variables declaration//GEN-END:variables
}
