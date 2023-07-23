package com.afkprayer;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class AfkPrayerOverlay extends OverlayPanel{

    @Inject
    private Client client;

    @Inject
    private AfkPrayerConfig config;

    @Inject
    AfkPrayerOverlay(Client client, AfkPrayerPlugin plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPriority(OverlayPriority.LOW);
        setMovable(true);
        this.client = client;
    }


    @Override
    public Dimension render(Graphics2D graphics) {
        if (config.renderPrayer()) renderPrayer();

        return super.render(graphics);
    }

    void renderPrayer(){
        setPreferredSize(new Dimension(config.prayerSize().width, 0));
        if (client.getRealSkillLevel(Skill.PRAYER) <= config.prayerThreshold()) {
            AfkPrayerUtils.buildPanel(
                    panelComponent,
                    0,
                    client.getRealSkillLevel(Skill.PRAYER),
                    client.getBoostedSkillLevel(Skill.PRAYER),
                    Color.red,
                    config.prayerSize(),
                    config.totalLabels(),
                    config.showLabels()
            );
        } else {
            AfkPrayerUtils.buildPanel(
                    panelComponent,
                    0,
                    client.getRealSkillLevel(Skill.PRAYER),
                    client.getBoostedSkillLevel(Skill.PRAYER),
                    config.prayerColour(),
                    config.prayerSize(),
                    config.totalLabels(),
                    config.showLabels()
            );
        }
    }
}
