package grx.dod.demo.tp.ihm.components.fields;

import grx.dod.demo.tp.datastructures.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.generic.GenericScenario;
import grx.dod.demo.tp.datastructures.simplified.SimplifiedScenario;

import javax.swing.*;

public class TimeResultLabel {


    private final JLabel label;
    public TimeResultLabel(JLabel label) {
        this.label = label;
        displayOrHide();
    }

    private void displayOrHide() {
        if (label.getText().equals("")) {
            label.setEnabled(false);
        }
    }

    public void setGenericTime(long time, String processType) {
        this.label.setText("Le "  + getTypeString(processType) + " avec object generique a pris " + time + " millisecondes");
        this.displayOrHide();
    }

    public void setTypedTime(long time, String processType) {
        this.label.setText("Le " + getTypeString(processType) + " avec object type a pris " + time + " millisecondes");
        this.displayOrHide();
    }

    public void setSimplifiedTypeTime(long time, String processType) {
        this.label.setText("Le " + getTypeString(processType) + " avec object simplifie a pris " + time + " millisecondes");
        this.displayOrHide();
    }

    public void setTimeLabel(DataStructureScenario<?> scenario, long time, String processType) {
        if (scenario instanceof GenericScenario) {
            setGenericTime(time, processType);
        } else if (scenario instanceof SimplifiedScenario) {
            setSimplifiedTypeTime(time, processType);
        } else {
            setTypedTime(time, processType);
        }
    }


    private String getTypeString(String processType) {
        switch(processType) {
            case "espace":
                return "calcul de l'espace d'occupation";
            case "pipeline":
                return "traitement par pipeline";
            case "thread":
                return "traitement multithread";
            default:
                return "eh";
        }
    }
}
