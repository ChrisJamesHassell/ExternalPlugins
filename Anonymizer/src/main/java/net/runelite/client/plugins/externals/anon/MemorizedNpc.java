package net.runelite.client.plugins.externals.anon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.coords.WorldPoint;

@Getter(AccessLevel.PACKAGE)
class MemorizedNpc
{
    private int npcId;
    private int npcIndex;
    private Set<String> npcNames;
    private int npcSize;
    /**
     * The time the npc died at, in game ticks, relative to the tick counter
     */
    @Setter(AccessLevel.PACKAGE)
    private int diedOnTick;
    /**
     * The time it takes for the npc to respawn, in game ticks
     */
    @Setter(AccessLevel.PACKAGE)
    private int respawnTime;
    @Setter(AccessLevel.PACKAGE)
    private List<WorldPoint> possibleRespawnLocations;

    MemorizedNpc(final NPC npc)
    {
        this.npcNames = new HashSet<>();
        this.npcNames.add(npc.getName());
        this.npcIndex = npc.getIndex();
        this.npcId = npc.getId();
        this.possibleRespawnLocations = new ArrayList<>();
        this.respawnTime = -1;
        this.diedOnTick = -1;

        final NPCDefinition composition = npc.getTransformedDefinition();

        if (composition != null)
        {
            this.npcSize = composition.getSize();
        }
    }
}