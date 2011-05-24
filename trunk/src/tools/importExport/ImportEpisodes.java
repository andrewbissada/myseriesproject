/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImportEpisodes.java
 *
 * Created on 21 Δεκ 2008, 12:15:05 μμ
 */
package tools.importExport;

import Exceptions.EpisodeImportFormatException;
import database.EpisodesRecord;
import tools.MySeriesLogger;
import database.SeriesRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myFileFilters.EpisodesExportFilter;
import myComponents.myGUI.MyDraggable;
import myseries.MySeries;
import myseries.series.Series;
import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.FileValidator;
import com.googlecode.svalidators.validators.NullValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import help.HelpWindow;
import tools.Skin;

/**
 * Imports previous exported episodes
 * @author lordovol
 */
public class ImportEpisodes extends MyDraggable {

    private static final long serialVersionUID = 45756856856876L;
    DefaultComboBoxModel comboboxModel_allSeries = new DefaultComboBoxModel();
    MySeries m;
    //private Dimension small;
    //private Dimension big;
    private File file;
    private ArrayList<SeriesRecord> series;
    ArrayList<EpisodesRecord> newEpisodes;
    private int series_ID = 0;
    boolean update = false;
    FileValidator fileValidator;

    /** Creates new form ImportEpisodes
     * @param m MySeries
     * @throws SQLException
     */
    public ImportEpisodes(MySeries m) throws SQLException {
        //small = new Dimension(485, 175);
        //big = new Dimension(485, 244);
        MySeriesLogger.logger.log(Level.INFO, "Importing episodes");
        this.m = m;
        createSeries();
        fileValidator = new FileValidator("", FileValidator.Type.FILE, false);
        MySeriesLogger.logger.log(Level.INFO, "Initializong components");
        initComponents();
        MySeriesLogger.logger.log(Level.FINE, "Components initialized");
        //panel_newSeries.setEnabled(false);
        textfield_newSeriesTitle.setEnabled(false);
        spinner_newSeriesSeason.setEnabled(false);
        //this.setSize(small);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Get all series
     * @throws java.sql.SQLException
     */
    private void createSeries() throws SQLException {
        MySeriesLogger.logger.log(Level.INFO, "Creating series data");
        series = Series.getSeries(false);
        for (int i = 0; i < series.size(); i++) {
            comboboxModel_allSeries.addElement(series.get(i).getFullTitle());
        }
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
    panel_newSeries = new javax.swing.JPanel();
    label_series = new javax.swing.JLabel();
    combobox_series = new javax.swing.JComboBox();
    checkBox_newSeries = new javax.swing.JCheckBox();
    label_title = new javax.swing.JLabel();
    textfield_newSeriesTitle = new com.googlecode.svalidators.formcomponents.STextField(new NullValidator());
    label_season = new javax.swing.JLabel();
    spinner_newSeriesSeason = new javax.swing.JSpinner();
    textfield_file = new com.googlecode.svalidators.formcomponents.STextField(fileValidator);
    button_browse = new javax.swing.JButton();
    label_progress = new javax.swing.JLabel();
    progress_import = new javax.swing.JProgressBar();
    jLabel1 = new javax.swing.JLabel();
    title = new javax.swing.JLabel();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_help = new myComponents.myGUI.buttons.MyButtonHelp();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    panel_newSeries.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    panel_newSeries.setMaximumSize(new java.awt.Dimension(334, 74));
    panel_newSeries.setPreferredSize(new java.awt.Dimension(334, 74));

    label_series.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_series.setText("Series :");

    combobox_series.setModel(comboboxModel_allSeries);
    combobox_series.setOpaque(false);

    checkBox_newSeries.setText("New Series :");
    checkBox_newSeries.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    checkBox_newSeries.setOpaque(false);
    checkBox_newSeries.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBox_newSeriesActionPerformed(evt);
      }
    });

    label_title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_title.setText("Title:");

    textfield_newSeriesTitle.setName("Series title"); // NOI18N

    label_season.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_season.setText("Season :");

    spinner_newSeriesSeason.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

    textfield_file.setEditable(false);
    textfield_file.setName("Import file"); // NOI18N

    button_browse.setText("Browse");
    button_browse.setOpaque(false);
    button_browse.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_browseActionPerformed(evt);
      }
    });

    label_progress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_progress.setText("Progress :");

    progress_import.setStringPainted(true);

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("File :");

    javax.swing.GroupLayout panel_newSeriesLayout = new javax.swing.GroupLayout(panel_newSeries);
    panel_newSeries.setLayout(panel_newSeriesLayout);
    panel_newSeriesLayout.setHorizontalGroup(
      panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newSeriesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panel_newSeriesLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(label_season)
              .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(textfield_newSeriesTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
              .addComponent(spinner_newSeriesSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(124, 124, 124))
          .addGroup(panel_newSeriesLayout.createSequentialGroup()
            .addComponent(label_series, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(combobox_series, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(checkBox_newSeries)
            .addContainerGap())
          .addGroup(panel_newSeriesLayout.createSequentialGroup()
            .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(label_progress)
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(textfield_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(progress_import, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button_browse)
            .addContainerGap(39, Short.MAX_VALUE))))
    );

    panel_newSeriesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combobox_series, progress_import, textfield_file, textfield_newSeriesTitle});

    panel_newSeriesLayout.setVerticalGroup(
      panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newSeriesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(combobox_series, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkBox_newSeries)
          .addComponent(label_series, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
          .addComponent(textfield_newSeriesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_season, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
          .addComponent(spinner_newSeriesSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
          .addComponent(textfield_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(button_browse))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panel_newSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_progress, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
          .addComponent(progress_import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | java.awt.Font.BOLD, title.getFont().getSize()+2));
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText("Import Episodes");

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

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(83, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(panel_newSeries, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
          .addContainerGap()))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(title)
          .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addGap(41, 41, 41)
          .addComponent(panel_newSeries, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
          .addGap(41, 41, 41)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void checkBox_newSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_newSeriesActionPerformed
        combobox_series.setEnabled(!combobox_series.isEnabled());
        //panel_newSeries.setEnabled(!panel_newSeries.isVisible());
        textfield_newSeriesTitle.setEnabled(!textfield_newSeriesTitle.isEnabled());
        spinner_newSeriesSeason.setEnabled(!spinner_newSeriesSeason.isEnabled());
        if (checkBox_newSeries.isSelected()) {
            textfield_newSeriesTitle.addValidator(new RequiredValidator());
            textfield_newSeriesTitle.validateValue();
        } else {
            textfield_newSeriesTitle.clearValidatorsList();
            textfield_newSeriesTitle.validateValue();
        }
        if (!panel_newSeries.isVisible()) {
            //this.setSize(small);
        } else {
            //this.setSize(big);
        }
}//GEN-LAST:event_checkBox_newSeriesActionPerformed

    private void button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseActionPerformed
        try {
            browse();
        } catch (IOException ex) {
            MySeriesLogger.logger.log(Level.SEVERE, "Could not open file", ex);
        }
}//GEN-LAST:event_button_browseActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        MySeriesLogger.logger.log(Level.INFO, "Canceled by the user");
        dispose();
        MySeries.glassPane.deactivate();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_helpActionPerformed
        MySeriesLogger.logger.log(Level.INFO, "Showing help window");
        new HelpWindow(HelpWindow.IMPORT_EPISODES);
    }//GEN-LAST:event_bt_helpActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
        ValidationGroup group = new ValidationGroup();
        group.addComponent(textfield_file);
        group.addComponent(textfield_newSeriesTitle);
        MySeriesLogger.logger.log(Level.INFO, "Validating user input");
        if (!group.validate()) {
            MySeriesLogger.logger.log(Level.WARNING, "Validation failed/nError: {0}", group.getErrorMessage());
            MyMessages.warning("Import Episodes Form", group.getErrorMessage(), true);
            return;
        }
        try {
            importEpisodes();
        } catch (FileNotFoundException ex) {
            MyMessages.error("Error!!!", "Could not find episodes file", true);
            MySeriesLogger.logger.log(Level.SEVERE, "Could not find episodes file", ex);
        } catch (EpisodeImportFormatException ex) {
            MyMessages.error("Error!!!", ex.getMessage(), true);
            MySeriesLogger.logger.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (SQLException ex) {
            MyMessages.error("Error!!!", "Could not insert episodes in Database", true);
            MySeriesLogger.logger.log(Level.SEVERE, "Could not insert episodes in Database", ex);
        } catch (IOException ex) {
            MyMessages.error("Error!!!", "Could not read from file", true);
            MySeriesLogger.logger.log(Level.SEVERE, "Could not read from file", ex);
        }

    }//GEN-LAST:event_bt_okActionPerformed

    private void importEpisodes() throws FileNotFoundException, SQLException, IOException, EpisodeImportFormatException {
        String newSeriesTitle;
        if (combobox_series.isEnabled()) {
            series_ID = series.get(combobox_series.getSelectedIndex()).getSeries_ID();
            MySeriesLogger.logger.log(Level.INFO, "Updating existing series episodes");
            update = true;
        } else {
            //Create new series
            if (!textfield_newSeriesTitle.getText().trim().equals("")) {

                newSeriesTitle = textfield_newSeriesTitle.getText().trim();
                SeriesRecord ser = new SeriesRecord();
                ser.setTitle(newSeriesTitle);
                ser.setSeason(Integer.parseInt(String.valueOf(spinner_newSeriesSeason.getValue())));
                MySeriesLogger.logger.log(Level.INFO, "Creating new series {0} episodes", ser.getFullTitle());
                series_ID = ser.save();
            }
        }
        if (series_ID > 0) {
            if (file != null) {
                newEpisodes = readFile();
                insertEpisodesInDB i = new insertEpisodesInDB(this,m);
                Thread t = new Thread(i);
                t.start();
            } else {
                MySeriesLogger.logger.log(Level.SEVERE, "No file selected");
                MyMessages.error("No file!!!", "No File selected!!!", true);
            }
        } else {
            throw new EpisodeImportFormatException("No Series ID for importing the episodes.");
        }
    }

    /**
     * Reads the file with the episodes
     * @return An Arraylist of the episodes records
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     * @throws Exceptions.EpisodeImportFormatException
     */
    private ArrayList<EpisodesRecord> readFile() throws FileNotFoundException, IOException, EpisodeImportFormatException {
        ArrayList<EpisodesRecord> eps = new ArrayList<EpisodesRecord>();
        BufferedReader in = MyUsefulFunctions.createInputStream(file);
        String line;
        String[] fields;
        int numOfLine = 0;
        MySeriesLogger.logger.log(Level.INFO, "Reading episodes file");
        while ((line = in.readLine()) != null) {
            numOfLine++;
            fields = line.split("\t", -1);
            if (fields.length != 3) {
                throw new EpisodeImportFormatException("Episode in line " + numOfLine + " is not in the right format");
            }
            EpisodesRecord e = new EpisodesRecord();
            try {
                e.setEpisode(Integer.parseInt(fields[0].trim()));
            } catch (NumberFormatException ex) {
                throw new EpisodeImportFormatException("Episode number in line " + numOfLine + " is not an integer");
            }
            e.setTitle(fields[1].trim());
            if (!MyUsefulFunctions.isValidDate(fields[2]) && !fields[2].trim().equals("")) {
                throw new EpisodeImportFormatException("Date in line " + numOfLine + " is not in the right format");
            }
            e.setAired(fields[2].trim());
            e.setSeries_ID(series_ID);
            eps.add(e);
        }
        in.close();
        return eps;
    }

    /**
     * Opens the browser to look for the file to import
     * @throws java.io.IOException
     */
    private void browse() throws IOException {
        MySeriesLogger.logger.log(Level.INFO, "Browsing for episodes file");
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.setMultiSelectionEnabled(false);
        f.setApproveButtonText("Import");
        f.setDialogTitle("Import episodes");
        f.setFileFilter(new EpisodesExportFilter());

        int returnVal = f.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            MySeriesLogger.logger.log(Level.INFO, "Importing aborted");
        } else {
            file = f.getSelectedFile();
            textfield_file.setText(file.getCanonicalPath());
            textfield_file.validateValue();
            MySeriesLogger.logger.log(Level.INFO, "Importing episodes in file {0}", file.getName());
        }
    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonHelp bt_help;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  private javax.swing.JButton button_browse;
  private javax.swing.JCheckBox checkBox_newSeries;
  private javax.swing.JComboBox combobox_series;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_progress;
  private javax.swing.JLabel label_season;
  private javax.swing.JLabel label_series;
  private javax.swing.JLabel label_title;
  private javax.swing.JPanel panel_newSeries;
  public javax.swing.JProgressBar progress_import;
  private javax.swing.JSpinner spinner_newSeriesSeason;
  private com.googlecode.svalidators.formcomponents.STextField textfield_file;
  private com.googlecode.svalidators.formcomponents.STextField textfield_newSeriesTitle;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
