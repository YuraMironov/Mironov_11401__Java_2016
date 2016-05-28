package sem02;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sem02.components.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.ConnectException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Юра on 19.05.2016.
 */
public class Sem02Controller implements Initializable {
    private ObservableList<Firm> firms = FXCollections.observableArrayList();
    private ObservableList<String> simpleTarifsNames = FXCollections.observableArrayList();
    private ObservableList<String> simpleFirmsNames = FXCollections.observableArrayList();
    private final String URL = "http://localhost:8081/app/client/";
    private RestTemplate restTemplate = new RestTemplate();
    private ArrayList<Pane> myMainPanes = new ArrayList<Pane>();
    @FXML
    Pane loginPane;
    @FXML
    Pane userPane;
    @FXML
    Pane newsesPane;
    @FXML
    Pane advPane;
    @FXML
    Pane firmsPane;
    @FXML
    Pane myProfilePane;
    @FXML
    Pane addAdvPane;
    @FXML
    Pane changeTarifPane;
    @FXML
    Button loginBtn;
    @FXML
    Button newsesNavBtn;
    @FXML
    Button advNavBtn;
    @FXML
    Button firmsNavBtn;
    @FXML
    MenuItem changeTarifMenuItem;
    @FXML
    MenuItem profileMenuItem;
    @FXML
    MenuItem addAdvMenuItem;
    @FXML
    MenuItem logoutMenuItem;
    @FXML
    Button addAdvBtn;
    @FXML
    Button changeTarifBtn;
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Label myLogin;
    @FXML
    Label myEmail;
    @FXML
    Label myLast;
    @FXML
    Label myTarif;
    @FXML
    Label myFirm;
    @FXML
    Accordion newsesAcordion;
    @FXML
    TabPane advTabPane;
    @FXML
    TableView firmsTable;
    @FXML
    TableColumn<Firm, Integer> name;
    @FXML
    TableColumn<Firm, String> director;
    @FXML
    TableColumn<Firm, String> addres;
    @FXML
    TableColumn<Firm, String> raiting;
    @FXML
    ChoiceBox<String> selectTarif;
    @FXML
    ChoiceBox<String> selectFirm;
    @FXML
    TextField newAdvTitle;
    @FXML
    TextField newAdvFilesrc;
    @FXML
    TextArea newAdvBody;
    @FXML
    Label mess;
    SafetyUser currentUser;
    Client client;

    public void signIn() {
        try {
            currentUser = (SafetyUser) get("signin", SafetyUser.class);
            myLogin.setText(currentUser.getLogin());
            myEmail.setText(currentUser.getEmail());
            myLast.setText(currentUser.getLast().toString());
            myFirm.setText(currentUser.getFirm().getNameF());
            myTarif.setText(currentUser.getTarif().getNameT());
            loginPane.setVisible(false);
            userPane.setVisible(true);
        } catch (HttpClientErrorException ignored) {
            email.setText("Неправильные данные");
        }
    }

    public void newsesNavBtnClickHandler() {
        NewsList newses = (NewsList) get("getNewses", NewsList.class);
        for (int i = 0; i < 5; i++) {
            String title = newses.get(i).getTitle();
            String body = newses.get(i).getBody();
            newsesAcordion.getPanes().get(i).setText(title);
            TextArea ta = new TextArea(body);
            ta.setPrefHeight(170);
            ta.setPrefWidth(514);
            ta.setWrapText(true);
            ((AnchorPane) newsesAcordion.getPanes().get(i).getContent()).getChildren().add(ta);
        }
        allPanesSetVisible(false);
        newsesPane.setVisible(true);
    }

    final String PROMT_TEXT = "Обязательно для заполнения";

    public void advNavBtnClickHandler() {
        AdviceList advices = (AdviceList) get("getAdvices", AdviceList.class);
        for (int i = 0; i < 7; i++) {
            String title = advices.get(i).getAdvname();
            String body = advices.get(i).getAdvbody();
            advTabPane.getTabs().get(i).setText(title);
            TextArea ta = new TextArea(body);
            ta.setPrefHeight(289);
            ta.setPrefWidth(560);
            ta.setWrapText(true);
            ((AnchorPane) advTabPane.getTabs().get(i).getContent()).getChildren().add(ta);
        }
        newAdvTitle.setPromptText(PROMT_TEXT);
        newAdvBody.setPromptText(PROMT_TEXT);
        allPanesSetVisible(false);
        advPane.setVisible(true);
    }

    public void addAdvBtnClickHandler() {
        flag = !newAdvBody.getText().equals("") && !newAdvTitle.getText().equals("");
        if (flag) {
            client = ClientBuilder.newClient();
            MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
            formData.add("advname", newAdvTitle.getText());
            formData.add("advbody", newAdvBody.getText());
            formData.add("advfilesrc", newAdvFilesrc.getText());
            formData.add("uid", currentUser.getId() + "");
            Response response = client.target(URL).path("/addAdv").request().accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                    .header("Authorization", createHeaders().getFirst("Authorization")).post(Entity.form(formData));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                mess.setVisible(true);
                newAdvBody.setText(null);
                newAdvTitle.setText(null);
                newAdvFilesrc.setText("");
            }else{
                logoutMenuItemClickHandler();
                email.setText("Извините, что-то пошло не так");
            }
        }
    }

    public void firmsNavBtnClickHandler() throws NoSuchFieldException {
        FirmList firms = (FirmList) get("getFirms", FirmList.class);
        this.firms.clear();
        this.firms.addAll(firms);
        firmsTable.setItems(this.firms);
        allPanesSetVisible(false);
        firmsPane.setVisible(true);
    }

    private SimpleTarifsMap simpleTarifs;
    private SimpleFirmsMap simpleFirms;

    public void changeTarifMenuItemClickHandler() {
        simpleTarifs = (SimpleTarifsMap) get("getSimpleTarifs", SimpleTarifsMap.class);
        simpleFirms = (SimpleFirmsMap) get("getSimpleFirms", SimpleFirmsMap.class);
        this.simpleTarifsNames.clear();
        this.simpleTarifsNames.addAll(simpleTarifs.keySet());
        this.simpleFirmsNames.clear();
        this.simpleFirmsNames.addAll(simpleFirms.keySet());
        selectTarif.setItems(this.simpleTarifsNames);
        selectFirm.setItems(this.simpleFirmsNames);
        allPanesSetVisible(false);
        changeTarifPane.setVisible(true);
    }

    private boolean flag = false;

    public void changeTarifBtnClickHandler() {
        flag = !selectFirm.getValue().equals("") && !selectTarif.getValue().equals("");
        if (flag) {
            client = ClientBuilder.newClient();
            MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
            formData.add("fid", simpleFirms.get(selectFirm.getValue()) + "");
            formData.add("tid", simpleTarifs.get(selectTarif.getValue()) + "");
            formData.add("uid", currentUser.getId() + "");
            Response response = client.target(URL).path("/changeTarif").request().accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                    .header("Authorization", createHeaders().getFirst("Authorization")).post(Entity.form(formData));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                selectTarif.setValue("");
                selectFirm.setValue("");
            }else{
                logoutMenuItemClickHandler();
                email.setText("Извините, что-то пошло не так");
            }
        }
    }


    public void profileMenuItemClickHandler() {
        allPanesSetVisible(false);
        myProfilePane.setVisible(true);
    }

    public void addAdvMenuItemClickHandler() {
        allPanesSetVisible(false);
        addAdvPane.setVisible(true);
    }

    public void logoutMenuItemClickHandler() {
        email.setText("");
        password.setText("");
        currentUser = null;
        allPanesSetVisible(false);
        userPane.setVisible(false);
        loginPane.setVisible(true);
    }

    private void allPanesSetVisible(boolean a) {
        for (Pane pane : myMainPanes) {
            pane.setVisible(a);
        }
        mess.setVisible(false);
    }

    private <T> Object get(String url, Class<T> c) {
        return restTemplate.exchange(URL + url, HttpMethod.GET, new HttpEntity<Object>(createHeaders()), c).getBody();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myMainPanes.add(newsesPane);
        myMainPanes.add(advPane);
        myMainPanes.add(firmsPane);
        myMainPanes.add(myProfilePane);
        myMainPanes.add(addAdvPane);
        myMainPanes.add(changeTarifPane);

        name.setCellValueFactory(new PropertyValueFactory<Firm, Integer>("nameF"));
        director.setCellValueFactory(new PropertyValueFactory<Firm, String>("director"));
        addres.setCellValueFactory(new PropertyValueFactory<Firm, String>("addres"));
        raiting.setCellValueFactory(new PropertyValueFactory<Firm, String>("raiting"));

    }

    private HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {
                String auth = email.getText() + ":" + password.getText();
                byte[] encodedAuth = Base64.encode(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
