package com.afkprayer;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import java.awt.*;

public class AfkPrayerUtils {

    static void buildPanel(PanelComponent panelComponent, int minimum, int maximum, float value, Color foregroundColour, Dimension size, boolean totalLabels, boolean showLabels) {
        ProgressBarComponent progressBar = new ProgressBarComponent();
        progressBar.setMinimum(minimum);
        progressBar.setMaximum(maximum);
        progressBar.setValue(value);
        progressBar.setBackgroundColor(Color.BLACK);
        progressBar.setForegroundColor(foregroundColour);
        progressBar.setFontColor(Color.WHITE);
        progressBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);



        if (!showLabels) {
            progressBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.TEXT_ONLY);
        } else {
            if (!totalLabels){
                progressBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.TEXT_ONLY);
                progressBar.setCenterLabel(String.valueOf((int) value));
            }
        }


        ProgressBarComponent paddingBar = new ProgressBarComponent();
        paddingBar.setMinimum(minimum);
        paddingBar.setMaximum(maximum);
        paddingBar.setValue(value);
        paddingBar.setBackgroundColor(Color.BLACK);
        paddingBar.setForegroundColor(foregroundColour);
        paddingBar.setFontColor(Color.WHITE);
        paddingBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.TEXT_ONLY);
        // Set height of bar by padding the top and bottom with empty lines
        for (int i = 0; i < size.height; i++){
            panelComponent.getChildren().add(paddingBar);
        }

        panelComponent.getChildren().add(progressBar);

        for (int i = 0; i < size.height; i++){
            panelComponent.getChildren().add(paddingBar);
        }
    }
}
