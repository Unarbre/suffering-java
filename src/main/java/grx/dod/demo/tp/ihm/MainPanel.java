package grx.dod.demo.tp.ihm;

import grx.dod.demo.tp.Drawer;
import grx.dod.demo.tp.Infrastructure.FormsParser;
import grx.dod.demo.tp.datastructures.generic.GenericScenario;
import grx.dod.demo.tp.datastructures.simplified.SimplifiedScenario;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.TypedScenario;
import grx.dod.demo.tp.ihm.components.RadioGroup;
import grx.dod.demo.tp.ihm.components.fields.CircleFields;
import grx.dod.demo.tp.ihm.components.fields.RectangleFields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class MainPanel {
    public JPanel panel1;

    private JRadioButton typedRadioButton;
    private JRadioButton simplifiedRadioButton;
    private JRadioButton genericRadioButton;

    private RadioGroup typeRadioGroup;
    private RadioGroup operationRadioGroup;

    private CircleFields circleFields;
    private RectangleFields rectangleFields;

    private JRadioButton calculateSpaceRadioButton;
    private JRadioButton calculateMultithreadedRadioButton;
    private JRadioButton calculatePipelineRadioButton;

    private JButton runButton;
    private JButton addRectangleButton;
    private JButton addCercleButton;


    private JTextField rectangleX;
    private JTextField rectangleY;
    private JTextField rectangleWidth;
    private JTextField rectangleHeight;
    private JComboBox<String> rectangleColor;

    private JTextField circleX;
    private JTextField circleY;
    private JTextField circleRadius;
    private JComboBox<String> circleColor;
    private JTextArea circleAmount;

    private List<Forme> formes;
    private Drawer drawer = new Drawer();

    private SimplifiedScenario simplifiedScenario;
    private TypedScenario typedScenario;
    private GenericScenario genericScenario;

    public MainPanel() throws Exception {
        this.setupRadioGroups();
        this.setupRunButton();
        this.setupCreationFields();
        this.loadFormes();
        display();
    }

    private void setupCreationFields() {
        this.circleFields = new CircleFields(circleColor, circleX, circleY, circleRadius);
        this.rectangleFields = new RectangleFields(rectangleColor, rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        this.addCercleButton.addActionListener(this::addCercle);
        this.addRectangleButton.addActionListener(this::addRectangle);
    }

    private void loadFormes() throws Exception {
        this.simplifiedScenario = new SimplifiedScenario("src/main/resources/espace.txt");
        this.genericScenario = new GenericScenario("src/main/resources/espace.txt");
        this.typedScenario = new TypedScenario("src/main/resources/espace.txt");
        this.formes = new FormsParser().parse("src/main/resources/espace.txt");
    }

    private void display() {
        this.drawer.draw(this.formes, typedScenario.calculEspace());
    }

    private void setupRunButton() {
        runButton.addActionListener(e -> display());

    }

    void setupRadioGroups() {
        this.typeRadioGroup = new RadioGroup(
                Arrays.asList(
                        typedRadioButton,
                        simplifiedRadioButton,
                        genericRadioButton),

                typedRadioButton,
                this::display);

        this.operationRadioGroup = new RadioGroup(
                Arrays.asList(calculateSpaceRadioButton,
                        calculateMultithreadedRadioButton,
                        calculatePipelineRadioButton),
                calculateSpaceRadioButton,
                this::display
        );
    }

    void addCercle(ActionEvent a) {
        if (circleFields.hasValidFields()) {
            this.formes.add(this.circleFields.value());
            this.circleFields.reset();
            this.display();
        }
    }

    void addRectangle(ActionEvent a) {
        if (rectangleFields.hasValidFields()) {
            this.formes.add(this.rectangleFields.value());
            this.rectangleFields.reset();
            this.display();
        }
    }
}
