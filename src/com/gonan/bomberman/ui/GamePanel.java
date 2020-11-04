package com.gonan.bomberman.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.gonan.bomberman.entity.Bomb;
import com.gonan.bomberman.entity.Player;
import com.gonan.bomberman.scenario.Map;
import com.gonan.bomberman.entity.Bomb.State;
import com.gonan.bomberman.entity.BombExplosion;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static int PANEL_WIDTH = 1296;
	public static int PANEL_HEIGHT = 720;
	public static int UNIT_WIDTH = 27;
	public static int UNIT_HEIGHT = 15;
	public static float SCALE = 3f;
	public static final int DELAY = 50;
	
	private BufferedImage imgPlayer;
	private BufferedImage imgBomb;
	private BufferedImage imgExplosion;
	private BufferedImage imgMap;
	private final List<Bomb> bombs;
	private final List<BombExplosion> bombExplosions;
	private Map map;
	private final Player player;
	private final Timer timer; 

	public GamePanel() {
		
		try {
			imgPlayer = ImageIO.read(new File("res/bomberman.png"));
			imgBomb = ImageIO.read(new File("res/bomb.png"));
			imgExplosion = ImageIO.read(new File("res/explosion.png"));
			imgMap = ImageIO.read(new File("res/stage1_blocks.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		timer = new Timer(DELAY, this);
		player = new Player(imgPlayer, 48, 0, 4, 3, SCALE);
		bombs = new ArrayList<>();
		bombExplosions = new ArrayList<>();
		map = new Map(imgMap, UNIT_HEIGHT, UNIT_WIDTH, SCALE);
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
	            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.setMoving(true);
                    player.setDirection(Player.Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    player.setMoving(true);
                    player.setDirection(Player.Direction.DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setMoving(true);
                    player.setDirection(Player.Direction.RIGHT);
                    break;
                case KeyEvent.VK_LEFT:
                    player.setMoving(true);
                    player.setDirection(Player.Direction.LEFT);
                    break;
                case KeyEvent.VK_A:
                	float centralX = player.getX() + player.getW() / 2;
                	float centralY = player.getY() + 3 * player.getH() / 4;
                	bombs.add(new Bomb(imgBomb, (int)(centralX / player.getW()) * player.getW(), (int)(centralY / player.getW()) * player.getW(), 1, 4, SCALE));
                	break;
                default:
                    break;
	            }
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
	            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_LEFT:
                    player.setMoving(false);
                    break;
                default:
                    break;
	            }
			}
			
		});
		
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		map.draw((Graphics2D)g);
		for (Bomb b : bombs) b.draw((Graphics2D)g);
		for (BombExplosion be : bombExplosions) be.draw((Graphics2D)g, map.getLayout());
		player.draw((Graphics2D)g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (Bomb b : bombs) {
			if (b.getState() == State.EXPLODE) {
				bombExplosions.add(new BombExplosion(imgExplosion, b.getX(), b.getY(), 6, 0, 5, 7, SCALE));
				bombs.remove(b);
				break;
			}
		}
		
		bombExplosions.removeIf(BombExplosion::isEnded);
		
		player.move(map.getLayout());
		repaint();
	}
}
