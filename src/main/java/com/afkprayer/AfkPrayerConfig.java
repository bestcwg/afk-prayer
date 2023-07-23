package com.afkprayer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.ui.overlay.components.ComponentConstants;

import java.awt.*;

@ConfigGroup("afkprayer")
public interface AfkPrayerConfig extends Config
{
	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "Hello du";
	}

	@ConfigItem(
			position = 1,
			keyName = "showPrayer",
			name = "Show Prayer",
			description = "Render Prayer overlay"
	)

	default boolean renderPrayer() { return false; }

	@ConfigItem(
		position = 2,
		keyName = "prayerColour",
		name = "Prayer Colour",
		description = "Choose the background colour of the prayer bar"
	)
	default Color prayerColour() { return Color.CYAN; }

	@ConfigItem(
		position = 3,
		keyName = "prayerSize",
		name = "Prayer Size",
		description = "Choose the size of the Prayer bar"
	)
	default Dimension prayerSize() { return new Dimension(ComponentConstants.STANDARD_WIDTH, 0); }

	@ConfigItem(
		position = 4,
		keyName = "totalLabels",
		name = "Total Labels",
		description = "Show the label as a fraction of the whole value"
	)

	default boolean totalLabels() { return true; }

	@ConfigItem(
		position = 5,
		keyName = "showLabels",
		name = "Show Labels",
		description = "Show labels on the minibars"
	)

	default boolean showLabels() { return true; }

	@ConfigItem(
			position = 6,
			keyName = "prayerThreshold",
			name = "Prayer Threshold",
			description = "Threshold for notification"
	)

	default int prayerThreshold() { return 10; }
}
