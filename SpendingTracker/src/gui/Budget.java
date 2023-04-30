package gui;
import java.sql.*;  //loading jdbc package
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.YearMonth;

public class Budget extends javax.swing.JFrame {

    
    public Budget() {
        initComponents();
        displayCategory();
        displayCategory1();
        budgetDisplay();
        getEntries();
    }
    
    private void getEntries(){                                            //this method is used to show the entires in the table, just show ,not adding any new entry
        try{
            javax.swing.table.DefaultTableModel dtm=                      //we're not using any different table ui model so we're using defailt table model.    //we're downcasting here. Downcasting is a type of typecasting. typecasting is basically coverting one data type into another. Upcasting and downcasting. downcasting is converting Parent object into child object. javax.swing.table.DefaultTableModel is the parent object here and (javax.swing.table.DefaultTableModel) is the child object.
        (javax.swing.table.DefaultTableModel)table.getModel();              //taking tabel's model to show multiple values in the tabel
            int rc=dtm.getRowCount();                                       //storing tabel model row count in the variable in rc
            while(rc--!=0){                                                 //using this loop to remove any previously added model entries because every time when we use the add button, it calls this function ao old entries and new entries with the old entries gets shown in the table
                dtm.removeRow(0);                                       //every time row no. 0 is removed , new row becomes 0
            }
            
            
            ResultSet rs=db.DbConnect.st.executeQuery(                  
                "select * from budget");
           
            
            int total=0;
            while(rs.next()){                                           //.next() shifts its focus to the next row
                int t=rs.getInt("budgetT");                        // storing the value of amount in t
                Object o[]={rs.getInt("sid"),                       //making an array and storing all the result set values in the o array that will be shown in the tablel
              rs.getString("category"),t};
              dtm.addRow(o);                                     //adding row to the table rown with O array values

            }
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void displayCategory(){ //method to show category in the category combobox field
        try{
            category.removeAllItems();         //it removes the existing category do the new category and the old category can be displayed together
            ResultSet rs=db.DbConnect.st.executeQuery( //connecting so we get all the data from the database
                    "select * from category_info"); //taking all the data and puting it in rs variable
            while(rs.next()){ //rs.next() will cause it to go from the first to the next row sequentially
                category.addItem(rs.getString("category")); //taking the values from the category column as a string and adding it to the category combobox
            
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex); //dialog box to show an execption which might occur
        }
    }
    
    private void displayCategory1(){ //method to show category in the category combobox field
        try{
            category1.removeAllItems();         //it removes the existing category do the new category and the old category can be displayed together
            ResultSet rs=db.DbConnect.st.executeQuery( //connecting so we get all the data from the database
                    "select * from category_info"); //taking all the data and puting it in rs variable
            while(rs.next()){ //rs.next() will cause it to go from the first to the next row sequentially
                category1.addItem(rs.getString("category")); //taking the values from the category column as a string and adding it to the category combobox
            
   
            
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex); //dialog box to show an execption which might occur
        }
    }
    
    private void budgetDisplay() {
        try{
               String c=(String)category1.getSelectedItem();
               ResultSet rs=db.DbConnect.st.executeQuery(  //connecting so we get all the data from the database
                    "select * from budget where category='"+c+"'");                     //taking all the data and puting it in rs variable
               
               rs.next();int btotal=rs.getInt("budgetT");  //budget amount
               ResultSet rs1=db.DbConnect.st1.executeQuery(  //connecting so we get all the data from the database
                    "select * from spendings where category='"+c+"'");                     //taking all the data and puting it in rs variable
               int amtS=0; //amount spent
            while(rs1.next()){                                           //.next() shifts its focus to the next row
                int m=rs1.getInt("amount");                        // storing the value of amount in t
                amtS=amtS+m;                                          // adding total every time the amount t is updated
//                Object o[]={rs.getInt("sid"),                       //making an array and storing all the result set values in the o array that will be shown in the tablel
//              rs.getString("category"),rs.getDate("sdate"),t};
//                dtm.addRow(o);                                     //adding row to the table rown with O array values
            }
            int bLeft=btotal-amtS;
            aS.setText(amtS+"");
            bT.setText(btotal+"");
            bL.setText(bLeft+"");
            if(bLeft<0){
            notice.setText("You have exceeded your given Budget by: "+bLeft);
            }else if(bLeft==0){
            notice.setText("You have used all your budget");
            }else{
            notice.setText("You have budget left by: "+bLeft);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex); //dialog box to show an execption which might occur
        }
            
            
               
               
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        bT = new javax.swing.JLabel();
        bL = new javax.swing.JLabel();
        aS = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        notice = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        category1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Budget");

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Budget");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Category:");

        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Amount");

        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aKeyTyped(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extrafiles/refresh.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sid", "Category", "Budget Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Budget Left:");

        bT.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bT.setText("0");

        bL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bL.setText("0");

        aS.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        aS.setText("0");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Budget Spent:");

        jButton3.setText("Show");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        notice.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        notice.setText("Notice");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Budget");

        category1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Budget Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(aS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(category1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(category1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(aS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notice)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aKeyTyped
        char ch=evt.getKeyChar();   // all the char type inputs in the  amount field is stored in the ch variable
        if(!Character.isDigit(ch)){  // if the entered values are not no.
            evt.consume();   //.consume removes the characters and doesnt allow more of the same type to be enetered
        }
    }//GEN-LAST:event_aKeyTyped

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        getEntries();
        displayCategory();//refresh the category
    }//GEN-LAST:event_jButton4ActionPerformed

    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        budgetDisplay();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ri=table.getSelectedRow();                                          // getSelectedRow() gives the selected row index and its been stored in the varieble ri
        if(ri!=-1){
            int r=JOptionPane.showConfirmDialog(null,
                "Do you really wanna delete?", "Deletion Confirmation",          //showing a dialog of deletion confirmation and taking ye or no as option
                JOptionPane.YES_NO_OPTION);
            if(r==JOptionPane.YES_OPTION){
                String category=(String)table.getValueAt(ri,1);             //we're taking the category value for the index that is selected as we dont know that yet and its been stored into the variable
                try{
                    db.DbConnect.st.executeUpdate(
                        "delete from budget where category='"+category+"'");            //deleting the row of the category which was selected
                    JOptionPane.showMessageDialog(null,
                        "Budget Deleted Successfully!");                //showing a dialog of deletion
                    getEntries();                                                   //using this function to update the new entires
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{                                                                    // using try and catch exception handelling because JDBC throws exceptions all the time
            String s1=a.getText();
            String c=(String)category.getSelectedItem();
            //a being amount box input name
            if(!s1.equals("")){                                       //when the category feild is not empty
                int amount=Integer.parseInt(s1);  //converting string value of amount to int
                db.DbConnect.st.executeUpdate(                                      //db being our package name and DbConnect being our class name
                    "insert into budget (category,budgetT) values('"+         //inserting the values in the datatbase by sql commands
                    c+"',"+amount+")");                                                // to not pass category as a string, we'll not use 'category' , we'll use '"+category+"'
                JOptionPane.showMessageDialog(null,
                    "Budget Added Successfully!");
                getEntries();                                                       // calling this function so every time the add button is used, the tabel shows the entry getting added
            }else{                                                                 //when the category feild is empty
                JOptionPane.showMessageDialog(null,
                    "Set an amount for the Budget");
            }
        }catch(SQLIntegrityConstraintViolationException ex){                    //exception where duplicate values are added  category already exists
            JOptionPane.showMessageDialog(null,
                "Budget Already Exist");
        }catch(Exception ex){                                                   //any exception  being catched will be showed as a dialog box
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JLabel aS;
    private javax.swing.JLabel bL;
    private javax.swing.JLabel bT;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel notice;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
