package com.gonan.bomberman.scenario.collection;

import java.util.ArrayList;
import java.util.List;

import com.gonan.bomberman.entity.DestroyableBlock;

import java.awt.Graphics2D;

public class BlockList {
    
    private List<DestroyableBlock> blocks;

    public BlockList() {
        this.blocks = new ArrayList<>();
    }

    public void render(Graphics2D g) {
        for (DestroyableBlock b : blocks) b.render(g);
    }

    public void add(DestroyableBlock b) {
        blocks.add(b);
    }

    public boolean destroy(DestroyableBlock b) {
        return blocks.remove(b);
    }
}
