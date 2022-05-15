package grx.dod.demo.tp.ihm;

import grx.dod.demo.tp.Drawer;
import grx.dod.demo.tp.Infrastructure.FormesWriter;
import grx.dod.demo.tp.Infrastructure.FormsParser;
import grx.dod.demo.tp.datastructures.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.generic.GenericScenario;
import grx.dod.demo.tp.datastructures.simplified.SimplifiedScenario;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.TypedScenario;
import grx.dod.demo.tp.ihm.components.RadioGroup;
import grx.dod.demo.tp.ihm.components.fields.CircleFields;
import grx.dod.demo.tp.ihm.components.fields.RectangleFields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    private JLabel rectangleAmount;
    private JLabel circleAmount;
    private JButton saveButton;

    private List<Forme> formes;
    private Drawer drawer = new Drawer();

    private SimplifiedScenario simplifiedScenario;
    private TypedScenario typedScenario;
    private GenericScenario genericScenario;

    private final FormesWriter writer = new FormesWriter();
    private final String filepath = "src/main/resources/espace.txt";

    public MainPanel() throws Exception {
        this.setupRadioGroups();
        this.setupRunButton();
        this.setupCreationFields();
        this.loadFormes();
        this.setFormesAmountTexts();
        this.setupSaveButton();
        display();
    }

    private void setupSaveButton() {
        this.saveButton.addActionListener(e -> {
            try {
                writer.writeTo(filepath, this.formes);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void setFormesAmountTexts() {
        this.circleAmount.setText("Il y a " + this.countForme(Forme.CERCLE) + " cercle(s).");
        this.rectangleAmount.setText("Il y a " + this.countForme(Forme.RECTANGLE) + " rectangle(s).");
    }

    private long countForme(String formeType) {
        return this.formes.stream().filter(forme -> Objects.equals(forme.type, formeType)).count();
    }

    private void setupCreationFields() {
        this.circleFields = new CircleFields(circleColor, circleX, circleY, circleRadius);
        this.rectangleFields = new RectangleFields(rectangleColor, rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        this.addCercleButton.addActionListener(this::addCercle);
        this.addRectangleButton.addActionListener(this::addRectangle);
    }

    private void loadFormes() throws Exception {
        this.formes = new FormsParser().parse(filepath);
        this.simplifiedScenario = new SimplifiedScenario();
        this.genericScenario = new GenericScenario();
        this.typedScenario = new TypedScenario();
        this.loadScenarios();
    }

    // Reset scenarios with the right amount of formes
    private void loadScenarios() {
        simplifiedScenario.loadFormes(this.formes);
        genericScenario.loadFormes(this.formes);
        typedScenario.loadFormes(this.formes);
    }

    private void display() {
        this.drawer.draw(this.formes);
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
                this::run);

        this.operationRadioGroup = new RadioGroup(
                Arrays.asList(calculateSpaceRadioButton,
                        calculateMultithreadedRadioButton,
                        calculatePipelineRadioButton),
                calculateSpaceRadioButton,
                this::run
        );
    }

    void addCercle(ActionEvent a) {
        if (circleFields.hasValidFields()) {
            this.formes.add(this.circleFields.value());
            this.loadScenarios();
            this.setFormesAmountTexts();
            this.circleFields.reset();
            this.display();
        }
    }

    void addRectangle(ActionEvent a) {
        if (rectangleFields.hasValidFields()) {
            this.formes.add(this.rectangleFields.value());
            this.loadScenarios();
            this.setFormesAmountTexts();
            this.rectangleFields.reset();
            this.display();
        }
    }


    void run()  {
        DataStructureScenario<?> scenario = this.getSelectedScenario();

        try {
            runTp(scenario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void runTp(DataStructureScenario<?> scenario) throws Exception {
        if (calculateSpaceRadioButton.isSelected()) {
            long time = scenario.tp1();
            displayCalculateSpaceTime(scenario, time);
        }

        if (calculatePipelineRadioButton.isSelected()) {
            long time = scenario.tp2();
            displayCalculatePipelineTime(scenario, time);
        }

        if (calculateMultithreadedRadioButton.isSelected()) {
            long time = scenario.tp3();
            displayCalculateMultithreadedTime(scenario, time);
        }
    }

    private void displayCalculateMultithreadedTime(DataStructureScenario<?> scenario, long time) {

    }

    private void displayCalculatePipelineTime(DataStructureScenario<?> scenario, long time) {

    }

    private void displayCalculateSpaceTime(DataStructureScenario<?> scenario, long time) {

    }

    private DataStructureScenario<?> getSelectedScenario() {
        if (genericRadioButton.isSelected()){
            return genericScenario;
        }

        if (simplifiedRadioButton.isSelected()){
            return simplifiedScenario;
        }

        return typedScenario;
    }
}
