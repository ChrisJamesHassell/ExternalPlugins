/*
 * Copyright (c) 2019-2020, ganom <https://github.com/Ganom>
 * All rights reserved.
 * Licensed under GPL3, see LICENSE for the full scope.
 */
package net.runelite.client.plugins.externals.anon;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("npcindicators")
public interface NpcIndicatorsConfig extends Config
{
	@ConfigItem(
			position = 0,
			keyName = "highlightStyle",
			name = "Highlight Style",
			description = "Highlight setting"
	)
	default RenderStyle renderStyle()
	{
		return RenderStyle.THIN_OUTLINE;
	}

	@ConfigItem(
			position = 1,
			keyName = "npcToHighlight",
			name = "NPCs to Highlight",
			description = "List of NPC names to highlight"
	)
	default String getNpcToHighlight()
	{
		return "";
	}

	@ConfigItem(
			position = 2,
			keyName = "npcColor",
			name = "Highlight Color",
			description = "Color of the NPC highlight"
	)
	default Color getHighlightColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
			position = 2,
			keyName = "interactingColor",
			name = "Interacting Color",
			description = "Color of the NPC highlight when targeting local player"
	)
	default Color getInteractingColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			position = 3,
			keyName = "drawNames",
			name = "Draw names above NPC",
			description = "Configures whether or not NPC names should be drawn above the NPC"
	)
	default boolean drawNames()
	{
		return false;
	}

	@ConfigItem(
			position = 4,
			keyName = "drawInteracting",
			name = "Draw target name above NPC",
			description = "Configures whether the name of the NPC's target is drawn above it's head"
	)
	default boolean drawInteracting()
	{
		return false;
	}

	@ConfigItem(
			position = 5,
			keyName = "drawMinimapNames",
			name = "Draw names on minimap",
			description = "Configures whether or not NPC names should be drawn on the minimap"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
			position = 6,
			keyName = "highlightMenuNames",
			name = "Highlight menu names",
			description = "Highlight NPC names in right click menu"
	)
	default boolean highlightMenuNames()
	{
		return false;
	}

	@ConfigItem(
			position = 7,
			keyName = "ignoreDeadNpcs",
			name = "Ignore dead NPCs",
			description = "Prevents highlighting NPCs after they are dead"
	)
	default boolean ignoreDeadNpcs()
	{
		return true;
	}

	@ConfigItem(
			position = 8,
			keyName = "deadNpcMenuColor",
			name = "Dead NPC menu color",
			description = "Color of the NPC menus for dead NPCs"
	)
	Color deadNpcMenuColor();

	@ConfigItem(
			position = 9,
			keyName = "showRespawnTimer",
			name = "Show respawn timer",
			description = "Show respawn timer of tagged NPCs"
	)
	default boolean showRespawnTimer()
	{
		return false;
	}

	@ConfigItem(
			position = 10,
			keyName = "notifyOnRespawn",
			name = "Notify on Respawn",
			description = "Enable notification on respawn"
	)
	default boolean getNotifyOnRespawn()
	{
		return false;
	}

	@ConfigItem(
			position = 11,
			keyName = "notifyOnRespawnDelay",
			name = "Notification Delay",
			description = "Notify when NPC is x ms from respawning"
	)
	@Units(Units.MILLISECONDS)
	default int getNotifyOnRespawnDelay()
	{
		return -1;
	}
}