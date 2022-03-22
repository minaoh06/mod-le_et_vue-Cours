package vue;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.Collection;

public class VBoxRoot extends VBox {
    public VBoxRoot(){
        DateCalendrier today = new DateCalendrier();
        CalendrierDuMois cal = new CalendrierDuMois(3,2022);
        VBox date = new VBox();
        Collection<DateCalendrier> dateColl = cal.getDates();
        for(DateCalendrier x : dateColl)
        {
            date.getChildren().add(new Label(x.toString()));
            if (x.compareTo(today) == 0){
                date.getChildren().get(date.getChildren().size()-1).setId("today");
            }
        }
        this.getChildren().addAll(
                new Label("Mois : " + cal.getMois() + " Annee : " + cal.getAnnee()),
                new ScrollPane(date)
        );
    }
}
