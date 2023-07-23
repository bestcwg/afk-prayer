package com.afkprayer;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Afk Prayer"
)
public class AfkPrayerPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private AfkPrayerConfig config;

	@Inject
	private AfkPrayerOverlay afkPrayerOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Afk Prayer started!");
		overlayManager.add(afkPrayerOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Afk Prayer stopped!");
		overlayManager.remove(afkPrayerOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Afk Prayer says " + config.greeting(), null);
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Afk Prayer says " + client.getFPS(), null);
		}
	}

	@Provides
	AfkPrayerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AfkPrayerConfig.class);
	}
}
