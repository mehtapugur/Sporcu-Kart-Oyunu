package sporcugame;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UserPage extends javax.swing.JFrame {

    int sayac = 0;
    int countB = 0; //eşit gelen kart kontrolü
    int countF = 0;
    Boolean kontrolBasket = true;
    Boolean kontrolFutbol = true;
    String yol = "C:\\Users\\mehtap uğur\\Desktop\\JavaApplication16\\src\\sporcugame\\images\\";
    ArrayList<Basketbolcu> bilgisayarBasket = new ArrayList<>();
    ArrayList<Basketbolcu> userBasket = new ArrayList<>();
    ArrayList<Futbolcu> bilgisayarFutbol = new ArrayList<>();
    ArrayList<Futbolcu> userFutbol = new ArrayList<>();
    Test t = new Test();
    Kullanici user = new Kullanici(1, "Kullanici", 0);
    Bilgisayar pc = new Bilgisayar(2, "Computer", 0);

    public UserPage() {
        // initComponents();
    }

    public UserPage(ArrayList<Futbolcu> futList, ArrayList<Basketbolcu> baskList) {
        initComponents();

        jButton1.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton2.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton3.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton4.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton5.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton6.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton7.setIcon(new ImageIcon(yol + "back2.jpg"));
        jButton8.setIcon(new ImageIcon(yol + "back2.jpg"));

        for (int i = 0; i < 4; i++) { //Random basketbolcu dagitma
            int random;
            random = ((int) ((Math.random()) * 10)) % (baskList.size());
            bilgisayarBasket.add(baskList.get(random));
            baskList.remove(random);

            random = ((int) ((Math.random()) * 10)) % (baskList.size());
            userBasket.add(baskList.get(random));
            baskList.remove(random);
        }

        for (int i = 0; i < 4; i++) { //Random futbolcu dagitma
            int random;
            random = ((int) ((Math.random()) * 10)) % (futList.size());
            bilgisayarFutbol.add(futList.get(random));
            futList.remove(random);

            random = ((int) ((Math.random()) * 10)) % (futList.size());
            userFutbol.add(futList.get(random));
            futList.remove(random);
        }

        jButton9.setIcon(new ImageIcon(yol + userBasket.get(0).getIcon()));
        jButton10.setIcon(new ImageIcon(yol + userBasket.get(1).getIcon()));
        jButton11.setIcon(new ImageIcon(yol + userBasket.get(2).getIcon()));
        jButton12.setIcon(new ImageIcon(yol + userBasket.get(3).getIcon()));
        jButton13.setIcon(new ImageIcon(yol + userFutbol.get(0).getIcon()));
        jButton14.setIcon(new ImageIcon(yol + userFutbol.get(1).getIcon()));
        jButton15.setIcon(new ImageIcon(yol + userFutbol.get(2).getIcon()));
        jButton16.setIcon(new ImageIcon(yol + userFutbol.get(3).getIcon()));
    }

    public int methodBasket() { //BILGISAYAR RANDOM BASKETBOLCU KARTI SECIYOR
        int random;
        do {
            random = ((int) ((Math.random()) * 10)) % bilgisayarBasket.size();
            if (bilgisayarBasket.get(random).kartKullanildiMi == false) {
                jButton18.setIcon(new ImageIcon(yol + bilgisayarBasket.get(random).getIcon()));
                break;
            }
        } while (bilgisayarBasket.get(random).kartKullanildiMi == true);

        int i = t.pozisyonBilgisi(bilgisayarBasket.get(random));

        switch (i) {
            case 0: {
                jTextField3.setText("İkilik");
                jTextField5.setText(String.valueOf(bilgisayarBasket.get(random).getIkilik()));
                break;
            }
            case 1: {
                jTextField3.setText("Üçlük");
                jTextField5.setText(String.valueOf(bilgisayarBasket.get(random).getUcluk()));
                break;
            }
            case 2: {
                jTextField3.setText("Serbest Atış");
                jTextField5.setText(String.valueOf(bilgisayarBasket.get(random).getSerbestAtis()));
                break;
            }

        }

        switch (random) {
            case 0:
                jButton1.setIcon(null);
                break;
            case 1:
                jButton2.setIcon(null);
                break;
            case 2:
                jButton3.setIcon(null);
                break;
            case 3:
                jButton4.setIcon(null);
                break;
        }

        return random;
    }

    public int methodFutbol() { //BILGISAYAR RANDOM FUTBOLCU KARTI SECIYOR
        int random;

        do {
            random = ((int) ((Math.random()) * 10)) % bilgisayarFutbol.size();
            if (bilgisayarFutbol.get(random).kartKullanildiMi == false) {
                jButton18.setIcon(new ImageIcon(yol + bilgisayarFutbol.get(random).getIcon()));
                break;
            }
        } while (bilgisayarFutbol.get(random).kartKullanildiMi == true);

        int i = t.pozisyonBilgisi(bilgisayarFutbol.get(random));

        switch (i) {
            case 0: {
                jTextField3.setText("Penaltı");
                jTextField5.setText(String.valueOf(bilgisayarFutbol.get(random).getPenaltı()));
                break;
            }
            case 1: {
                jTextField3.setText("Serbest Vuruş");
                jTextField5.setText(String.valueOf(bilgisayarFutbol.get(random).getSerbestVurus()));
                break;
            }
            case 2: {
                jTextField3.setText("Kaleciyle Karşı Karşıya");
                jTextField5.setText(String.valueOf(bilgisayarFutbol.get(random).getKaleciKarsiKarsiya()));
                break;
            }

        }

        switch (random) {
            case 0:
                jButton5.setIcon(null);
                break;
            case 1:
                jButton6.setIcon(null);
                break;
            case 2:
                jButton7.setIcon(null);
                break;
            case 3:
                jButton8.setIcon(null);
                break;
        }

        return random;
    }

    public boolean karsilastir(boolean k) {
        if (Integer.parseInt(jTextField4.getText()) < Integer.parseInt(jTextField5.getText())) {
            int s = pc.getSkor();
            s = s + 10;
            pc.setSkor(s);
        } else if (Integer.parseInt(jTextField4.getText()) > Integer.parseInt(jTextField5.getText())) {
            int s = user.getSkor();
            s = s + 10;
            user.setSkor(s);
        } else if (Integer.parseInt(jTextField4.getText()) == Integer.parseInt(jTextField5.getText())) {
            return false;
        }
        return true;
    }

    public void skorYazdir() {
        jTextField6.setText(String.valueOf(pc.getSkor()));
        jTextField7.setText(String.valueOf(user.getSkor()));
    }

    public void butonBasket(JButton b, int i) {
        if (!userBasket.get(i).kartKullanildiMi && kontrolBasket) {
            jButton17.setIcon(new ImageIcon(yol + userBasket.get(i).getIcon()));
            int r = methodBasket();
            b.setIcon(null);

            if ("İkilik".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userBasket.get(i).getIkilik()));
            } else if ("Üçlük".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userBasket.get(i).getUcluk()));
            } else if ("Serbest Atış".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userBasket.get(i).getSerbestAtis()));
            }

            if (karsilastir(false) == true) {
                skorYazdir();
                userBasket.get(i).kartKullanildiMi = true;
                bilgisayarBasket.get(r).kartKullanildiMi = true;
                sayac++;
            } else if (karsilastir(false) == false) {
                JOptionPane.showMessageDialog(null, "Sporcu puanları eşit.\nLütfen sıradaki sporcudan devam edin.");
                b.setIcon(new ImageIcon(yol + userBasket.get(i).getIcon()));
                jButton17.setIcon(null);
                jButton18.setIcon(null);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                countB++;

                switch (r) {
                    case 0:
                        jButton1.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 1:
                        jButton2.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 2:
                        jButton3.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 3:
                        jButton4.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                }
            }

            kontrolBasket = false;
            kontrolFutbol = true;
        }

        if (sayac == 8) {
            oyunBitti();
        } else if (sayac == 7 && countB != 0) {
            kontrolBasket = true;
            kontrolFutbol = false;
        } else if (sayac == 6 && countB >= 2) {
            kontrolBasket = true;
            kontrolFutbol = false;
        } else if (sayac == 5 && countB >= 3) {
            kontrolBasket = true;
            kontrolFutbol = false;
        } else if (sayac == 4 && countB >= 4) {
            kontrolBasket = true;
            kontrolFutbol = false;
        }
    }

    public void butonFutbol(JButton b, int i) {
        if (!userFutbol.get(i).kartKullanildiMi && kontrolFutbol) {
            jButton17.setIcon(new ImageIcon(yol + userFutbol.get(i).getIcon()));
            int r = methodFutbol();
            b.setIcon(null);

            if ("Penaltı".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userFutbol.get(i).getPenaltı()));
            } else if ("Serbest Vuruş".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userFutbol.get(i).getSerbestVurus()));
            } else if ("Kaleciyle Karşı Karşıya".equals(jTextField3.getText())) {
                jTextField4.setText(String.valueOf(userFutbol.get(i).getKaleciKarsiKarsiya()));
            }

            if (karsilastir(false) == true) {
                skorYazdir();
                userFutbol.get(i).kartKullanildiMi = true;
                bilgisayarFutbol.get(r).kartKullanildiMi = true;
                sayac++;
            } else if (karsilastir(false) == false) {
                JOptionPane.showMessageDialog(null, "Sporcu puanları eşit.\nLütfen sıradaki sporcudan devam edin.");
                b.setIcon(new ImageIcon(yol + userFutbol.get(i).getIcon()));
                jButton17.setIcon(null);
                jButton18.setIcon(null);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                countF++;

                switch (r) {
                    case 0:
                        jButton5.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 1:
                        jButton6.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 2:
                        jButton7.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                    case 3:
                        jButton8.setIcon(new ImageIcon(yol + "back2.jpg"));
                        break;
                }
            }
            kontrolBasket = true;
            kontrolFutbol = false;
        }
        if (sayac == 8) {
            oyunBitti();
        } else if (sayac == 7 && countF != 0) {
            kontrolBasket = false;
            kontrolFutbol = true;
        } else if (sayac == 6 && countF >= 2) {
            kontrolBasket = false;
            kontrolFutbol = true;
        } else if (sayac == 5 && countF >= 3) {
            kontrolBasket = false;
            kontrolFutbol = true;
        } else if (sayac == 4 && countF >= 4) {
            kontrolBasket = false;
            kontrolFutbol = true;
        }
    }

    public void oyunBitti() { // OYUNU KİMİN KAZANDIĞINI YAZDIRDIĞIMIZ BÖLÜM

        if (pc.getSkor() < user.getSkor()) {
            JOptionPane.showMessageDialog(null, "TEBRİKLER SİZ KAZANDINIZ");
        } else if (pc.getSkor() > user.getSkor()) {
            JOptionPane.showMessageDialog(null, "OYUN BİTTİ. BİLGİSAYAR KAZANDI.");
        } else if (pc.getSkor() == user.getSkor()) {
            JOptionPane.showMessageDialog(null, "OYUN BERABERE BİTTİ");
        }
        setVisible(false);
        System.exit(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Dialog", 0, 23)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Computer");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(850, 90, 110, 40);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Dialog", 0, 23)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("User");
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(860, 420, 80, 40);

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(300, 380, 160, 30);

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(200, 450, 60, 30);

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(500, 450, 60, 30);

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");
        getContentPane().add(jTextField6);
        jTextField6.setBounds(870, 170, 60, 30);

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        getContentPane().add(jTextField7);
        jTextField7.setBounds(870, 350, 60, 30);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 20, 80, 100);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 20, 80, 100);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton3);
        jButton3.setBounds(200, 20, 80, 100);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton4);
        jButton4.setBounds(290, 20, 80, 100);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton5);
        jButton5.setBounds(380, 20, 80, 100);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton6);
        jButton6.setBounds(470, 20, 80, 100);

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jButton7);
        jButton7.setBounds(560, 20, 80, 100);

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(650, 20, 80, 100);

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(10, 580, 80, 100);

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(100, 580, 80, 100);

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(190, 580, 80, 100);

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(280, 580, 80, 100);

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13);
        jButton13.setBounds(370, 580, 80, 100);

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14);
        jButton14.setBounds(460, 580, 80, 100);

        jButton15.setBackground(new java.awt.Color(0, 0, 0));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15);
        jButton15.setBounds(550, 580, 80, 100);

        jButton16.setBackground(new java.awt.Color(0, 0, 0));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16);
        jButton16.setBounds(640, 580, 80, 100);

        jButton17.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jButton17);
        jButton17.setBounds(190, 230, 80, 100);

        jButton18.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jButton18);
        jButton18.setBounds(490, 230, 80, 100);

        jButton19.setBackground(new java.awt.Color(0, 0, 0));
        jButton19.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("VS");
        jButton19.setBorder(null);
        getContentPane().add(jButton19);
        jButton19.setBounds(340, 260, 90, 34);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puan :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 450, 90, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pozisyon :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 380, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sporcugame/images/background.png"))); // NOI18N
        jLabel1.setText("jLabel2");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 700);
        jLabel1.getAccessibleContext().setAccessibleName("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1120, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        butonBasket(jButton10, 1);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        butonBasket(jButton11, 2);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        butonBasket(jButton12, 3);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        butonFutbol(jButton13, 0);

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        butonFutbol(jButton14, 1);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        butonFutbol(jButton15, 2);

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        butonFutbol(jButton16, 3);

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        butonBasket(jButton9, 0);

    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
