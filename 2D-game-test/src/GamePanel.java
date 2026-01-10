import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    private final int originalTileSize = 16;
    private final int scale = 3;

    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    private Thread gameThread;
    private final KeyHandler keyHandler = new KeyHandler();
    private final Random random = new Random();
    private ArrayList<Point> bodySegments = new ArrayList<>();

    private int playerX = 100;
    private int playerY = 100;
    private int appleX;
    private int appleY;
    private final int playerSpeed = 4;

    private int fps = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        bodySegments.add(new Point(playerX - tileSize, playerY));
        bodySegments.add(new Point(playerX - tileSize * 2, playerY));
        bodySegments.add(new Point(playerX - tileSize * 3, playerY));

        this.appleX = randomAppleX();
        this.appleY = randomAppleY();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                checkCollision();
                repaint();
                delta--;
            }

        }
    }

    public void update() {
        int oldX = playerX;
        int oldY = playerY;

        if (keyHandler.isUpPressed()) playerY -= playerSpeed;
        else if (keyHandler.isDownPressed()) playerY += playerSpeed;
        else if (keyHandler.isLeftPressed()) playerX -= playerSpeed;
        else if (keyHandler.isRightPressed()) playerX += playerSpeed;

        if (playerX < 0) playerX = 0;
        if (playerX + 16 > getWidth()) {
            playerX = getWidth() - 16;
        }
        if (playerY < 0) playerY = 0;
        if (playerY + 16 > getHeight()) {
            playerY = getHeight() - 16;
        }

        if (!bodySegments.isEmpty()) {
            for (int i = bodySegments.size() - 1; i > 0; i--) {
                bodySegments.get(i).x = bodySegments.get(i - 1).x;
                bodySegments.get(i).y = bodySegments.get(i - 1).y;
            }
            bodySegments.getFirst().x = oldX;
            bodySegments.getFirst().y = oldY;
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        paintApple(graphics);
        paintSnake(graphics);
    }

    private void checkCollision() {
        if (Math.abs(playerX - appleX) < tileSize &&
                Math.abs(playerY - appleY) < tileSize) {

            if (bodySegments.isEmpty()) {
                bodySegments.add(new Point(playerX, playerY));
            } else {
                Point lastSegment = bodySegments.getLast();
                bodySegments.add(new Point(lastSegment.x, lastSegment.y));
            }

            createNewApple();
        }
    }

    private void paintApple(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(appleX, appleY, tileSize, tileSize);
    }

    private void paintSnake(Graphics graphics) {
        graphics.setColor(Color.green.darker());
        for (Point segment : bodySegments) {
            graphics.fillRect(segment.x, segment.y, tileSize, tileSize);
        }

        graphics.setColor(Color.green);
        graphics.fillRect(playerX, playerY, tileSize, tileSize);;
    }

    private void createNewApple() {
        appleX = randomAppleX();
        appleY = randomAppleY();
    }

    private int randomAppleX() {
        int cols = screenWidth / tileSize;
        return random.nextInt(cols) * tileSize;
    }

    private int randomAppleY() {
        int rows = screenHeight / tileSize;
        return random.nextInt(rows) * tileSize;
    }
}
