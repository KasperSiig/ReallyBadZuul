package BE;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private List<Item> items;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList();
    }

    /**
     * Define the exits of this room. Every direction either leads to another
     * room or is null (no exit there).
     *
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += "  " + exit;
        }
        return returnString;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }
    
    public String getLongDescription() {
        return "You are " + getDescription() + ".\n" + getExitString() + printItems();
    }

    public void addItem(Item item) {
        items.add(item);
    }
    
    public String printItems() {

        if (!items.isEmpty()) {
            String returnString = "";
            returnString += "\nThis room contains following items:\n";
            for (Item item : items) {
                returnString += "\t" + item.getDescription() + ": Weighs " + item.getWeight() + "Kg";
            }
            return returnString;
        }
        return "";
    }
}
