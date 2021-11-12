package gui_qlhd;
//

import Bill.Bill;
import Bill.BillFunc;
import SqlConnection.MessageDialog;
import SqlConnection.Validator;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ThaiTran
 */
public class AddBill extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form TabAddNewBill
     */
    public AddBill() {
        initComponents();
        addProductComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        idBill_txt = new javax.swing.JTextField();
        idCus_txt = new javax.swing.JTextField();
        date_lb = new javax.swing.JLabel();
        idBill_lb = new javax.swing.JLabel();
        idCus_lb = new javax.swing.JLabel();
        day = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        add_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();
        title_lb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        product_lb = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        productName_sl = new javax.swing.JComboBox<>();
        left_lb = new javax.swing.JLabel();
        left_txt = new javax.swing.JTextField();
        buy_btn = new javax.swing.JButton();
        del_btn = new javax.swing.JButton();
        buyNum_lb = new javax.swing.JLabel();
        buyNum_txt = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(idBill_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 200, 30));
        jPanel1.add(idCus_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 200, 30));

        date_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_lb.setText("Ngày lập");
        jPanel1.add(date_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 40));

        idBill_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idBill_lb.setText("Mã hoá đơn");
        jPanel1.add(idBill_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        idCus_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idCus_lb.setText("Mã khách hàng");
        jPanel1.add(idCus_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jPanel1.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        jPanel1.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"}));
        jPanel1.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        add_btn.setText("Thêm");
        add_btn.addActionListener(this);
        jPanel1.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        reset_btn.setText("Reset");
        reset_btn.addActionListener(this);
        jPanel1.add(reset_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        title_lb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title_lb.setText("THÊM HOÁ ĐƠN");
        title_lb.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(title_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 152, 31));

        product_lb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        product_lb.setText("Sản phẩm");
        product_lb.setPreferredSize(new java.awt.Dimension(100, 100));

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã", "Tên sản phẩm", "Giá bán", "Giá giảm", "Số lượng mua"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollPane.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chọn sản phẩm");

        productName_sl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"chọn sản phẩm mua"}));
        productName_sl.addActionListener(this);

        left_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        left_lb.setText("Số lượng tồn");

        buy_btn.setText("Thêm");
        buy_btn.addActionListener(this);

        del_btn.setIcon(new javax.swing.ImageIcon("Images\\close.png")); // NOI18N
        del_btn.addActionListener(this);

        buyNum_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buyNum_lb.setText("Số lượng mua");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(product_lb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(del_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(left_lb))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(productName_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(buy_btn))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(left_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(buyNum_lb)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(buyNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 15, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(product_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productName_sl)
                                        .addComponent(jLabel1)
                                        .addComponent(buy_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(left_lb)
                                        .addComponent(buyNum_lb)
                                        .addComponent(buyNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(left_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(del_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        left_txt.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton add_btn;
    private javax.swing.JButton buy_btn;
    private javax.swing.JLabel date_lb;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JButton del_btn;
    private javax.swing.JLabel idBill_lb;
    private javax.swing.JTextField idBill_txt;
    private javax.swing.JLabel idCus_lb;
    private javax.swing.JTextField idCus_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel left_lb;
    private javax.swing.JTextField left_txt;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> productName_sl;
    private javax.swing.JLabel product_lb;
    private javax.swing.JButton reset_btn;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JLabel title_lb;
    private javax.swing.JComboBox<String> year;
    private JLabel buyNum_lb;
    private javax.swing.JTextField buyNum_txt;
    // End of variables declaration                   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.add_btn) {

            StringBuilder sb = new StringBuilder();
            Validator.validateEmpty(idCus_txt, sb, "User cannot be blank!");
            Validator.validateEmpty(idBill_txt, sb, "ID bill cannot be blank!");
            if (sb.length() > 0) {
                MessageDialog.showErrorDialog(this, sb.toString(), "Error!");
                return;
            }

            if (Validator.validateExistingBillID(idBill_txt.getText())) {
                MessageDialog.showErrorDialog(this, "This bill is existed!", "Error");
                return;
            }
            if (!Validator.validateExistingKH(idCus_txt.getText())) {
                MessageDialog.showErrorDialog(this, "Customer doesn't exist!", "Error");
                return;
            }

            Bill b = new Bill();
            b.setMaHD(idBill_txt.getText());
            b.setMaKh(idCus_txt.getText());
            b.setNgayLap(year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem());
            String id;
            BillFunc bf = new BillFunc();
            if (bf.addBillToDatabase(b)) {
                id = this.idBill_txt.getText();

                addProductToBill(id);

                String data = "Mã hoá đơn: " + id + "\n";
                String data1 = "Mã khách hàng: " + this.idCus_txt.getText() + "\n";
                String data2 = "Ngày lập: " + (String) this.day.getSelectedItem() + "/"
                        + this.month.getSelectedItem() + "/" + this.year.getSelectedItem() + "\n";
                MessageDialog.showMessageDialog(this, data + data1 + data2 + "đã được thêm thành công", "Thông báo!");
                resetField();
            }
        } else if (e.getSource() == this.reset_btn) {
            resetField();
        } else if (e.getSource() == this.productName_sl) {
            String item = (String) this.productName_sl.getSelectedItem();
            String query = "select soluongton from Sanpham where masp='" + item.split("-")[0] + "'";
            if (!item.equals("chọn sản phẩm mua")) {
                try {
                    ResultSet res;
                    res = SqlConnection.SqlConnection.excuteQuery(query);
                    if (res.next()) {
                        this.left_txt.setText(Integer.toString(res.getInt(1)));
                    }
                } catch (SQLServerException ex) {
                    Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == this.buy_btn) {
            buy();
        } else if (e.getSource() == del_btn) {
            deleteSelectedRowFromJtable();
        }

    }

    void resetField() {
        this.idBill_txt.setText("");
        this.idCus_txt.setText("");
    }

    void addProductComboBox() {
        try {
            ResultSet res;
            res = SqlConnection.SqlConnection.excuteQuery("select * from Sanpham");
            while (res.next()) {
                this.productName_sl.addItem(res.getString(1) + "-" + res.getString(2));
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void buy() {
        String item = (String) this.productName_sl.getSelectedItem();
        if (!item.equals("chọn sản phẩm mua") && !this.buyNum_txt.getText().isEmpty()) {
            int num = Integer.parseInt(this.buyNum_txt.getText());
            String arr[] = item.split("-");
            if (num <= Integer.parseInt(this.left_txt.getText())) {
                addToTable(arr[0], arr[1], num);
            } else {
                JOptionPane.showMessageDialog(null, "Số lượng mua vượt quá số lượng tồn", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm và nhập số lượng mua", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        }
    }

    void addToTable(String maSP, String tenSP, int soluong) {
        String s = "";
        boolean exists = false;
        for (int i = 0; i < table.getRowCount(); i++) {
            s = table.getValueAt(i, 0).toString().trim();
            if (maSP.equals(s)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            addToTable_ultil(maSP, tenSP, soluong);
        } else {
            JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại trong giỏ hàng", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        }

    }

    void addToTable_ultil(String maSP, String tenSP, int soluong) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // after query add data to table
        Object[] content = {maSP, tenSP, 0, 0, soluong};
        model.addRow(content);
    }

    void deleteSelectedRowFromJtable() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        int[] rows = table.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
    }

    void addProductToBill(String id) {
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                String idP = table.getValueAt(i, 0).toString().trim();
                String numP = table.getValueAt(i, 4).toString().trim();
                String sellP = table.getValueAt(i, 2).toString().trim();
                String saleP = table.getValueAt(i, 3).toString().trim();
                
                String query = "INSERT INTO CT_HoaDon (MaHD, MaSP, SoLuong, GiaBan, GiaGiam, ThanhTien)\n" +
                        "  VALUES ('"+id+"', '"+idP+"', "+numP+", "+sellP+", "+saleP+", 0);";
                SqlConnection.SqlConnection.excuteQueryUpdate(query);
            } catch (SQLServerException ex) {
                Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddBill.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}