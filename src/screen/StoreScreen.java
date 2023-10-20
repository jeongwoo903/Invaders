package screen;

import java.awt.event.KeyEvent;
import engine.Cooldown;
import engine.Core;
import engine.EnhanceManager;
import engine.GameSettings;
import engine.GameState;
import engine.SoundEffect;
import entity.Coin;

public class StoreScreen extends Screen {
    /** Milliseconds between changes in user selection. */
    private static final int SELECTION_TIME = 200;

    /** Time between changes in user selection. */
    private Cooldown selectionCooldown;
    /** For selection moving sound */
    private SoundEffect soundEffect;

    private Coin coin;

    private int PST;

    private int BST;
    private EnhanceManager enhanceManager;
    private GameState gameState;
    /**
     * Constructor, establishes the properties of the screen.
     *
     * @param width
     *               Screen width.
     * @param height
     *               Screen height.
     * @param fps
     *               Frames per second, frame rate at which the game is run.
     */
    public StoreScreen(final int width, final int height, final int fps, final GameState gameState, final EnhanceManager enhanceManager) {
        super(width, height, fps);
        // Defaults to play.
        this.returnCode = 35;
        this.BST = enhanceManager.getNumEnhanceStoneArea();
        this.PST = enhanceManager.getNumEnhanceStoneAttack();
        this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
        this.selectionCooldown.reset();
        this.coin = gameState.getCoin();
        this.gameState = gameState;
        this.enhanceManager = enhanceManager;
        soundEffect = new SoundEffect();
    }

    /**
     * Starts the action.
     *
     * @return Next screen code.
     */
    public final int run() {
        super.run();

        return this.returnCode;
    }

    /**
     * Updates the elements on screen and checks for events.
     */
    protected final void update() {
        super.update();

        draw();
        if (this.selectionCooldown.checkFinished()
                && this.inputDelay.checkFinished()) {
            if (inputManager.isKeyDown(KeyEvent.VK_UP)
                    || inputManager.isKeyDown(KeyEvent.VK_W)) {
                soundEffect.playButtonClickSound();
                UpMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
                    || inputManager.isKeyDown(KeyEvent.VK_S)) {
                soundEffect.playButtonClickSound();
                DownMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_RIGHT)
                    || inputManager.isKeyDown(KeyEvent.VK_D)) {
                soundEffect.playButtonClickSound();
                rightMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_LEFT)
                    || inputManager.isKeyDown(KeyEvent.VK_A)) {
                soundEffect.playButtonClickSound();
                leftMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE)) {
                soundEffect.playSpaceButtonSound();
                if (returnCode == 35){
                    if (this.coin.getCoin() >= 10)
                    {
                        this.enhanceManager.PlusNumEnhanceStoneArea(1);
                        this.coin.minusCoin(10);
                        System.out.println("plese do");
                    }
                    else{
                        
                    }
                }
                if (returnCode == 36 && gameState != null){
                    if (this.coin.getCoin() >= 10)
                    {
                        this.enhanceManager.PlusNumEnhanceStoneArea(1);
                        this.coin.minusCoin(10);
                        System.out.println("plese do");
                    }
                    else{

                    }
                }
                if (returnCode == 37 && gameState != null){
                    if (this.coin.getCoin() >= 10)
                    {
                        this.enhanceManager.PlusNumEnhanceStoneArea(1);
                        this.coin.minusCoin(10);
                        System.out.println("plese do");
                    }
                    else{
                        
                    }
                }
                if (returnCode == 38 && gameState != null){
                    if (this.coin.getCoin() >= 10)
                    {
                        this.enhanceManager.PlusNumEnhanceStoneArea(1);
                        this.coin.minusCoin(10);
                        System.out.println("plese do");
                    }
                    else{
                        
                    }
                }
                this.isRunning = false;
            }
        }
    }
    private void UpMenuItem() {
        if (this.returnCode == 35)
            this.returnCode = 14;
        else if (this.returnCode == 14)
            this.returnCode = 37;
        else if (this.returnCode == 37)
            this.returnCode = 35;
        else if (this.returnCode == 36)
            this.returnCode = 15;
        else if (this.returnCode == 15)
            this.returnCode = 38;
        else if (this.returnCode == 38)
            this.returnCode = 36;
    }
    private void DownMenuItem() {
        if (this.returnCode == 35)
            this.returnCode = 37;
        else if (this.returnCode == 37)
            this.returnCode = 14;
        else if (this.returnCode == 14)
            this.returnCode = 35;
        else if (this.returnCode == 36)
            this.returnCode = 38;
        else if (this.returnCode == 38)
            this.returnCode = 15;
        else if (this.returnCode == 15)
            this.returnCode = 36;
    }
    private void rightMenuItem() {
        if (this.returnCode == 35)
            this.returnCode = 36;
        else if (this.returnCode == 36)
            this.returnCode = 35;
        else if (this.returnCode == 37)
            this.returnCode = 38;   
        else if (this.returnCode == 38)
            this.returnCode = 37;
        else if (this.returnCode == 14)
            this.returnCode = 2;
        else if (this.returnCode == 2)
            this.returnCode = 15;
        else if (this.returnCode == 15)
            this.returnCode = 14;                                                     
    }

    private void leftMenuItem() {
        if (this.returnCode == 35)
            this.returnCode = 36;
        else if (this.returnCode == 36)
            this.returnCode = 35;
        else if (this.returnCode == 37)
            this.returnCode = 38;   
        else if (this.returnCode == 38)
            this.returnCode = 37;
        else if (this.returnCode == 14)
            this.returnCode = 15;  
        else if (this.returnCode == 15)
            this.returnCode = 2;
        else if (this.returnCode == 2)
            this.returnCode = 14;            
    }
    /**
     * Draws the elements associated with the screen.123
     */
    private void draw() {
        drawManager.initDrawing(this);
        drawManager.drawCoin(this, this.coin, 2);
        drawManager.drawItemStore(this, this.returnCode, PST, BST);
        drawManager.completeDrawing(this);
    }
    
    /**
	 * Returns a DrawManager object representing the status of the game.
	 *
	 * @return Current game state.
	 */
    public EnhanceManager getEnhanceManager() {
		return this.enhanceManager;
	}

    public GameState getGameState() {
        return this.gameState;
    }
}
