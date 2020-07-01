package net.runelite.client.plugins.externals.anon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class NpcMinimapOverlay extends Overlay
{
    private final NpcIndicatorsPlugin plugin;
    private final NpcIndicatorsConfig config;

    @Inject
    NpcMinimapOverlay(final NpcIndicatorsPlugin plugin, final NpcIndicatorsConfig config)
    {
        this.plugin = plugin;
        this.config = config;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        for (NPC npc : plugin.getHighlightedNpcs())
        {
            renderNpcOverlay(graphics, npc, npc.getName(), config.getHighlightColor());
        }

        return null;
    }

    private void renderNpcOverlay(Graphics2D graphics, NPC actor, String name, Color color)
    {
        NPCDefinition npcDefinition = actor.getTransformedDefinition();
        if (npcDefinition == null || !npcDefinition.isInteractible()
                || (actor.isDead() && config.ignoreDeadNpcs()))
        {
            return;
        }

        final Point minimapLocation = actor.getMinimapLocation();

        if (minimapLocation != null)
        {
            OverlayUtil.renderMinimapLocation(graphics, minimapLocation, color.darker());

            if (config.drawMinimapNames())
            {
                OverlayUtil.renderTextLocation(graphics, minimapLocation, name, color);
            }
        }
    }
}