/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_qlhd;

import Bill.Bill;
import Bill.BillFunc;
import SqlConnection.MessageDialog;
import SqlConnection.Validator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ThaiTran
 */
public class TabAddBill extends JPanel implements ActionListener {

    private JLabel title;
    private JLabel idBill_lb;
    private JLabel user_lb;
    private JLabel gender;
    private JLabel time_lb;
    private JLabel res;
    private JLabel add;
    private JTextField user_txt;
    private JTextField idBill_txt;
    private JButton genId_btn;
    private JButton sub_btn;
    private JButton reset_btn;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JComboBox day;
    private JComboBox month;
    private JComboBox year;
    private JCheckBox term;
    private JTextArea tadd;
    private JTextArea tout;
    private JTextArea resadd;

    private String dates[]
            = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
    private String months[]
            = {"01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12"};
    private String years[]
            = {"1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022"};

    // constructor, to initialize the components
    // with default values.
    public TabAddBill() {
        //setTitle("Registration Form");
        //setBounds(300, 90, 900, 600);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        //c = getContentPane();
        this.setLayout(null);

        title = new JLabel("Thêm hoá đơn");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        this.add(title);

        idBill_lb = new JLabel("Mã hoá đơn");
        idBill_lb.setFont(new Font("Arial", Font.PLAIN, 20));
        idBill_lb.setSize(150, 25);
        idBill_lb.setLocation(100, 100);
        this.add(idBill_lb);

        idBill_txt = new JTextField();
        idBill_txt.setFont(new Font("Arial", Font.PLAIN, 15));
        idBill_txt.setSize(190, 25);
        idBill_txt.setLocation(250, 100);
        this.add(idBill_txt);

        genId_btn = new JButton();
        genId_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        genId_btn.setSize(50, 25);
        genId_btn.setLocation(440, 100);
        genId_btn.setIcon(new ImageIcon("Images/icon_arrow.png"));
        genId_btn.addActionListener(this);
        this.add(genId_btn);

        user_lb = new JLabel("Mã khách hàng");
        user_lb.setFont(new Font("Arial", Font.PLAIN, 20));
        user_lb.setSize(200, 25);
        user_lb.setLocation(100, 150);
        this.add(user_lb);

        user_txt = new JTextField();
        user_txt.setFont(new Font("Arial", Font.PLAIN, 15));
        user_txt.setSize(190, 25);
        user_txt.setLocation(250, 150);
        this.add(user_txt);

        time_lb = new JLabel("Ngày lập");
        time_lb.setFont(new Font("Arial", Font.PLAIN, 20));
        time_lb.setSize(100, 25);
        time_lb.setLocation(100, 200);
        this.add(time_lb);

        day = new JComboBox(dates);
        day.setFont(new Font("Arial", Font.PLAIN, 15));
        day.setSize(50, 25);
        day.setLocation(250, 200);
        this.add(day);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 25);
        month.setLocation(300, 200);
        this.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 25);
        year.setLocation(360, 200);
        this.add(year);

        sub_btn = new JButton("Thêm");
        sub_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        sub_btn.setSize(100, 20);
        sub_btn.setLocation(150, 250);
        sub_btn.addActionListener(this);
        this.add(sub_btn);

        reset_btn = new JButton("Reset");
        reset_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        reset_btn.setSize(100, 20);
        reset_btn.setLocation(270, 250);
        reset_btn.addActionListener(this);
        this.add(reset_btn);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 150);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        this.add(tout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sub_btn) {

            StringBuilder sb = new StringBuilder();
            Validator.validateEmpty(user_txt, sb, "User cannot be blank!");
            Validator.validateEmpty(idBill_txt, sb, "ID bill cannot be blank!");
            if (sb.length() > 0) {
                MessageDialog.showErrorDialog(this, sb.toString(), "Error!");
                return;
            }

            if (Validator.validateExistingBillID(idBill_txt.getText())) {
                MessageDialog.showErrorDialog(this, "This bill is existed!", "Error");
                return;
            }
            if (!Validator.validateExistingKH(user_txt.getText())) {
                MessageDialog.showErrorDialog(this, "Customer doesn't exist!", "Error");
                return;
            }
            
            Bill b = new Bill();
            b.setMaHD(idBill_txt.getText());
            b.setMaKh(user_txt.getText());
            b.setNgayLap(year.getSelectedItem()+"-"+ month.getSelectedItem()+"-" +day.getSelectedItem());
            
            BillFunc bf = new BillFunc();
            if(bf.addBillToDatabase(b)){
                MessageDialog.showMessageDialog(this,"Add bill successully!", "Notification!");
            }
            
            //neu thuc hien truy van thanh cong thi thong bao
            if (true) {
                String data = "Mã hoá đơn: " + this.idBill_txt.getText() + "\n";
                String data1 = "Mã khách hàng: " + this.user_txt.getText() + "\n";
                String data2 = "Ngày lập: " + (String) this.day.getSelectedItem() + "/"
                        + this.month.getSelectedItem() + "/" + this.year.getSelectedItem() + "\n";
                tout.setText(data + data1 + data2 + "Đã được thêm");
                tout.setEditable(false);
                resetField();
            }
        } else if (e.getSource() == this.reset_btn) {
            resetField();
            this.tout.setText("");
        } else if (e.getSource() == this.genId_btn){
            idBill_txt.setText("");
        }

    }
    
    void resetField() {
        this.idBill_txt.setText("");
        this.user_txt.setText("");
    }
}
