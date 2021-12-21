package FacultyGuess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

class humanities {
    String name;
    int gender_f;
    int math;
    int phy;

    public humanities(String name, int gender_f, int math, int phy) {
        this.name = name;
        this.gender_f = gender_f;
        this.math = math;
        this.phy = phy;
    }
}

class comps {
    String name;
    int gender_f;
    int cppjava;
    int coa;
    int sem3;
    int sem2;

    public comps(String name, int gender_f, int cppjava, int coa, int sem3, int sem2) {
        this.name = name;
        this.gender_f = gender_f;
        this.cppjava = cppjava;
        this.coa = coa;
        this.sem3 = sem3;
        this.sem2 = sem2;
    }
}

class it {
    String name;
    int gender_f;
    int cppjava;
    int dbms;
    int dsgt;

    public it(String name, int gender_f, int cppjava, int dbms, int dsgt) {
        this.name = name;
        this.gender_f = gender_f;
        this.cppjava = cppjava;
        this.dbms = dbms;
        this.dsgt = dsgt;
    }
}

public class FacultyGuess implements ActionListener {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spitfaculty",
                    "root", "123krishna");
            System.out.println("Connection created");
            System.out.println("jdbc:mysql://localhost:3306/spitfaculty");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    Boolean flag = false;
    int department = 0;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextField FinalAns = new JTextField();
    JTextField thanks = new JTextField();
    JTextArea textArea = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton buttonYes = new JButton();
    JButton buttonNo = new JButton();
    JButton Replay = new JButton();

    int indexC = 0;
    int indexH = 0;
    int indexI = 0;

    ArrayList<HashMap<String, String>> arr = new ArrayList<>();
    String[] compQuest = new String[6];
    String[] compProp = new String[6];
    String[] humQuest = new String[4];
    String[] humProp = new String[4];
    String[] itQuest = new String[5];
    String[] itProp = new String[5];
    HashMap[] map = new HashMap[10];

    public FacultyGuess() {
        for (int i = 0; i < 10; i++) {
            map[i] = new HashMap();
        }
        frame.setTitle("Faculty guess linked with MySQL");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.getContentPane().setBackground(new Color(238, 206, 200));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        textField.setBounds(0, 0, 600, 60);
        textField.setBackground(new Color(255, 176, 156));
        textField.setForeground(Color.black);
        textField.setFont(new Font("SansSerif", Font.BOLD, 40));
        textField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(10, 90, 560, 45);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 176, 156));
        textArea.setForeground(Color.black);
        textArea.setFont(new Font("SansSerif", Font.BOLD, 24));
        textArea.setBorder(BorderFactory.createBevelBorder(2));
        textArea.setEditable(false);

        textArea2.setBounds(10, 150, 560, 80);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setBackground(new Color(255, 176, 156));
        textArea2.setForeground(Color.black);
        textArea2.setFont(new Font("SansSerif", Font.BOLD, 24));
        textArea2.setBorder(BorderFactory.createBevelBorder(2));
        textArea2.setEditable(false);

        FinalAns.setBounds(10, 100, 560, 80);
        FinalAns.setBackground(new Color(255, 176, 156));
        FinalAns.setForeground(Color.black);
        FinalAns.setFont(new Font("SansSerif", Font.BOLD, 40));
        FinalAns.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        FinalAns.setHorizontalAlignment(JTextField.CENTER);
        FinalAns.setEditable(false);

        thanks.setBounds(10, 250, 560, 80);
        thanks.setBackground(new Color(255, 176, 156));
        thanks.setForeground(Color.black);
        thanks.setFont(new Font("SansSerif", Font.BOLD, 40));
        thanks.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        thanks.setHorizontalAlignment(JTextField.CENTER);
        thanks.setEditable(false);

        button1.setBounds(120, 300, 80, 50);
        button1.setFont(new Font("SansSerif", Font.BOLD, 35));
        button1.setText("1");
        button1.setBackground(new Color(124, 123, 222));
        button1.addActionListener(this);

        button2.setBounds(250, 300, 80, 50);
        button2.setFont(new Font("SansSerif", Font.BOLD, 35));
        button2.setText("2");
        button2.setBackground(new Color(124, 123, 222));
        button2.addActionListener(this);

        button3.setBounds(380, 300, 80, 50);
        button3.setFont(new Font("SansSerif", Font.BOLD, 35));
        button3.setText("3");
        button3.setBackground(new Color(124, 123, 222));
        button3.addActionListener(this);

        buttonYes.setBounds(100, 300, 150, 50);
        buttonYes.setFont(new Font("SansSerif", Font.BOLD, 24));
        buttonYes.setText("YES");
        buttonYes.addActionListener(this);

        buttonNo.setBounds(320, 300, 150, 50);
        buttonNo.setFont(new Font("SansSerif", Font.BOLD, 24));
        buttonNo.setText("NO");
        buttonNo.addActionListener(this);

        Replay.setBounds(10, 380, 560, 50);
        Replay.setFont(new Font("SansSerif", Font.BOLD, 30));
        Replay.setText("Replay");
        Replay.addActionListener(this);

        frame.add(textField);
        frame.add(textArea);
        frame.add(textArea2);
        textField.setText("Guessing the S.P.I.T Faculty");
        textArea.setText("  Which department does the faculty belong to ?");
        textArea2.setText("  1. Computer Engineering  2. Applied Science & Humanities  3. Information Technology?");
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
        compQuest[0] = " Is the faculty female? ";
        compQuest[1] = " Did faculty teach programming in c/c++/java ? ";
        compQuest[2] = " Does the faculty teach COA? ";
        compQuest[3] = " Has the faculty taught in sem3 ? ";
        compQuest[4] = " Has the faculty taught in sem2 ? ";
        compProp[0] = "gender_f";
        compProp[1] = "cppjava";
        compProp[2] = "coa";
        compProp[3] = "sem3";
        compProp[4] = "sem2";
        // ____________________________________________________________________________________

        humQuest[0] = " Is the faculty female? ";
        humQuest[1] = " Does the faculty teach Math? ";
        humQuest[2] = " Does the faculty teach Physics related subject? ";

        humProp[0] = "gender_f";
        humProp[1] = "math";
        humProp[2] = "phy";

        // _____________________________________________________________________________________

        itQuest[0] = " Is the faculty female?";
        itQuest[1] = " Did faculty teach programming in c/c++/java ? ";
        itQuest[2] = " Does the faculty teach Database Management System ? ";
        itQuest[3] = " Does the faculty teach Discrete Str. & Graph Theory ? ";

        itProp[0] = "gender_f";
        itProp[1] = "cppjava";
        itProp[2] = "dbms";
        itProp[3] = "dsgt";
        // _____________________________________________________________________________________

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            department = 1;
            try {
                compInit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            frame.remove(button3);
            frame.remove(button2);
            frame.remove(button1);
            textArea.setText("Searching Computer Engineering Department");
            textArea2.setText(compQuest[indexC]);
            frame.add(buttonYes);
            frame.add(buttonNo);
            frame.repaint();
        }

        else if (e.getSource() == button2) {
            department = 2;
            try {
                ScHumInit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            frame.remove(button3);
            frame.remove(button2);
            frame.remove(button1);
            textArea.setText("Searching Applied Sc. & Humanities Department");
            textArea2.setText(humQuest[indexH]);
            frame.add(buttonYes);
            frame.add(buttonNo);
            frame.repaint();
        }

        else if (e.getSource() == button3) {
            department = 3;
            try {
                ITInit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            frame.remove(button3);
            frame.remove(button2);
            frame.remove(button1);
            textArea.setText("Searching Information Technology Department");
            textArea2.setText(itQuest[indexI]);
            frame.add(buttonYes);
            frame.add(buttonNo);
            frame.repaint();
        }

        if (e.getSource() == buttonYes) {
            if (department == 1) {
                if (!flag && indexC < 5) {
                    input("1", compProp[indexC]);
                    if (indexC == 1)
                        indexC++;
                    indexC++;
                    textArea2.setText(compQuest[indexC]);
                }
            }
            if (department == 2) {
                if (!flag && indexH < 3) {
                    input("1", humProp[indexH]);
                    indexH++;
                    textArea2.setText(humQuest[indexH]);
                }
            }
            if (department == 3) {
                if (!flag && indexI < 4) {
                    input("1", itProp[indexI]);
                    indexI++;
                    textArea2.setText(itQuest[indexI]);
                }
            }
        }
        if (e.getSource() == buttonNo) {
            if (department == 1) {
                if (!flag && indexC < 5) {
                    input("0", compProp[indexC]);
                    indexC++;
                    textArea2.setText(compQuest[indexC]);
                }
            }
            if (department == 2) {
                if (!flag && indexH < 3) {
                    input("0", humProp[indexH]);
                    indexH++;
                    textArea2.setText(humQuest[indexH]);
                }
            }
            if (department == 3) {
                if (!flag && indexI < 4) {
                    input("0", itProp[indexI]);
                    indexI++;
                    textArea2.setText(itQuest[indexI]);
                }
            }
        }
        if (e.getSource() == Replay) {
            frame.dispose();
            new FacultyGuess();
        }
    }

    void compInit() throws SQLException {
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        comps[] carr = new comps[10];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from comps");
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                int gender_f = rs.getInt("gender_f");
                int cppjava = rs.getInt("cppjava");
                int coa = rs.getInt("coa");
                int sem3 = rs.getInt("sem3");
                int sem2 = rs.getInt("sem2");
                carr[i] = new comps(name, gender_f, cppjava, coa, sem3, sem2);
                map[i].put("name", carr[i].name);
                map[i].put("gender_f", carr[i].gender_f);
                map[i].put("cppjava", carr[i].cppjava);
                map[i].put("coa", carr[i].coa);
                map[i].put("sem3", carr[i].sem3);
                map[i].put("sem2", carr[i].sem2);
                arr.add(map[i]);
                i++;
            }
            System.out.println("Added all data of Computer Engineering");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void ScHumInit() throws SQLException {
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        humanities[] hum = new humanities[6];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from humanities");
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                int gender_f = rs.getInt("gender_f");
                int math = rs.getInt("math");
                int phy = rs.getInt("phy");
                hum[i] = new humanities(name, gender_f, math, phy);
                map[i].put("name", hum[i].name);
                map[i].put("gender_f", hum[i].gender_f);
                map[i].put("math", hum[i].math);
                map[i].put("phy", hum[i].phy);
                arr.add(map[i]);
                i++;
            }
            System.out.println("Added all data of App. Science & Humanities");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void ITInit() throws SQLException {
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        it[] itarr = new it[6];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from it");
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                int gender_f = rs.getInt("gender_f");
                int cppjava = rs.getInt("cppjava");
                int dbms = rs.getInt("dbms");
                int dsgt = rs.getInt("dsgt");
                itarr[i] = new it(name, gender_f, cppjava, dbms, dsgt);
                map[i].put("name", itarr[i].name);
                map[i].put("gender_f", itarr[i].gender_f);
                map[i].put("cppjava", itarr[i].cppjava);
                map[i].put("dbms", itarr[i].dbms);
                map[i].put("dsgt", itarr[i].dsgt);
                arr.add(map[i]);
                i++;
            }
            System.out.println("Added all data of Information Technology");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FacultyGuess();
    }

    void input(String answer, String property) {
        ArrayList remover = new ArrayList();
        for (Object o : arr) {
            HashMap ch = (HashMap) o;
            String pr = String.valueOf(ch.get(property));
            if (!pr.equals(answer)) {
                remover.add(ch);
            }
        }

        for (Object obj : remover) {
            arr.remove(obj);
        }
        if (arr.size() == 1) {
            HashMap<String, String> item = arr.get(0);
            String comm = item.get("name");
            System.out.println(comm);
            frame.remove(textArea2);
            frame.remove(textArea);
            frame.remove(buttonYes);
            frame.remove(buttonNo);
            textField.setText("You are thinking of");
            FinalAns.setText(comm);
            thanks.setText("Thank you");

            frame.repaint();
            frame.add(FinalAns);
            frame.add(thanks);
            frame.add(Replay);
            frame.repaint();

            // flag = true;
        }
        if (arr.size() == 0) {
            System.out.println("No Data Found");
            frame.remove(textArea);
            frame.remove(textArea2);
            frame.remove(buttonYes);
            frame.remove(buttonNo);
            FinalAns.setText("No Data Found");
            thanks.setText("Enter inputs again");
            frame.repaint();
            frame.add(FinalAns);
            frame.add(thanks);
            frame.add(Replay);
            frame.repaint();
            // flag = true;
        }
    }
}