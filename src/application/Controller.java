package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller implements Initializable {

	private Parent root;
	private Stage stage;

	/////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField txt1 = new TextField();
	@FXML
	private TextField txt2 = new TextField();
	@FXML
	private TextField txt3 = new TextField();
	@FXML
	private TextField txt4 = new TextField();
	@FXML
	private TextField txt5 = new TextField();
	@FXML
	private TextField txt6 = new TextField();
	////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField txt7 = new TextField();
	@FXML
	private TextArea txt8 = new TextArea("");
	///////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Document> tv1 = new TableView<>();

	@FXML
	private TableColumn<Document, String> docname = new TableColumn<>();
	@FXML
	private TableColumn<Document, Integer> q = new TableColumn<Document, Integer>();
	@FXML
	private TableColumn<Document, String> CID = new TableColumn<Document, String>();
	@FXML
	private TableColumn<Document, String> majorid = new TableColumn<Document, String>();
	/////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Document> tv2 = new TableView<>();
	/////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Student> tv3 = new TableView<>();
	@FXML
	private TableColumn<Student, Integer> sid = new TableColumn<>();
	@FXML
	private TableColumn<Student, String> sname = new TableColumn<Student, String>();
	@FXML
	private TableColumn<Student, String> address = new TableColumn<Student, String>();
	@FXML
	private TableColumn<Student, String> email = new TableColumn<Student, String>();
	/////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Major> tv4 = new TableView<>();
	@FXML
	private TableColumn<Major, String> mid = new TableColumn<>();
	@FXML
	private TableColumn<Major, String> mname = new TableColumn<Major, String>();
	@FXML
	private TableColumn<Major, Integer> chours = new TableColumn<Major, Integer>();
	/////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Course> tv5 = new TableView<>();
	@FXML
	private TableColumn<Course, String> cid = new TableColumn<>();
	@FXML
	private TableColumn<Course, String> cname = new TableColumn<Course, String>();
	@FXML
	private TableColumn<Course, Integer> capacity = new TableColumn<Course, Integer>();
	@FXML
	private TableColumn<Course, String> majid = new TableColumn<Course, String>();
	//////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TableView<Own> tv6 = new TableView<>();
	@FXML
	private TableColumn<Own, Integer> stid = new TableColumn<>();
	@FXML
	private TableColumn<Own, String> dname = new TableColumn<Own, String>();
	@FXML
	private TableColumn<Own, String> crsid = new TableColumn<Own, String>();
	@FXML
	private TableColumn<Own, String> Mid = new TableColumn<Own, String>();
	//////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text1 = new TextField();

	@FXML
	private TextField text2 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text3 = new TextField();

	@FXML
	private TextField text4 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text5 = new TextField();

	@FXML
	private TextField text6 = new TextField();

	@FXML
	private TextField text7 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text8 = new TextField();

	@FXML
	private TextField text9 = new TextField();

	@FXML
	private TextField text10 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text11 = new TextField();

	@FXML
	private TextField text12 = new TextField();

	@FXML
	private TextField text13 = new TextField();

	@FXML
	private TextField text14 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text15 = new TextField();

	@FXML
	private TextField text16 = new TextField();

	@FXML
	private TextField text17 = new TextField();

	@FXML
	private TextField text18 = new TextField();

	@FXML
	private TextField text19 = new TextField();

	@FXML
	private TextField text20 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text21 = new TextField();

	@FXML
	private TextField text22 = new TextField();

	@FXML
	private TextField text23 = new TextField();

	@FXML
	private TextField text24 = new TextField();

	@FXML
	private TextField text25 = new TextField();

	@FXML
	private TextField text26 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text27 = new TextField();

	@FXML
	private TextField text28 = new TextField();

	@FXML
	private TextField text29 = new TextField();

	@FXML
	private TextField text30 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField text31 = new TextField();

	@FXML
	private TextField text32 = new TextField();
	/////////////////////////////////////////////////////////////////////////////////////

	private ArrayList<Student> students = new ArrayList<Student>();
	@FXML
	private Label label1 = new Label();

	private ArrayList<Passwords> passwords = new ArrayList<>();
	private ArrayList<Passwords> admins = new ArrayList<>();

	@FXML
	ChoiceBox<String> ch1 = new ChoiceBox<>();
	// private ChoiceBox<String> ch2 = new ChoiceBox<String>();

	ObservableList<String> ol1 = FXCollections.observableArrayList("notes", "book", "Both");

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ch1.getItems().addAll(ol1);
		ch1.setValue("Both");

		// Documents tables
		docname.setCellValueFactory(new PropertyValueFactory<Document, String>("dname"));
		q.setCellValueFactory(new PropertyValueFactory<Document, Integer>("quantity"));
		CID.setCellValueFactory(new PropertyValueFactory<Document, String>("cid"));
		majorid.setCellValueFactory(new PropertyValueFactory<Document, String>("majorid"));

		// Student table
		sid.setCellValueFactory(new PropertyValueFactory<Student, Integer>("sid"));
		sname.setCellValueFactory(new PropertyValueFactory<Student, String>("sname"));
		address.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
		email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));

		// Major table
		mname.setCellValueFactory(new PropertyValueFactory<Major, String>("mname"));
		mid.setCellValueFactory(new PropertyValueFactory<Major, String>("mid"));
		chours.setCellValueFactory(new PropertyValueFactory<Major, Integer>("chours"));

		// Course table
		cid.setCellValueFactory(new PropertyValueFactory<Course, String>("courseid"));
		cname.setCellValueFactory(new PropertyValueFactory<Course, String>("mname"));
		majid.setCellValueFactory(new PropertyValueFactory<Course, String>("mid"));
		capacity.setCellValueFactory(new PropertyValueFactory<Course, Integer>("capacity"));

		// Report table
		stid.setCellValueFactory(new PropertyValueFactory<Own, Integer>("sid"));
		dname.setCellValueFactory(new PropertyValueFactory<Own, String>("Docname"));
		Mid.setCellValueFactory(new PropertyValueFactory<Own, String>("majorid"));
		crsid.setCellValueFactory(new PropertyValueFactory<Own, String>("Cid"));

		try {
			Scanner input = new Scanner(new File("passwords.txt"));
			while (input.hasNextLine()) {
				String[] tokens = input.nextLine().split(" ");
				passwords.add(new Passwords(tokens[0].trim(), tokens[1].trim()));

			}
			input = new Scanner(new File("admin.txt"));
			while (input.hasNextLine()) {
				String[] tokens = input.nextLine().split(" ");
				admins.add(new Passwords(tokens[0].trim(), tokens[1].trim()));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void addstudent(ActionEvent e) throws NumberFormatException, SQLException {
		boolean valid = true;
		if (txt1.getText().isBlank() || txt2.getText().isBlank() || txt3.getText().isBlank() || txt4.getText().isBlank()
				|| txt5.getText().isBlank() || txt6.getText().isBlank()) {
			// label1.setText("Error");
			//System.out.println("first error");
			valid = false;
		} else {
			students = new StudentQueries().getallStudents();
			for (int i = 0; i < students.size(); ++i) {
				if (students.get(i).getSid() == Integer.parseInt(txt1.getText().trim())
						|| txt5.getText().trim().length() < 8 || !txt5.getText().trim().equals(txt6.getText().trim())) {
					// label1.setText("Error");
					//System.out.println("loop error");
					valid = false;

					break;
				}

			}
			if (valid) {
				System.out.println("valid");
				StudentQueries s = new StudentQueries();
				s.addStudent(Integer.parseInt(txt1.getText().trim()), txt2.getText().trim(), txt3.getText().trim(),
						txt4.getText().trim());
				students.add(new Student(Integer.parseInt(txt1.getText().trim()), txt2.getText().trim(),
						txt3.getText().trim(), txt4.getText().trim()));
				// insert a new Student here
				passwords.add(new Passwords(txt1.getText().trim(), txt5.getText().trim()));
				try {
					FileWriter fw = new FileWriter("passwords.txt");
					for (int i = 0; i < passwords.size(); ++i)
						fw.write(passwords.get(i).getSid() + " " + passwords.get(i).getPassword() + "\n");
					fw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			txt1.setText("done");
			// label1.setText("All Set");
		}
	}

	////////////////////////////////////////////////////////////////////////////////

	public void switchtoadminmenu(ActionEvent e) {
		try {
			if (!txt7.getText().trim().isEmpty() && !txt8.getText().trim().isEmpty()) {

				for (int i = 0; i < passwords.size(); ++i)
					if (txt7.getText().trim().equals(passwords.get(i).getSid())
							&& txt8.getText().trim().equals(passwords.get(i).getPassword())) {

						root = FXMLLoader.load(getClass().getResource("menu.fxml"));
						stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); // switch to student menu
						stage.setScene(new Scene(root));
						stage.show();
					}

				for (int i = 0; i < admins.size(); ++i)
					if (txt7.getText().trim().equals(admins.get(i).getSid())
							&& txt8.getText().trim().equals(admins.get(i).getPassword())) {
						root = FXMLLoader.load(getClass().getResource("admin.fxml"));
						stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
						stage.setScene(new Scene(root));
						stage.show();
					}
			}

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtosignup(ActionEvent e) { // register new student
		try {
			root = FXMLLoader.load(getClass().getResource("signup.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoadd(ActionEvent e) { // notes or book
		try {
			root = FXMLLoader.load(getClass().getResource("documenttype.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoaddnotes(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("addnotes.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////

	public void addbook(ActionEvent e) throws NumberFormatException, SQLException {
		if (!(text15.getText().isBlank() || text16.getText().isBlank() || text17.getText().isBlank()
				|| text18.getText().isBlank() || text19.getText().isBlank())) {
			DocumentQueries dc = new DocumentQueries();
			dc.addDocument(text15.getText().trim(), Integer.parseInt(text18.getText().trim()), text19.getText().trim(),
					text20.getText().trim());
			dc.addBook(text15.getText().trim(), Integer.parseInt(text18.getText().trim()), text16.getText().trim(),
					text17.getText().trim(), text19.getText().trim(), text20.getText().trim());
			text15.setText("Done :D");
			text16.clear();
			text17.clear();
			text18.clear();
			text19.clear();
			text20.clear();
		} else
			text15.setText("error");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addnote(ActionEvent e) throws NumberFormatException, SQLException { // here
		if (!(text21.getText().isBlank() || text22.getText().isBlank() || text23.getText().isBlank()
				|| text24.getText().isBlank() || text25.getText().isBlank())) {
			DocumentQueries dc = new DocumentQueries();
			dc.addDocument(text21.getText().trim(), Integer.parseInt(text24.getText().trim()), text25.getText().trim(),
					text26.getText().trim());
			dc.addNote(text21.getText().trim(), Integer.parseInt(text24.getText().trim()),
					Integer.parseInt(text22.getText().trim()), text23.getText().trim(), text25.getText().trim(),
					text26.getText().trim());
			text21.setText("Done :D");
			text22.clear();
			text23.clear();
			text24.clear();
			text25.clear();
			text26.clear();
		} else
			text21.setText("error");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addown(ActionEvent e) throws NumberFormatException, SQLException { // borrow
		if (!(text27.getText().isBlank() || text28.getText().isBlank() || text29.getText().isBlank()
				|| text30.getText().isBlank())) {
			new StudentQueries().addOwns(Integer.parseInt(text27.getText().trim()), text28.getText().trim(),
					text29.getText().trim(), text30.getText().trim());
			label1.setText("Done");
			text27.clear();
			text28.clear();
			text29.clear();
			text30.clear();
		} else
			label1.setText("Error");
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoaddbook(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("addbook.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoDocument(ActionEvent e) {
		try {
			ch1.setValue("Both");
			tv1.getItems().clear();
			tv1.getItems().addAll(new DocumentQueries().getallDocuments());
			root = FXMLLoader.load(getClass().getResource("Document.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoCourse(ActionEvent e) {
		try {
			tv5.getItems().clear();
			tv5.getItems().addAll(new CourseQueries().getallCourses());
			root = FXMLLoader.load(getClass().getResource("Course.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void backtoAdminmenu(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoMajor(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("Major.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			tv4.getItems().clear();
			ArrayList<Major> m = new MajorQueries().getallMajors();
			tv4.getItems().addAll(new MajorQueries().getallMajors());
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoborrow(ActionEvent e) {
		try {
			label1.setText("");
			root = FXMLLoader.load(getClass().getResource("borrow.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoDocumentstd(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("Documentstd.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			ch1.setValue("Both");
			tv2.getItems().clear();
			tv2.getItems().addAll(new DocumentQueries().getallDocuments());
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtomenu(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoadmintable(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("admintable.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoStudent(ActionEvent e) {
		try {
			tv3.getItems().clear();
			tv3.getItems().addAll(new StudentQueries().getallStudents());
			root = FXMLLoader.load(getClass().getResource("Student.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoReport(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("Report.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtoadmin(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("Addadmin.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtwelcome(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void backtomenu(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void switchtodocumenttype(ActionEvent e) {
		try {

			root = FXMLLoader.load(getClass().getResource("documenttype.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void searchdocstd(ActionEvent e) { // problem

		ArrayList<Document> result = new ArrayList<>();
		DocumentQueries dc = new DocumentQueries();
		if (!text3.getText().isBlank()) {
			if (!text4.getText().isBlank())
				if (!ch1.getValue().equals("Both")) {
					Document doc = dc.getDocumentbyall(text3.getText().trim(), text4.getText().trim(),
							ch1.getValue().trim());
					if (doc != null)
						result.add(doc);
				}

				else {
					Document doc = dc.getDocumentnameandCid(text3.getText().trim(), text4.getText().trim());
					if (doc != null)
						result.add(doc);

				}
			else if (!ch1.getValue().equals("Both")) {
				Document doc = dc.getDocumentnameandtype(text3.getText().trim(), ch1.getValue().trim());
				if (doc != null)
					result.add(doc);
			} else {
				Document doc = dc.getDocumentByName(text3.getText().trim());
				if (doc != null)
					result.add(doc);
			}

		} else if (!text4.getText().isBlank()) {
			if (!ch1.getValue().equals("Both"))
				result = dc.getDocumentcidandtype(text4.getText().trim(), ch1.getValue().trim());
			else
				result = dc.getDocumentCid(text4.getText().trim());
		} else if (!ch1.getValue().equals("Both"))
			result = dc.getDocumentBytype(ch1.getValue().trim());

		else
			result = dc.getallDocuments();
		//System.out.println(result.toString());
		tv2.getItems().clear();
		tv2.getItems().addAll(result);
		dc.closeConnection();

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public void searchdocadmin(ActionEvent e) {
		ArrayList<Document> result = new ArrayList<>();
		DocumentQueries dc = new DocumentQueries();
		if (!text1.getText().isBlank()) {
			if (!text2.getText().isBlank())
				if (!ch1.getValue().equals("Both")) {
					Document doc = dc.getDocumentbyall(text1.getText().trim(), text2.getText().trim(),
							ch1.getValue().trim());
					if (doc != null)
						result.add(doc);
				}

				else {
					Document doc = dc.getDocumentnameandCid(text1.getText().trim(), text2.getText().trim());
					if (doc != null)
						result.add(doc);

				}
			else if (!ch1.getValue().equals("Both")) {
				Document doc = dc.getDocumentnameandtype(text1.getText().trim(), ch1.getValue().trim());
				if (doc != null)
					result.add(doc);
			} else {
				Document doc = dc.getDocumentByName(text1.getText().trim());
				if (doc != null)
					result.add(doc);
			}

		} else if (!text2.getText().isBlank()) {
			if (!ch1.getValue().equals("Both"))
				result = dc.getDocumentcidandtype(text2.getText().trim(), ch1.getValue().trim());
			else
				result = dc.getDocumentCid(text2.getText().trim());
		} else if (!ch1.getValue().equals("Both"))
			result = dc.getDocumentBytype(ch1.getValue().trim());

		else
			result = dc.getallDocuments();
		tv1.getItems().clear();
		tv1.getItems().addAll(result);
		dc.closeConnection();
	}

	////////////////////////////////////////////////////////////////////////////////////////////

	public void searchMajor(ActionEvent e) {

		ArrayList<Major> result = new ArrayList<>();
		MajorQueries dc = new MajorQueries();
		if (!text5.getText().isBlank()) {
			if (!text6.getText().isBlank()) {
				if (!text7.getText().isBlank()) {

					Major doc = dc.getMajorbyall(text5.getText().trim(), text6.getText().trim(),
							Integer.parseInt(text7.getText().trim()));
					if (doc != null)
						result.add(doc);
				}

				else {
					Major doc = dc.getMajorByidandname(text5.getText().trim(), text6.getText().trim());
					if (doc != null)
						result.add(doc);

				}

			}

			else if (!text7.getText().isBlank()) {
				Major doc = dc.getAllMajorsidandhours(text5.getText().trim(), Integer.parseInt(text7.getText().trim()));
				if (doc != null)
					result.add(doc);
			} else {
				Major doc = dc.getMajorByid(text5.getText().trim());
				if (doc != null)
					result.add(doc);
			}

		} else if (!text6.getText().isBlank()) {
			if (!text7.getText().isBlank())
				result = dc.getAllMajorsnameandhours(text6.getText().trim(), Integer.parseInt(text7.getText().trim()));
			else
				result = dc.getMajorByname(text6.getText().trim());
		} else if (!text7.getText().isBlank())
			result = dc.getMajorByhours(Integer.parseInt(text7.getText().trim()));

		else
			result = dc.getallMajors();

		tv4.getItems().clear();
		tv4.getItems().addAll(result);
		dc.closeConnection();

	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	public void searchCourse(ActionEvent e) {

		ArrayList<Course> result = new ArrayList<>();
		CourseQueries dc = new CourseQueries();
		if (!text5.getText().isBlank()) {
			if (!text6.getText().isBlank())
				if (!text7.getText().isBlank()) {
					Course doc = dc.getCoursebyall(text8.getText().trim(), text9.getText().trim(),
							Integer.parseInt(text10.getText().trim()));
					if (doc != null)
						result.add(doc);
				}

				else {
					Course doc = dc.getCourseByidandname(text5.getText().trim(), text6.getText().trim());
					if (doc != null)
						result.add(doc);

				}
			else if (!text7.getText().isBlank()) {
				Course doc = dc.getAllCoursesidandcapacity(text5.getText().trim(),
						Integer.parseInt(text7.getText().trim()));
				if (doc != null)
					result.add(doc);
			} else {
				Course doc = dc.getCourseByid(text5.getText().trim());
				if (doc != null)
					result.add(doc);
			}

		} else if (!text6.getText().isBlank()) {
			if (!text7.getText().isBlank())
				result = dc.getAllCoursesnameandcapacity(text6.getText().trim(),
						Integer.parseInt(text7.getText().trim()));
			else
				result = dc.getCourseByname(text6.getText().trim());
		} else if (!text7.getText().isBlank())
			result = dc.getCourseBycapacity(Integer.parseInt(text7.getText().trim()));

		else
			result = dc.getallCourses();
		tv5.getItems().clear();
		tv5.getItems().addAll(result);
		dc.closeConnection();

	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	public void searchOwn(ActionEvent e) {
		ArrayList<Own> result = new ArrayList<Own>();
		if (text31.getText().isBlank() || text32.getText().isBlank()) {
			result = new OwnQueiries().getallStudents();
		} else {
			if (!text31.getText().isBlank()) {
				if (!text32.getText().isBlank()) {
					result = new OwnQueiries().getbyboth(Integer.parseInt(text31.getText().trim()),
							text32.getText().trim());
				} else
					result = new OwnQueiries().getbysid(Integer.parseInt(text31.getText().trim()));
			} else
				result = new OwnQueiries().getbydocname(text32.getText().trim());

		}//System.out.println(result.toString());
		tv6.getItems().clear();
		tv6.getItems().addAll(result);

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void searchStudent(ActionEvent e) {

		ArrayList<Student> result = new ArrayList<>();
		StudentQueries dc = new StudentQueries();
		if (!text11.getText().isBlank()) {
			if (!text12.getText().isBlank()) {
				if (!text13.getText().isBlank()) {
					if (!text14.getText().isBlank()) {
						Student doc = dc.getStudentbyall(Integer.parseInt(text11.getText().trim()),
								text12.getText().trim(), text13.getText().trim(), text14.getText().trim());
						if (doc != null)
							result.add(doc);
					} else {
						Student doc = dc.getStudentbyidandnameandaddress(Integer.parseInt(text11.getText().trim()),
								text12.getText().trim(), text13.getText().trim());
						if (doc != null)
							result.add(doc);
					}

				} else if (!text14.getText().isBlank()) {
					Student doc = dc.getStudentbyidandnameandemail(Integer.parseInt(text11.getText().trim()),
							text12.getText().trim(), text14.getText().trim());
					if (doc != null)
						result.add(doc);
				} else {
					Student doc = dc.getStudentByidandname(Integer.parseInt(text11.getText().trim()),
							text12.getText().trim());
					if (doc != null)
						result.add(doc);

				}
			}

			else if (!text13.getText().isBlank()) {
				if (!text14.getText().isBlank()) {
					Student doc = dc.getStudentbyidandaddressandemail(Integer.parseInt(text11.getText().trim()),
							text13.getText().trim(), text14.getText().trim());
					if (doc != null)
						result.add(doc);
				} else {

					Student doc = dc.getStudentbyidandaddress(Integer.parseInt(text11.getText().trim()),
							text13.getText().trim());
					if (doc != null)
						result.add(doc);

				}
			} else if (!text14.getText().isBlank()) {
				Student doc = dc.getStudentbyidandemail(Integer.parseInt(text11.getText().trim()),
						text14.getText().trim());
				if (doc != null)
					result.add(doc);

			} else {
				Student doc = dc.getStudentByid(Integer.parseInt(text11.getText().trim()));
				if (doc != null)
					result.add(doc);
			}

		}

		else if (!text12.getText().isBlank()) {
			if (!text13.getText().isBlank())
				if (!text14.getText().isBlank()) {
					Student doc = dc.getStudentbynameandaddressandemail(text12.getText().trim(),
							text13.getText().trim(), text14.getText().trim());
					if (doc != null)
						result.add(doc);
				} else {

					Student doc = dc.getStudentbynameandaddress(text12.getText().trim(), text13.getText().trim());
					if (doc != null)
						result.add(doc);

				}

			else if (!text14.getText().isBlank()) {
				Student doc = dc.getStudentbynameandemail(text12.getText().trim(), text14.getText().trim());
				if (doc != null)
					result.add(doc);

			} else {
				Student doc = dc.getStudentByname(text12.getText().trim());
				if (doc != null)
					result.add(doc);

			}
		} else if (!text13.getText().isBlank()) {
			if (!text14.getText().isBlank()) {
				result = dc.getStudentbyaddressandemail(text13.getText().trim(), text14.getText().trim());

			} else {
				result = dc.getStudentbyaddress(text12.getText().trim());

			}
		} else if (!text14.getText().isBlank())
			result = dc.getStudentbyemail(text14.getText().trim());

		else
			result = dc.getallStudents();
		tv3.getItems().clear();
		tv3.getItems().addAll(result);
		dc.closeConnection();

	}

}