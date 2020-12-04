package com.gonan.bomberman.scenario.collection;

import java.util.ArrayList;
import java.util.List;

import com.gonan.bomberman.scenario.Block;
import com.gonan.bomberman.scenario.Block.BlockType;

import java.awt.Graphics2D;

public class BlockList {
    
    private List<Block> blocks;

    public BlockList() {
        this.blocks = new ArrayList<>();
    }

    public void render(Graphics2D g) {
        for (Block b : blocks) b.render(g);
    }

    public void add(Block b) {
        blocks.add(b);
    }

    public void destroy(Block b) {
        if (b.getType() == BlockType.DESTROYABLE) blocks.remove(b);
    }
}
