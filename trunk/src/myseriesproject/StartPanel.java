/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * startPanel.java
 *
 * Created on 8 Δεκ 2008, 5:51:21 μμ
 */
package myseriesproject;

import com.googlecode.soptions.Option;
import com.googlecode.svalidators.validators.RequiredValidator;
import database.CreateDatabase;
import database.DBConnection;
import database.Database;
import help.HelpWindow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lap.LafAndPlay;
import lap.LafAndPlayException;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myGUI.MyDraggable;
import myComponents.myGUI.MyFont;
import tools.DesktopSupport;
import tools.MySeriesLogger;
import tools.Skin;
import tools.options.MySeriesOptions;
import tools.options.OldOptions;
import tools.options.Paths;

/**
 * The start up panel
 * @author lordovol
 */
public class StartPanel extends MyDraggable {

  private final static long serialVersionUID = 45346793847632L;
  public MySeries m = null;
  DefaultComboBoxModel databasesModel = new DefaultComboBoxModel();
  public String dbName;
  private boolean createNewDB;

  /** Creates new form startPanel */
  public StartPanel() {
    MySeriesLogger.logger.log(Level.INFO, "Initializing components");
    initComponents();
    MySeriesLogger.logger.log(Level.FINE, "Components initialized");
    //panel_loadDatabase.setVisible(false);
    //panel_newDB.setVisible(false);
    textbox_name.addValidator(new RequiredValidator());
    getRootPane().setDefaultButton(bt_ok);
    setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/subtitles.png")).getImage());
    databasesModel = new DefaultComboBoxModel(Database.getDatabases());
    combobox_databases.setModel(databasesModel);
    //progress.setVisible(false);
    setLocationRelativeTo(null);
    pack();
    setVisible(true);
  }

  /**
   * The start panel to create a database
   * @param m The myseries form
   * @param createNewDB Create a database or not
   */
  public StartPanel(MySeries m, boolean createNewDB) {
    this.m = m;
    this.createNewDB = createNewDB;
    MySeriesLogger.logger.log(Level.INFO, "Initializing components");
    initComponents();
    MySeriesLogger.logger.log(Level.FINE, "Components initialized");
    textbox_name.addValidator(new RequiredValidator());
    getRootPane().setDefaultButton(bt_ok);
    //progress.setVisible(false);
    label_title.setText("Create database");
    setLocationRelativeTo(null);
    panel_loadDatabase.setVisible(false);
    //  setSize(smaller);
    pack();
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    label_title = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    panel_newDB = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    textbox_name = new com.googlecode.svalidators.formcomponents.STextField();
    panel_loadDatabase = new javax.swing.JPanel();
    combobox_databases = new javax.swing.JComboBox();
    jLabel2 = new javax.swing.JLabel();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();
    bt_help = new myComponents.myGUI.buttons.MyButtonHelp();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("No Database!!!");

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    panel_newDB.setOpaque(false);

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Create new database:");

    javax.swing.GroupLayout panel_newDBLayout = new javax.swing.GroupLayout(panel_newDB);
    panel_newDB.setLayout(panel_newDBLayout);
    panel_newDBLayout.setHorizontalGroup(
      panel_newDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newDBLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(26, 26, 26)
        .addComponent(textbox_name, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        .addContainerGap())
    );
    panel_newDBLayout.setVerticalGroup(
      panel_newDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_newDBLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(panel_newDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(textbox_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(25, 25, 25))
    );

    panel_loadDatabase.setOpaque(false);

    combobox_databases.setModel(databasesModel);
    combobox_databases.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combobox_databasesActionPerformed(evt);
      }
    });

    jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Load Database :");

    javax.swing.GroupLayout panel_loadDatabaseLayout = new javax.swing.GroupLayout(panel_loadDatabase);
    panel_loadDatabase.setLayout(panel_loadDatabaseLayout);
    panel_loadDatabaseLayout.setHorizontalGroup(
      panel_loadDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_loadDatabaseLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28)
        .addComponent(combobox_databases, 0, 159, Short.MAX_VALUE)
        .addGap(15, 15, 15))
    );
    panel_loadDatabaseLayout.setVerticalGroup(
      panel_loadDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel_loadDatabaseLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panel_loadDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(combobox_databases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(panel_loadDatabase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(panel_newDB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(38, 38, 38))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(panel_loadDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel_newDB, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        .addContainerGap())
    );

    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    bt_help.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_helpActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap(73, Short.MAX_VALUE)
        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(panelLayout.createSequentialGroup()
        .addGap(8, 8, 8)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_title)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Creates a new database (and populate it with demo data)
   * @param evt
   */
    private void combobox_databasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_databasesActionPerformed
      if (combobox_databases.getSelectedIndex() > 0) {
        MySeriesLogger.logger.log(Level.INFO, "Existing database selection");
        panel_newDB.setVisible(false);
      } else {
        MySeriesLogger.logger.log(Level.INFO, "New database selection");
        panel_newDB.setVisible(true);
      }
      validate();
      pack();
    }//GEN-LAST:event_combobox_databasesActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      if (m == null) {
        MySeriesLogger.logger.log(Level.INFO, "Exiting application");
        System.exit(0);
      } else {
        MySeriesLogger.logger.log(Level.INFO, "Closing window");
        MySeries.glassPane.deactivate();
        dispose();
      }
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_helpActionPerformed
      MySeriesLogger.logger.log(Level.INFO, "Opening help window");
      new HelpWindow(HelpWindow.START_APPLICATION);
    }//GEN-LAST:event_bt_helpActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      bt_ok.requestFocus();
      dbName = "";
      Boolean loadDemoData = false;
      //Load database
      if (combobox_databases.getSelectedIndex() > 0) {
        dbName = (String) combobox_databases.getSelectedItem();
        loadDemoData = false;
      } else {
        // Create database
        dbName = textbox_name.getText().trim();
        loadDemoData = false;
        createNewDB = true;
      }

      if (new RequiredValidator(dbName).validate()) {
        try {
          if (!dbName.endsWith(".db")) {
            dbName += ".db";
          }
          if (createNewDB) {
            MySeriesLogger.logger.log(Level.INFO, "Create new DB");
            CreateDatabase d = new CreateDatabase(this, dbName);
            Thread t = new Thread(d);
            t.start();
            dispose();
          } else {
            //Connect
            DBConnection conn = new DBConnection(dbName, false);
            // Check if connection is established
            if (DBConnection.isConnected) {
              MySeriesLogger.logger.log(Level.INFO, "Check database format");
              if (DBConnection.checkDatabase()) {
                if (DBConnection.isConnected) {
                  MySeriesLogger.logger.log(Level.INFO, "MySerieS restarting");
                  dispose();
                  MySeries m = new MySeries();
                } else {
                  dispose();
                  MyMessages.error("Invalid Database", "Could not connect to the selected database.\nPlease select another one or create a new one.", true);
                  StartPanel s = new StartPanel();
                }
              } else {
                dispose();
                MyMessages.error("Invalid Database", "The selected database seems to be invalid.\nPlease select another one or create a new one.", true);
                StartPanel s = new StartPanel();
              }
            }
          }

        } catch (ClassNotFoundException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, "Database library not found", ex);
        } catch (SQLException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, "An sql exception occured", ex);
        } catch (IOException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, "Could not read/write to database", ex);
        } catch (InstantiationException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, null, ex);
          MyMessages.error("My Series", "Could not create Application", true);
        } catch (IllegalAccessException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, null, ex);
          MyMessages.error("My Series", "Illegal access", true);
        } catch (UnsupportedLookAndFeelException ex) {
          MySeriesLogger.logger.log(Level.SEVERE, null, ex);
          MyMessages.error("My Series", "Look and feel is not supported", true);
        } catch (Exception ex) {
          MyMessages.error("My Series", ex.getMessage(), true);
          MySeriesLogger.logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
      } else {
        MySeriesLogger.logger.log(Level.WARNING, "The database name should not be empty");
        MyMessages.validationError("Empty name", "The database name should not be empty");
      }
    }//GEN-LAST:event_bt_okActionPerformed

  /**
   * Starts MySeries Application after getting the database to use and save the options file
   * @throws java.io.IOException
   * @throws java.lang.ClassNotFoundException
   * @throws java.sql.SQLException
   * @throws java.lang.InstantiationException
   * @throws java.lang.IllegalAccessException
   * @throws javax.swing.UnsupportedLookAndFeelException
   */
  public void startMySeries() throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    MySeries.options.setOption(new Option(MySeriesOptions.DB_NAME,Option.STRING_CLASS, dbName));
    
    MySeries mySeries = new MySeries();
    MySeriesLogger.logger.log(Level.INFO, "Closing window");
    dispose();
  }

  /**
   * Start the application
   * Gets options, and starts logging
   * Create Dirs and if datatbase exists start MySeries else prompts for creating a new DB
   * @param args
   */
  public static void main(String[] args) {
    String[] lafs;
    boolean updateopts = false;
    try {
       //create dirs
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.LOGS_PATH);
      moveOldLogs();
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.DATABASES_PATH);
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.SCREENSHOTS_PATH);
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.TORRENTS_PATH);
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.FEEDS_PATH);
      MyUsefulFunctions.checkDir(MySeriesOptions._USER_DIR_ + Paths.LAFS_PATH);
      //Create the logger
      MySeries.createLogger();
      File oldOptions = new File(OldOptions._USER_DIR_ + "MySeries.ini");
      File newOptions = new File(OldOptions._USER_DIR_ + "MySeries.xml");
      if (oldOptions.isFile() && !newOptions.isFile()) {
        MyMessages.message("Importing Options", "Importing options from ini to xml file.\n"
                + "If the application won't start or freeze, delete MySeries.ini file and try again", MyMessages.INFO_MESS ,false);
        MySeriesLogger.logger.log(Level.INFO, "Reading old options file");
        OldOptions.getOptions();
        updateopts = true;
        MySeriesLogger.logger.log(Level.INFO, "Deleting old options file");
        if (oldOptions.delete()) {
          MySeriesLogger.logger.log(Level.INFO, "Deleted old options file");
        } else {
          MySeriesLogger.logger.log(Level.WARNING, "Could not delete old options file.try to delete it on exit");
          oldOptions.deleteOnExit();
        }
      }

     
      // Get new options
      MySeries.options = new MySeriesOptions();
      if (updateopts) {
        MySeriesLogger.logger.log(Level.INFO, "Updating options file");
        MySeries.options.updateOptions();
        MyMessages.message("Importing Options", "Importing options from ini to xml was finished sucessfully.", MyMessages.INFO_MESS ,false);
      }
      MySeries.options.readOptions();
      MySeriesLogger.logger.log(Level.FINE, "Logger created");
      MySeriesLogger.logger.log(Level.INFO, "Setting font and font sizes");
      MyFont.SetMyFont();
      MySeriesLogger.logger.log(Level.FINE, "Font and font sizes are set to {0} {1}pts", new Object[]{MySeries.options.getStringOption(MySeriesOptions.FONT_FACE), MySeries.options.getFloatOption(MySeriesOptions.FONT_SIZE)});
      LafAndPlay lap = new LafAndPlay(Paths.LAFS_PATH);
      lap.addDefaultLookAndFeels();
      lap.addExternalLookAndFeels();
      if (MySeries.options.getBooleanOption(MySeriesOptions.USE_SKIN)) {
        MySeriesLogger.logger.log(Level.INFO, "Create Skin");
        Skin skin = new Skin(MySeries.options.getColorOption(MySeriesOptions.SKIN_COLOR));
        MySeriesLogger.logger.log(Level.FINE, "Skin created");
        MySeriesLogger.logger.log(Level.INFO, "Apply skin");
        Skin.applySkin();
        MySeriesLogger.logger.log(Level.FINE, "Skin applied");
      } else {
        MySeriesLogger.logger.log(Level.INFO, "No Skin is used");
        MySeriesLogger.logger.log(Level.INFO, "Loading look and feel");
        String laf = "";
        if (MySeries.options.getBooleanOption(MySeriesOptions.RANDOMIZE_LAF)) {
          laf = lap.getRandomLaf();
        } else {
          laf = MySeries.options.getStringOption(MySeriesOptions.LOOK_AND_FEEL);
        }
        try {
          lap.setLookAndFeel(laf);
          MySeries.options.setOption(new Option(MySeriesOptions.LOOK_AND_FEEL,Option.STRING_CLASS, laf),true);
        } catch (Exception ex) {
          MySeriesLogger.logger.log(Level.SEVERE, ex.getMessage());
          try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          } catch (ClassNotFoundException ex1) {
            MySeriesLogger.logger.log(Level.SEVERE, "Could not load default system laf class", ex);
          } catch (InstantiationException ex1) {
            MySeriesLogger.logger.log(Level.SEVERE, "Could not instantiate default system laf", ex);
          } catch (IllegalAccessException ex1) {
            MySeriesLogger.logger.log(Level.SEVERE, "Illegal access with default system laf", ex);
          } catch (UnsupportedLookAndFeelException ex1) {
            MySeriesLogger.logger.log(Level.SEVERE, "Default system laf is not supported", ex);
          }
          MySeriesLogger.logger.log(Level.FINE, "Default look and feel loaded");
        }
        Skin skin = new Skin(UIManager.getColor("Panel.background"));
        MySeriesLogger.logger.log(Level.FINE, "{0} look and feel loaded", laf);

      }

      //Check Desktop supported
      MySeriesLogger.logger.log(Level.INFO, "Checking desktop support");
      DesktopSupport ds = new DesktopSupport();
      MySeriesLogger.logger.log(Level.FINE, "Desktop is supported by the OS");
      MySeriesLogger.logger.log(Level.INFO, "Setting tooltip delay");
      ToolTipManager.sharedInstance().setDismissDelay(50000);



      // Create the default db if not exists and create the conn, stmt
      MySeriesLogger.logger.log(Level.INFO, "Checking if database exists or not");
      if (!DBConnection.databaseExists(MySeries.options.getStringOption(MySeriesOptions.DB_NAME))) {
        // Select or create db
        StartPanel s = new StartPanel();
      } else {
        //Connect
        DBConnection conn = new DBConnection(MySeries.options.getStringOption(MySeriesOptions.DB_NAME), false);
        // Check if connection is established
        if (DBConnection.isConnected) {
          MySeriesLogger.logger.log(Level.INFO, "Check database format");
          if (DBConnection.checkDatabase()) {
            if (DBConnection.isConnected) {
              MySeriesLogger.logger.log(Level.INFO, "MySerieS loading...");
              MySeries m = new MySeries();
            } else {
              MyMessages.error("Invalid Database", "Could not connect to the selected database.\nPlease select another one or create a new one.", true);
              StartPanel s = new StartPanel();
            }
          } else {
            MyMessages.error("Invalid Database", "The selected database seems to be invalid.\nPlease select another one or create a new one.", true);
            StartPanel s = new StartPanel();
          }
        }
      }
    } catch (SQLException ex) {
      MyMessages.error("MySerieS", "Sql error occured while connecting to database", true);
      MySeriesLogger.logger.log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      MyMessages.error("MySeries", "Could not read options file", true);
      MySeriesLogger.logger.log(Level.SEVERE, "Could not read options file", ex);
    } catch (ClassNotFoundException ex) {
      MyMessages.error("MySeries", "MySerieS class not found", true);
      MySeriesLogger.logger.log(Level.SEVERE, "MySerieS class not found", ex);
    } catch (IllegalAccessException ex) {
      MyMessages.error("MySeries", "MySerieS illegal access exception", true);
      MySeriesLogger.logger.log(Level.SEVERE, "MySerieS illegal access exception", ex);
    } catch (InstantiationException ex) {
      MyMessages.error("MySeries", "Could not instantiate MySerieS", true);
      MySeriesLogger.logger.log(Level.SEVERE, "Could not instantiate MySerieS", ex);
    } catch (UnsupportedLookAndFeelException ex) {
      MyMessages.error("MySeries", "Unsupported Look and feel", true);
      MySeriesLogger.logger.log(Level.SEVERE, "Unsupported Look and feel", ex);
    } catch (LafAndPlayException ex) {
      MyMessages.error("MySeries", "Laf Exception", true);
      MySeriesLogger.logger.log(Level.SEVERE, ex.getMessage(), ex);
    } catch (Exception ex) {
      MySeriesLogger.logger.log(Level.SEVERE, "Exception", ex);
      ex.printStackTrace();
      System.exit(1);
    }
  }

  private static void moveOldLogs() {
    File[] d = new File(MySeriesOptions._USER_DIR_).listFiles(new FilenameFilter() {

      @Override
      public boolean accept(File dir, String name) {
        return name.startsWith("MySeriesLogs_");
      }
    });
    for (int i = 0; i < d.length; i++) {
      File file = d[i];
      String source = file.getAbsolutePath();
      String dest = MySeriesOptions._USER_DIR_ + Paths.LOGS_PATH + file.getName().replaceFirst("MySeriesLogs_", "MySeriesLog_");
      try {
        MyUsefulFunctions.copyfile(source, dest);
        file.delete();
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }
    }
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonHelp bt_help;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  private javax.swing.JComboBox combobox_databases;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_title;
  private javax.swing.JPanel panel;
  private javax.swing.JPanel panel_loadDatabase;
  private javax.swing.JPanel panel_newDB;
  public com.googlecode.svalidators.formcomponents.STextField textbox_name;
  // End of variables declaration//GEN-END:variables
}