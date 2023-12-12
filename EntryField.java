import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EntryField extends javax.swing.JFrame {


    public EntryField() {
        initComponents();
    }

                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        
        try {
            jdbc mysql =new jdbc();
            ResultSet rs = mysql.vehicledetails();
            while(rs.next())
            {
                Owner.add(rs.getString(2));
                VehicleNumber.add(rs.getString(3));
                VehicleModel.add(rs.getString(4));
                noOwner.add(rs.getInt(5));
                PreviousOwner.add(rs.getString(6));
                Fuel.add(rs.getString(7));
                Type.add(rs.getString(8));
                Insurance.add(rs.getString(9));
                OwnerMobileNumber.add(rs.getString(10));
                OwnerAddress.add(rs.getString(11));   
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        jButton1.addActionListener(e->{
            String x=jTextField1.getText().trim();
            if(VehicleNumber.contains(x))
            {
                dispose();
                int i=VehicleNumber.indexOf(x);
                String data[]={
                    Owner.get(i),
                    VehicleNumber.get(i),
                    VehicleModel.get(i),
                    ""+noOwner.get(i)
                    ,PreviousOwner.get(i),
                    Owner.get(i),
                    Fuel.get(i),
                    Type.get(i),
                    Insurance.get(i),
                    OwnerMobileNumber.get(i),
                    OwnerAddress.get(i)};
                viewdetails vd =new viewdetails(data);
                vd.main(data);
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "NO Vehicle Found ! ", "Invalid Data",JOptionPane.ERROR_MESSAGE);
            }
        }
            
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Vehicle ");

        jPanel1.setBackground(new java.awt.Color(156, 189, 211));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Vehicle Number      :");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Submit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntryField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntryField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntryField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntryField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntryField().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration     
    ArrayList<String>Owner  =new ArrayList<>(); 
    ArrayList<String>VehicleNumber  =new ArrayList<>();
    ArrayList<String>VehicleModel  =new ArrayList<>();
    ArrayList<Integer>noOwner =new ArrayList<>();
    ArrayList<String>PreviousOwner  =new ArrayList<>();
    ArrayList<String>Fuel  =new ArrayList<>();
    ArrayList<String>Type  =new ArrayList<>();
    ArrayList<String>Insurance  =new ArrayList<>();
    ArrayList<String>OwnerMobileNumber  =new ArrayList<>();
    ArrayList<String>OwnerAddress  =new ArrayList<>();


}