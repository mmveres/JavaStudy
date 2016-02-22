package ex_registrartion.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ex_registrartion.entities.Participant;
import ex_registrartion.rmi.ConfServer;

public class Client {
	/* Объявляются переменные */
	static JFrame frame;
	static JPanel panel;

	JLabel lbLastName;
	JLabel lbFirstName;
	JLabel lbOrganization;
	JLabel lbReportTheme;
	JLabel lbEmail;

	JTextField txtLastName;
	JTextField txtFirstName;
	JTextField txtOrganization;
	JTextField txtReportTheme;
	JTextField txtEmail;

	JButton submit;
	
	String url = "//localhost:59001/Array";

	/* Определяется конструктор по умолчанию */
	public Client() {
		/* Создается JFrame */
		frame = new JFrame("Регистрация участника конференции");
		panel = new JPanel();
		/* Набор менеджеров разметки */
		panel.setLayout(new GridLayout(5, 2));		
		frame.setBounds(100, 100, 400, 200);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Define the swing components on the JFrame */
		lbLastName = new JLabel("Фамилия");
		lbFirstName = new JLabel("Имя");
		lbReportTheme = new JLabel("Тема доклада");
		lbOrganization = new JLabel("Организация");
		lbEmail = new JLabel("Емайл");

		txtLastName = new JTextField(15);
		txtFirstName = new JTextField(15);
		txtOrganization = new JTextField(70);
		txtReportTheme = new JTextField(100);
		txtEmail = new JTextField(15);

		submit = new JButton("Отправить");

		/* Добавление в панель компонентов swing */
		panel.add(lbLastName);
		panel.add(txtLastName);
		panel.add(lbFirstName);
		panel.add(txtFirstName);
		panel.add(lbOrganization);
		panel.add(txtOrganization);
		panel.add(lbReportTheme);
		panel.add(txtReportTheme);
		panel.add(lbEmail);
		panel.add(txtEmail);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(submit, BorderLayout.SOUTH);
		frame.setVisible(true);

		submit.addActionListener(new ButtonListener());
	}

	/* Создание класса ButtonListener */
	class ButtonListener implements ActionListener {
		/* Определение метода actionPerformed() */
		public void actionPerformed(ActionEvent evt) {
			try {
				// Получение удаленного объекта
// Если сервер размещен на удаленном компьютере, 
// то вместо localhost указывается имя 
// хоста сервера
							ConfServer server = (ConfServer) Naming.lookup(url);

				// Формирование сведений о регистрации для 
//отправки на сервер
				Participant participant=new Participant(
						txtFirstName.getText(), 
						txtLastName.getText(), 
						txtOrganization.getText(), 
						txtReportTheme.getText(), 
						txtEmail.getText());
				// Вызов удаленного метода
				server.registerConfParticipant(participant);
				
				String users = "";
				List<Participant> participants = server.getAllParticipants();
				for (Participant participant2 : participants) {
					users=users+participant2.toString()+"\n";
				}
				
				JOptionPane.showMessageDialog(frame, 
"Регистрация выполнена успешно\n" +
				"участники: \n" +users+
"\nКоличество зарегистрированных участников - " + 
participants.size() + 
				"\nСпасибо за участие");
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Ошибка");
				System.out.println(e);
			}
		}
	}

	// Определение метода main() 
	public static void main(String args[]) {
		// Создание объекта класса Client 
		new Client();
	}
}
