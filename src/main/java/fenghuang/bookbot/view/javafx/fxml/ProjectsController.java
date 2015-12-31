package fenghuang.bookbot.view.javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fenghuang.bookbot.model.Book;
import fenghuang.bookbot.model.Tag;
import fenghuang.bookbot.model.Status.STATUS;
import fenghuang.bookbot.service.BookBotService;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class ProjectsController implements Initializable {
	@Autowired
	private BookBotService service;
	@FXML
	private TableView<Book> tableBook;
	@FXML
	private TableColumn<Book, Integer> columnId;
	@FXML
	private TableColumn<Book, String> columnTitle;
	@FXML
	private TableColumn<Book, String> columnPath;
	@FXML
	private TableColumn<Book, STATUS> columnStatus;
	@FXML
	private TableColumn<Book, String> columnTag;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		columnPath.setCellValueFactory(new PropertyValueFactory<>("path"));
		columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		columnTag.setCellValueFactory((p) -> new SimpleStringProperty(
		        p.getValue().getTags().stream().map(Tag::getText).collect(Collectors.joining(","))));
		service.findAllBooks().forEach(book -> tableBook.getItems().add(book));
	}
}