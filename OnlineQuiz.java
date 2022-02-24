package onlinequiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineQuiz extends JFrame implements ActionListener {	
	private static final long serialVersionUID = 1L;
	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	OnlineQuiz(String s) {
            super(s);
            label = new JLabel();
            add(label);
            bg = new ButtonGroup();
            for (int i = 0; i < 5; i++) {
		radioButton[i] = new JRadioButton();
		add(radioButton[i]);
		bg.add(radioButton[i]);
            }
            btnNext = new JButton("Next");
            btnBookmark = new JButton("Bookmark");
            btnNext.addActionListener(this);
            btnBookmark.addActionListener(this);
            add(btnNext);
            add(btnBookmark);
            set();
            label.setBounds(30, 40, 600, 20);
            radioButton[0].setBounds(50, 80, 500, 20);
            radioButton[1].setBounds(50, 110, 500, 20);
            radioButton[2].setBounds(50, 140, 500, 20);
            radioButton[3].setBounds(50, 170, 500, 20);
            btnNext.setBounds(100, 240, 100, 30);
            btnBookmark.setBounds(270, 240, 100, 30);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            setLocation(450, 100);
            setVisible(true);
            setSize(600, 350);
	}
	public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnNext) {
		if (check())
                    count = count + 1;
		current++;
		set();
		if (current == 9) {
                    btnNext.setEnabled(false);
                    btnBookmark.setText("Result");
		}
	}
	if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
		btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
	}
	for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
		now = current;
		current = m[y];
		set();
		((JButton) e.getSource()).setEnabled(false);
		current = now;
            }
	}
	if (e.getActionCommand().equals("Result")) {
            if (check())
		count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
	}
    }

	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Why Java is Partially OOP language?");
			radioButton[0].setText("It allows code to be written outside classes");
			radioButton[1].setText("It supports declaration of primitive datatypes");
			radioButton[2].setText("It does not support pointers");
			radioButton[3].setText("It doesn’t support inheritance");
		}
		if (current == 1) {
			label.setText("Que2:  Which among the following doesn’t come under OOP concept?");
			radioButton[0].setText("Data Hiding");
			radioButton[1].setText("Message Passing");
			radioButton[2].setText("Platform Independent");
			radioButton[3].setText("Data Binding");
		}
		if (current == 2) {
			label.setText("Que3: The feature by which one object can interact with another object is");
			radioButton[0].setText("Message reading");
			radioButton[1].setText("Message Passing");
			radioButton[2].setText("Data transfer");
			radioButton[3].setText("Data Binding");
		}
		if (current == 3) {
			label.setText("Que4: In multilevel inheritance, which is the most significant feature of OOP used?");
			radioButton[0].setText("Code efficiency");
			radioButton[1].setText("Code readability");
			radioButton[2].setText("Flexibility");
			radioButton[3].setText("Code reusability");
		}
		if (current == 4) {
			label.setText("Que5:  Which of the following is not true about polymorphism?");
			radioButton[0].setText("Helps in redefining the same functionality");
			radioButton[1].setText("Increases overhead of function definition always");
			radioButton[2].setText("It is feature of OOPs");
			radioButton[3].setText("Ease in readability of program");
		}
		if (current == 5) {
			label.setText("Que6: What is an abstraction in object-oriented programming?");
			radioButton[0].setText("Hiding the implementation and showing only the features");
			radioButton[1].setText("Hiding the important data");
                        radioButton[2].setText("Hiding the implementation");
			radioButton[3].setText("Showing the important data");
		}
		if (current == 6) {
                        label.setText("Que7: Which among the following can show polymorphism?");
			radioButton[0].setText("Overloading &&");
                        radioButton[1].setText("Overloading <<");
			radioButton[2].setText("Overloading ||");
			radioButton[3].setText("Overloading +=");
		}
		if (current == 7) {
			label.setText("Que8:  In which access should a constructor be defined, so that object of the class can be created in any function?");
			radioButton[0].setText("Any access specifier will work");
			radioButton[1].setText("Private");
			radioButton[2].setText("Public");
			radioButton[3].setText("Protected");
		}
		if (current == 8) {
			label.setText("Que9: What happens when an object is passed by reference?");
			radioButton[0].setText("Destructor is called at end of function");
			radioButton[1].setText("Destructor is called when called explicitly");
			radioButton[2].setText("Destructor is not called");
			radioButton[3].setText("Destructor is called when function is out of scope");
		}
		if (current == 9) {
			label.setText("Que10: How to overcome diamond problem?");
			radioButton[0].setText("Using seperate derived class");
			radioButton[1].setText("Using virtual keyword with same name function");
			radioButton[2].setText("Can’t be done");
			radioButton[3].setText("Using alias name");
		}
		label.setBounds(30, 40, 500, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineQuiz("Online Quiz App");
	}

}
