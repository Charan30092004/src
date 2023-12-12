import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Edit_Record extends javax.swing.JFrame {
    String data[];

    public Edit_Record() {
        initComponents();
    
    }
     public Edit_Record(String a[]) {
        data=a;
        initComponents();
    
    }

                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Details");

        jPanel1.setBackground(new java.awt.Color(156, 189, 211));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Vehicle Number      :");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Submit");
        
        jButton1.addActionListener(e->
        {
            try {
                jdbc mysql =new jdbc();
                
                rs=mysql.vehicledetails();
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
                String s=jTextField1.getText().trim();
                if(VehicleNumber.contains(s))
                    {
                        dispose();
                        int i=VehicleNumber.indexOf(s);
                        String data[]={Owner.get(i),VehicleNumber.get(i),VehicleModel.get(i),""+noOwner.get(i),PreviousOwner.get(i),Owner.get(i),Fuel.get(i),Type.get(i),Insurance.get(i),OwnerMobileNumber.get(i),OwnerAddress.get(i)};
                        Edit_Record2 ed2=new Edit_Record2(data);
                        ed2.main(data);  
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No Such Vehicle Found","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
            }
            catch (Exception ex) {
        
            }
        });

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
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Record(args).setVisible(true);
            }
        });
    }

                 
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;

    ArrayList<String> Owner =new ArrayList<>();
    ArrayList<String> VehicleNumber =new ArrayList<>();
    ArrayList<String> VehicleModel =new ArrayList<>();
    ArrayList<String> PreviousOwner =new ArrayList<>();
    ArrayList<String> Fuel =new ArrayList<>();
    ArrayList<String> Type =new ArrayList<>();
    ArrayList<String> Insurance =new ArrayList<>();
    ArrayList<String> OwnerMobileNumber =new ArrayList<>();
    ArrayList<String> OwnerAddress =new ArrayList<>();
    ArrayList<Integer> noOwner =new ArrayList<>();
    ResultSet rs;
                      
}