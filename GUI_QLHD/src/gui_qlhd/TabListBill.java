/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_qlhd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThaiTran
 */
//public class TabListBill extends JPanel implements ActionListener{
//    private JTable table;
//    private Vector header= new Vector();
//    private Vector row = new Vector();
//    private JButton prev_btn;
//    private JButton next_btn;
//    private int curPage=0;
//    private JTextField page_lb;
//    public TabListBill(){
//        
//        this.setLayout(new BorderLayout());
//        
//        JPanel topP = new JPanel();
//       
//        this.add(topP, BorderLayout.NORTH);
//        
//        header.add("Mã hoá đơn");
//        header.add("Mã khách hàng");
//        header.add("Ngày lập");
//        header.add("Tổng tiền");
//        
//        table = new JTable(row, header);
//        table.setFillsViewportHeight(true);
//        
//        JPanel leftP = new JPanel();
//        prev_btn= new JButton();
//        prev_btn.setIcon(new ImageIcon("images/left-arrow.png"));
//        prev_btn.setFont(new Font("Arial", Font.PLAIN, 15));
//        prev_btn.setSize(50, 35);
//        prev_btn.setLocation(150,200);
//        prev_btn.addActionListener(this);
//        leftP.setLayout(null);
//        leftP.setPreferredSize(new Dimension(200,200));
//        leftP.add(prev_btn);
//        this.add(leftP, BorderLayout.LINE_START);
//        
//        JPanel centerP= new JPanel();
//        BoxLayout boxlayout= new BoxLayout(centerP, BoxLayout.Y_AXIS);
//        centerP.setLayout(boxlayout);
//        page_lb = new JTextField(Integer.toString(curPage));
//        page_lb.setAlignmentX(JLabel.CENTER);
//        page_lb.setPreferredSize(new Dimension(50, 50));
//        page_lb.setFont(new Font("Arial", Font.PLAIN, 15));
//        
//        centerP.add(new JScrollPane(table));
//        centerP.add(page_lb);
//        this.add(centerP, BorderLayout.CENTER);
//        
//        
//        JPanel rightP = new JPanel();
//        next_btn= new JButton();
//        next_btn.setFont(new Font("Arial", Font.PLAIN, 15));
//        next_btn.setSize(50, 35);
//        next_btn.setLocation(0,200);
//        next_btn.setIcon(new ImageIcon("Images/right-arrow.png"));
//        next_btn.addActionListener(this);
//        rightP.setLayout(null);
//        rightP.add(next_btn);
//        rightP.setPreferredSize(new Dimension(200,200));
//        this.add(rightP, BorderLayout.LINE_END);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == prev_btn){
//            this.curPage= (curPage-1) < 0 ? 0 : curPage-1;
//            this.page_lb.setText(Integer.toString(curPage));
//        }
//        else if(e.getSource() == next_btn){
//            this.curPage= curPage+1;
//            this.page_lb.setText(Integer.toString(curPage));
//        }
//    }
//    
//    
//}
public class TabListBill extends JPanel implements ActionListener {

    /**
     * Creates new form NewJPanel
     */
    public TabListBill() {
        initComponents();
    }
    private JButton prev_btn;
    private JButton next_btn;
    private JButton jButton3;
    private JLabel page_lb;
    private JLabel idBill_lb;
    private JLabel userId_lb;
    private JLabel date_lb;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField idBill_txt;
    private JTextField userId_txt;
    private JTextField date_txt;
    private int curPage = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        page_lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        prev_btn = new javax.swing.JButton();
        next_btn = new javax.swing.JButton();
        idBill_txt = new javax.swing.JTextField();
        idBill_lb = new javax.swing.JLabel();
        userId_lb = new javax.swing.JLabel();
        userId_txt = new javax.swing.JTextField();
        date_lb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        date_txt = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(900, 550));

        page_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        page_lb.setText("0");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Mã hoá đơn", "Mã khách hàng", "Ngày lập", "Tổng tiền"
                }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        prev_btn.setIcon(new ImageIcon("images/left-arrow.png"));
        prev_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        prev_btn.addActionListener(this);

        next_btn.setIcon(new ImageIcon("Images/right-arrow.png"));
        next_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        next_btn.addActionListener(this);

        idBill_txt.setText("");

        idBill_lb.setText("Mã HD");

        userId_lb.setText("Mã KH");

        userId_txt.setText("");

        date_lb.setText("Ngày Lập");

        jButton3.setText("Tìm");

        date_txt.setText("");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(prev_btn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(page_lb)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(next_btn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idBill_lb, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(idBill_txt, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(userId_lb, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(userId_txt, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                .addGap(26, 26, 26)
                                                .addComponent(date_lb, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(date_txt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(date_txt)
                                        .addComponent(date_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userId_txt)
                                        .addComponent(userId_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idBill_txt)
                                        .addComponent(idBill_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(page_lb)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(229, 229, 229)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(prev_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(next_btn, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addGap(244, 244, 244))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                                .addGap(96, 96, 96))))
        );
    }// </editor-fold>                                                           
    // Variables declaration - do not modify                     

    // End of variables declaration                   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prev_btn) {
            this.curPage = (curPage - 1) < 0 ? 0 : curPage - 1;
            this.page_lb.setText(Integer.toString(curPage));
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
        } else if (e.getSource() == next_btn) {
            this.curPage = curPage + 1;
            this.page_lb.setText(Integer.toString(curPage));
            
            /// add to table
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            // after query add data to table
            int count = 0;
            while (count < 50) {
                String id = "0000"+count;
                String customer = "KH0001";
                String date = "1/1/2021";
                String total = "1000";
                Object[] content = {id, customer, date, total};
                model.addRow(content);
                count++;
            }
        }
    }
}