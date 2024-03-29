package mypack;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class M_State extends javax.swing.JDialog {

    public M_State(String form) {
        initComponents();
        Connection con = null;
        // Statement stm;

        try {
            String url = "jdbc:mysql://localhost:3306/Applications";
            String user = "root";
            String password = "Nirjan@2503";
            con = DriverManager.getConnection(url, user, password);
            // stm = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String query = "select * from transactions where formno = \"" + form + "\";";
        try {
            assert con != null;
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new String[] { (rs.getString(2)).substring(0, 10), rs.getString(4), rs.getString(3),
                        rs.getString(5) });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        // Variables declaration - do not modify
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookmark Old Style", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mini Statement");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Date", "Type", "Amount", "Total"
                }) {
            final boolean[] canEdit = new boolean[] {
                    false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }

    // public static void main(String args[]) {
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(M_State.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(M_State.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(M_State.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(M_State.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // //</editor-fold>
    //
    // /* Create and display the dialog */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // M_State dialog = new M_State("5823");
    // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    // @Override
    // public void windowClosing(java.awt.event.WindowEvent e) {
    // System.exit(0);
    // }
    // });
    // dialog.setVisible(true);
    // }
    // });
    // }

    private javax.swing.JTable jTable1;
    // End of variables declaration
}
