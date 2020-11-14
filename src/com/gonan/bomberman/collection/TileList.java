package com.gonan.bomberman.collection;

import com.gonan.bomberman.graphic.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TileList {

    private List<Tile> tiles;

    public TileList() {
        tiles = new ArrayList<>();
    }

    public void add(Tile t) {
        tiles.add(t);
    }

    public void remove(Tile t) {
        tiles.remove(t);
    }

    public void draw(Graphics2D g2d) {
        for (var tile : tiles) tile.draw(g2d);
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
