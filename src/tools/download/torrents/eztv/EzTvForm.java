/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EzTvForm.java
 *
 * Created on 27 Μαρ 2010, 2:59:57 μμ
 */
package tools.download.torrents.eztv;

import database.EpisodesRecord;
import tools.MySeriesLogger;
import database.SeriesRecord;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import com.googlecode.svalidators.formcomponents.SComboBox;
import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import help.HelpWindow;
import myseries.series.Series;
import tools.Skin;
import tools.download.torrents.AbstractTorrentForm;
import tools.download.torrents.AbstractTorrent;
import tools.options.Options;

/**
 * The form to submit a torrent search to EzTv
 * @author lordovol
 */
public class EzTvForm extends AbstractTorrentForm {

    private static final long serialVersionUID = 235353163L;

    {
        createModels();
    }

    /**
     * Creates a default blank search form
     */
    public EzTvForm() {
        showUp();
    }

    /**
     * Creates a form for an episode search
     * @param series The series to search
     * @param episode The episode to search
     */
    public EzTvForm(SeriesRecord series, EpisodesRecord episode) {
        myseries.MySeries.glassPane.activate(null);
        this.series = series;
        this.episode = episode;
        showUp();

    }

    private void showUp() {
        MySeriesLogger.logger.log(Level.INFO, "Showing download from eztv form");
        myseries.MySeries.glassPane.activate(null);
        MySeriesLogger.logger.log(Level.INFO, "Initializong components");
        initComponents();
        MySeriesLogger.logger.log(Level.FINE, "Components initialized");
        combo_series.setSelectedItem(Series.getCurrentSerial().getTitle());
        combo_series.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                combo_seriesKeyReleased(e);
            }
        });
        setData();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void combo_seriesKeyReleased(KeyEvent e) {
        combo_series.validateValue();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    spinner_season = new javax.swing.JSpinner();
    spinner_episode = new javax.swing.JSpinner();
    combo_quality = new javax.swing.JComboBox();
    progress = new javax.swing.JProgressBar();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    checkbox_exact = new javax.swing.JCheckBox();
    combo_series = new SComboBox(new RequiredValidator(),false);
    jLabel1 = new javax.swing.JLabel();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_help = new myComponents.myGUI.buttons.MyButtonHelp();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Series title:");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setText("Season :");

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel4.setText("Episode :");

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel5.setText("Quality :");

    spinner_season.setModel(new javax.swing.SpinnerNumberModel(1, 0, 50, 1));

    spinner_episode.setModel(new javax.swing.SpinnerNumberModel(1, 0, 60, 1));

    combo_quality.setModel(qualityModel);
    combo_quality.setSelectedItem(Options.toString(Options.VIDEO_QUALITY));

    progress.setString("");
    progress.setStringPainted(true);

    jLabel6.setText("0 : Any season");

    jLabel7.setText("0: Any Episode");

    checkbox_exact.setText("Exact name");
    checkbox_exact.setOpaque(false);

    combo_series.setEditable(true);
    combo_series.setModel(seriesModel);
    combo_series.setName("Series title"); // NOI18N
    combo_series.setOpaque(false);
    combo_series.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_seriesActionPerformed(evt);
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
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
              .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(combo_series, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(combo_quality, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(spinner_episode, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel6))
                .addGap(50, 50, 50))
              .addComponent(checkbox_exact)))
          .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26))
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5});

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel7});

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel2)
          .addComponent(combo_series, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addComponent(checkbox_exact)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jLabel7)
          .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(combo_quality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Download torrent from " + EZTV_NAME);

    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_help.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_helpActionPerformed(evt);
      }
    });

    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(bt_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void combo_seriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_seriesActionPerformed
      combo_series.validateValue();
  }//GEN-LAST:event_combo_seriesActionPerformed

  private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      myseries.MySeries.glassPane.deactivate();
      MySeriesLogger.logger.log(Level.INFO, "Canceled by the user");
      dispose();
      myseries.MySeries.glassPane.deactivate();
  }//GEN-LAST:event_bt_cancelActionPerformed

  private void bt_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_helpActionPerformed
      MySeriesLogger.logger.log(Level.INFO, "Showing help form");
      new HelpWindow(HelpWindow.DOWNLOAD_TORRENT);
  }//GEN-LAST:event_bt_helpActionPerformed

  private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      ValidationGroup group = new ValidationGroup();
      group.addComponent(combo_series);
      MySeriesLogger.logger.log(Level.INFO, "Validating user input");
      if (group.validate()) {
          URI uri = createUri();
          Options.setOption(Options.VIDEO_QUALITY, (String)combo_quality.getSelectedItem());
          Options.save();
          if (uri != null) {
              MySeriesLogger.logger.log(Level.FINE, "Search uri :{0}", uri);
              EzTv e = new EzTv(uri, this);
              Thread t = new Thread(e);
              t.start();
          }
      } else {
          MySeriesLogger.logger.log(Level.WARNING, "Validation error\nMessage: {0}", group.getErrorMessage());
          MyMessages.warning("EzTv Search Form", group.getErrorMessage(), true);
      }
      //myseries.MySeries.glassPane.deactivate();
      //dispose();
  }//GEN-LAST:event_bt_okActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonHelp bt_help;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  private javax.swing.JCheckBox checkbox_exact;
  private javax.swing.JComboBox combo_quality;
  private com.googlecode.svalidators.formcomponents.SComboBox combo_series;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  public javax.swing.JProgressBar progress;
  private javax.swing.JSpinner spinner_episode;
  private javax.swing.JSpinner spinner_season;
  // End of variables declaration//GEN-END:variables

    private void setData() {
        if (series != null) {
            combo_series.setSelectedItem(series.getTitle());
            spinner_season.setValue(series.getSeason());
        }
        if (episode != null) {
            spinner_episode.setValue(episode.getEpisode());
        }
    }

    @Override
    protected URI createUri() {
        MySeriesLogger.logger.log(Level.INFO, "Creating the search uri");
        String address = EZTV_RSS;
        String query = "";
        ArrayList<String> q = new ArrayList<String>();
        try {
            q.add("show_name=" + URLEncoder.encode(String.valueOf(combo_series.getSelectedItem()), "UTF-8"));
            q.add("date=");
            q.add("show_name_exact=" + (checkbox_exact.isSelected() ? "true" : ""));
            q.add("quality=" + URLEncoder.encode(String.valueOf(combo_quality.getSelectedItem()), "UTF-8"));
            q.add("release_group=");
            q.add("episode_title=");
            q.add("season=" + spinner_season.getValue());
            q.add("episode=" + spinner_episode.getValue());
            q.add("video_format=");
            q.add("audio_format=");
            q.add("modifier=");
            q.add("mode=rss");

            query = MyUsefulFunctions.join(q, "&");
            return new URI(address + query);
        } catch (URISyntaxException ex) {
            MyMessages.error("Wrong url", "Wrong url " + address + query, true);
            MySeriesLogger.logger.log(Level.SEVERE, "Invalid uri", ex);
            return null;
        } catch (UnsupportedEncodingException ex) {
            MySeriesLogger.logger.log(Level.SEVERE, "Unsupported encoding", ex);
            return null;
        } catch (IOException ex) {
            MySeriesLogger.logger.log(Level.SEVERE, "I/O error", ex);
            return null;
        }
    }
}
