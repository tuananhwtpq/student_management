/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Student;

import Class.ClassManagement;
import Counting.Thongke;
import LoginForAdmin.Login;
import Subject.SubjectManagement;

/**
 *
 * @author admin
 */
public class StudentManagement extends javax.swing.JFrame {

    /**
     * Creates new form StudentManagement
     */
    public StudentManagement() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        stumana = new javax.swing.JButton();
        subjectmana = new javax.swing.JButton();
        classmana = new javax.swing.JButton();
        counting = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputtext = new javax.swing.JTextField();
        searching = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Stutable = new javax.swing.JTable();
        addStu = new javax.swing.JButton();
        changeStu = new javax.swing.JButton();
        delStu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        title1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        title1.setText("QUẢN LÝ SINH VIÊN");

        logout.setBackground(new java.awt.Color(204, 204, 204));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logout.setText("Đăng xuất");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        stumana.setBackground(new java.awt.Color(0, 153, 255));
        stumana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stumana.setForeground(new java.awt.Color(255, 255, 255));
        stumana.setText("Quản lý thông tin sinh viên");

        subjectmana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        subjectmana.setText("Quản lý môn học");
        subjectmana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectmanaMouseClicked(evt);
            }
        });

        classmana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        classmana.setText("Quản lý lớp học");
        classmana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classmanaMouseClicked(evt);
            }
        });

        counting.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        counting.setText("Thống kê");
        counting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countingMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        searching.setBackground(new java.awt.Color(204, 204, 204));
        searching.setText("Tìm kiếm");

        Stutable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Ngành học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Stutable);
        if (Stutable.getColumnModel().getColumnCount() > 0) {
            Stutable.getColumnModel().getColumn(0).setPreferredWidth(20);
            Stutable.getColumnModel().getColumn(1).setPreferredWidth(120);
            Stutable.getColumnModel().getColumn(2).setPreferredWidth(60);
            Stutable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        addStu.setBackground(new java.awt.Color(204, 204, 204));
        addStu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addStu.setText("Thêm");
        addStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStuMouseClicked(evt);
            }
        });
        addStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStuActionPerformed(evt);
            }
        });

        changeStu.setBackground(new java.awt.Color(204, 204, 204));
        changeStu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        changeStu.setText("Sửa");
        changeStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeStuMouseClicked(evt);
            }
        });

        delStu.setBackground(new java.awt.Color(204, 204, 204));
        delStu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delStu.setText("Xóa");
        delStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delStuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(stumana)
                                .addGap(18, 18, 18)
                                .addComponent(subjectmana)
                                .addGap(18, 18, 18)
                                .addComponent(classmana)
                                .addGap(18, 18, 18)
                                .addComponent(counting))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(inputtext, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(searching))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(addStu)
                                .addGap(100, 100, 100)
                                .addComponent(changeStu)
                                .addGap(101, 101, 101)
                                .addComponent(delStu)))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title1)
                    .addComponent(logout))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectmana)
                    .addComponent(classmana)
                    .addComponent(counting)
                    .addComponent(stumana))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searching)
                    .addComponent(jLabel2)
                    .addComponent(inputtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStu)
                    .addComponent(changeStu)
                    .addComponent(delStu))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void addStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addStuActionPerformed

    private void addStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStuMouseClicked
        // TODO add your handling code here:
        addStu a = new addStu();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_addStuMouseClicked

    private void changeStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeStuMouseClicked
        // TODO add your handling code here:
        changeStu cs = new changeStu();
        cs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changeStuMouseClicked

    private void delStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delStuMouseClicked
        // TODO add your handling code here:
        delStu ds = new delStu();
        ds.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_delStuMouseClicked

    private void subjectmanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectmanaMouseClicked
        // TODO add your handling code here:
        SubjectManagement sm = new SubjectManagement();
        sm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_subjectmanaMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void classmanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classmanaMouseClicked
        // TODO add your handling code here:
        ClassManagement cm = new ClassManagement();
        cm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_classmanaMouseClicked

    private void countingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countingMouseClicked
        // TODO add your handling code here:
        Thongke tk = new Thongke();
        tk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_countingMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Stutable;
    private javax.swing.JButton addStu;
    private javax.swing.JButton changeStu;
    private javax.swing.JButton classmana;
    private javax.swing.JButton counting;
    private javax.swing.JButton delStu;
    private javax.swing.JTextField inputtext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton searching;
    private javax.swing.JButton stumana;
    private javax.swing.JButton subjectmana;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
